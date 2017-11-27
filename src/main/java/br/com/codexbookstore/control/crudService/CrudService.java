package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.business.book.BookNotBlank;
import br.com.codexbookstore.business.book.views.RetrieveAuthors;
import br.com.codexbookstore.business.book.views.RetrieveBookCategories;
import br.com.codexbookstore.business.customer.*;
import br.com.codexbookstore.business.sales.BookInStock;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.domain.sale.ShopCart;
import br.com.codexbookstore.persistence.dao.IDAO;
import br.com.codexbookstore.persistence.dao.book.BookDAO;

import java.sql.SQLException;
import java.util.*;

public class CrudService implements ICrudService {

    // { entity: { rules: [IStrategy, IStrategy] } }
    private Map<String, Map<String, List<IStrategy>>> requirements;
    private Map<String, IDAO> daos;
    private Result result;

    private static final String CREATE = "CREATE";
    private static final String RETRIEVE = "RETRIEVE";
    private static final String UPDATE = "UPDATE";
    private static final String INSERTFORM = "INSERTFORM";
    private static final String EDITFORM = "EDITFORM";

    public CrudService() {
        // # Data retrieve
        result = new Result();

        // # Entities
        String bookEntity = Book.class.getSimpleName();
        String customerEntity = Customer.class.getSimpleName();
        String shopCartEntity = ShopCart.class.getSimpleName();

        // # Validations and Business rules
        // ## Combo box for views
        List<IStrategy> booksComboBoxes = Arrays.asList(new RetrieveBookCategories(), new RetrieveAuthors());
        List<IStrategy> customerComboBoxes = Arrays.asList(new ListCountries(), new ListStates(), new ListCities());
        
        // ## Book validations and business rules
        List<IStrategy> createBookValidations = Arrays.asList(new BookNotBlank());

        // ## Customer validations and business rules
        List<IStrategy> createCustomerValidations = Arrays.asList(new CustomerNotBlank(), new CreditCardValidation(), new PasswordValitation());

        // ## ShopCart validations and business rules
        List<IStrategy> shopCartStrategies = Arrays.asList(new BookInStock());

        // # set validations by context
        // book crud
        Map<String, List<IStrategy>> bookValidations = new HashMap<>();
        bookValidations.put(INSERTFORM, booksComboBoxes);
        bookValidations.put(EDITFORM, booksComboBoxes);
        bookValidations.put(CREATE, createBookValidations);
        bookValidations.put(RETRIEVE, new ArrayList<>());
        bookValidations.put(UPDATE, createBookValidations);

        // customer crud
        Map<String, List<IStrategy>> customerValidations = new HashMap<>();
        customerValidations.put(INSERTFORM, customerComboBoxes);
        customerValidations.put(CREATE, createCustomerValidations);

        // shopCart
        Map<String, List<IStrategy>> shopCartValidations = new HashMap<>();
        shopCartValidations.put(CREATE, shopCartStrategies);

        // # persistence layer
        daos = new HashMap<>();
        daos.put(bookEntity, new BookDAO());

        // # all requirements
        requirements = new HashMap<>();
        requirements.put(bookEntity, bookValidations);
        requirements.put(customerEntity, customerValidations);
        requirements.put(shopCartEntity, shopCartValidations);
    }

    @Override
    public Result create(Entity entity) {
        String entityName = entity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(entityName);
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(CREATE);

        result = executeValidations(entity, validations);

        if(!result.hasErrors() && dao != null) { // break any validation?
            if(!dao.create(entity)) { // persistence errors?
                result.addErrorMsg("Error!!!");
            }
        }

        return result;
    }

    @Override
    public Result retrieve(Entity entity) {
        String entityName = entity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(entityName);
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(RETRIEVE);

        result = executeValidations(entity, validations);

        if(!result.hasErrors()) {
            try {
                result.putEntities(dao.retrieve("1 = 1"));
            } catch(RuntimeException e) {
                result.addErrorMsg(e.getMessage());
            }
        }

        return result;
    }

    @Override
    public Result update(Entity entity) {
        String entityName = entity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(entityName);
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(UPDATE);

        result = executeValidations(entity, validations);

        if(!result.hasErrors()) {
            if(!dao.update(entity)) {
                result.addErrorMsg("Error!!!");
            }
        }

        return result;
    }

    @Override
    public Result delete(Entity entity) {
        return null;
    }

    @Override
    public Result insertForm(Entity entity) {
        result = new Result();
        String entityName = entity.getClass().getSimpleName();

        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(INSERTFORM);

        result = executeValidations(entity, validations);

        return result;
    }

    @Override
    public Result editForm(Entity entity) {
    	String entityName = entity.getClass().getSimpleName();
    	String whereClause = "%s.id = %d";
    	IDAO dao = daos.get(entityName);
    	result = new Result();
        
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(EDITFORM);

        entity = dao.retrieve(String.format(whereClause, entityName.toLowerCase().charAt(0), entity.getId())).get(0);
        result = executeValidations(entity, validations);
        result.setEntity(entity);

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
