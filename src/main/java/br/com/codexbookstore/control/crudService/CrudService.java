package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.business.book.BookNotBlank;
import br.com.codexbookstore.business.book.views.RetrieveAuthors;
import br.com.codexbookstore.business.book.views.RetrieveBookCategories;
import br.com.codexbookstore.business.customer.*;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.persistence.dao.IDAO;
import br.com.codexbookstore.persistence.dao.book.BookDAO;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by everton on 24/09/17.
 */
public class CrudService implements ICrudService {

    // { entity: { rules: [IStrategy, IStrategy] } }
    private Map<String, Map<String, List<IStrategy>>> requirements;
    private Map<String, IDAO> daos;
    private Result result;

    private static final String CREATE = "CREATE";
    private static final String RETRIEVE = "RETRIEVE";
    private static final String UPDATE = "UPDATE";
    private static final String INSERTFORM = "INSERTFORM";

    public CrudService() {
        // # Data retrieve
        result = new Result();

        // # Entities
        String bookEntity = Book.class.getSimpleName();
        String customerEntity = Customer.class.getSimpleName();

        // # Validations and Business rules
        // ## Combo box for views
        List<IStrategy> booksComboBoxes = Arrays.asList(new RetrieveBookCategories(), new RetrieveAuthors());
        List<IStrategy> customerComboBoxes = Arrays.asList(new ListCountries(), new ListStates(), new ListCities());

        // ## Book validations and rules
        List<IStrategy> createBookValidations = Arrays.asList(new BookNotBlank());

        // ## Customer validations and rules
        List<IStrategy> createCustomerValidations = Arrays.asList(new CustomerNotBlank(), new CreditCardValidation(), new PasswordValitation());

        // # set validations by context
        Map<String, List<IStrategy>> bookValidations = new HashMap<>();
        bookValidations.put(INSERTFORM, booksComboBoxes);
        bookValidations.put(CREATE, createBookValidations);
        bookValidations.put(RETRIEVE, new ArrayList<>()); // mock validations

        Map<String, List<IStrategy>> customerValidations = new HashMap<>();
        customerValidations.put(INSERTFORM, customerComboBoxes);
        customerValidations.put(CREATE, createCustomerValidations);

        // # persistence layer
        daos = new HashMap<>();
        daos.put(bookEntity, new BookDAO());

        // # all requirements
        requirements = new HashMap<>();
        requirements.put(bookEntity, bookValidations);
        requirements.put(customerEntity, customerValidations);
    }

    @Override
    public Result create(Entity entity) {
        String klass = entity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(klass);
        Map<String, List<IStrategy>> rules = requirements.get(klass);
        List<IStrategy> validations = rules.get(CREATE);

        result = executeValidations(entity, validations);

        if(!result.hasErrors()) { // break any validations?
            if(!dao.create(entity)) { // persistence errors?
                result.addErrorMsg("Error!!!");
            }
        }

        return result;
    }

    @Override
    public Result retrieve(Entity entity) {
        return null;
    }

    @Override
    public Result update(Entity entity) {
        return null;
    }

    @Override
    public Result delete(Entity entity) {
        return null;
    }

    @Override
    public Result insertForm(Entity entity) {
        result = new Result();
        Map<String, List<IStrategy>> rules = requirements.get(entity.getClass().getSimpleName());
        List<IStrategy> validations = rules.get(INSERTFORM);
        result = executeValidations(entity, validations);
        return result;
    }

    private Result executeValidations(Entity entity, List<IStrategy> validations) {
        for(IStrategy validation : validations) {
            result = validation.process(entity, result);

            if(result.hasErrors()) {
                result.setEntity(entity);
                break;
            }
        }

        return result;
    }
}
