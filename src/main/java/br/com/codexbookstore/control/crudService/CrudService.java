package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.business.book.BookNotBlank;
import br.com.codexbookstore.business.book.views.RetrieveAuthors;
import br.com.codexbookstore.business.book.views.RetrieveBookCategories;
import br.com.codexbookstore.business.customer.*;
import br.com.codexbookstore.business.sales.BookInStock;
import br.com.codexbookstore.business.sales.UpdateCartTotalValue;
import br.com.codexbookstore.business.sales.ValidBookQuantity;
import br.com.codexbookstore.business.sales.order.RetrieveCustomer;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.User;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.domain.sale.Order;
import br.com.codexbookstore.domain.sale.OrderItem;
import br.com.codexbookstore.domain.sale.ShopCart;
import br.com.codexbookstore.persistence.dao.IDAO;
import br.com.codexbookstore.persistence.dao.book.BookDAO;
import br.com.codexbookstore.persistence.dao.sale.OrderDAO;

import java.util.*;

public class CrudService implements ICrudService {

    // { entity: { rules: [IStrategy, IStrategy] } }
    private Map<String, Map<String, List<IStrategy>>> requirements;
    private Map<String, IDAO> daos;
    private Result result;

    private static final String CREATE = "CREATE";
    private static final String RETRIEVE = "RETRIEVE";
    private static final String UPDATE = "UPDATE";
    private static final String DELETE = "DELETE";
    private static final String INSERTFORM = "INSERTFORM";
    private static final String EDITFORM = "EDITFORM";

    public CrudService() {
        // # Data retrieve
        result = new Result();

        // # Entities
        String bookEntity = Book.class.getSimpleName();
        String customerEntity = Customer.class.getSimpleName();
        String shopCartEntity = ShopCart.class.getSimpleName();
        String itemEntity = OrderItem.class.getSimpleName();
        String orderEntity = Order.class.getSimpleName();
        String userEntity = User.class.getSimpleName();

        // # Validations and Business rules
        // Combo box for views
        List<IStrategy> booksComboBoxes = Arrays.asList(new RetrieveBookCategories(), new RetrieveAuthors());
        List<IStrategy> customerComboBoxes = Arrays.asList(new ListCountries(), new ListStates(), new ListCities());
        
        // Book validations and business rules
        List<IStrategy> createBookValidations = Arrays.asList(new BookNotBlank());

        // Customer validations and business rules
        List<IStrategy> createCustomerValidations = Arrays.asList(new CustomerNotBlank(), new CreditCardValidation(), new PasswordValitation());

        // ShopCart validations and business rules
        List<IStrategy> itemStrategies = Arrays.asList(new BookInStock(), new ValidBookQuantity());

        // Order validations
        List<IStrategy> orderCreateStrategies = Arrays.asList(new RetrieveCustomer());

        // Login validations
        List<IStrategy> loginStrategies = new ArrayList<>();

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
        shopCartValidations.put(DELETE, Arrays.asList(new UpdateCartTotalValue()));
        shopCartValidations.put(RETRIEVE, new ArrayList<>());

        Map<String, List<IStrategy>> itemValidations = new HashMap<>();
        itemValidations.put(UPDATE, itemStrategies);

        // orders
        Map<String, List<IStrategy>> ordersValidations = new HashMap<>();
        ordersValidations.put(INSERTFORM, orderCreateStrategies);

        // login
        Map<String, List<IStrategy>> loginValidations = new HashMap<>();
        loginValidations.put(INSERTFORM, loginStrategies);

        // # persistence layer
        daos = new HashMap<>();
        daos.put(bookEntity, new BookDAO());
        daos.put(orderEntity, new OrderDAO());

        // # all requirements
        requirements = new HashMap<>();
        requirements.put(bookEntity, bookValidations);
        requirements.put(customerEntity, customerValidations);
        requirements.put(shopCartEntity, shopCartValidations);
        requirements.put(itemEntity, itemValidations);
        requirements.put(orderEntity, ordersValidations);
        requirements.put(userEntity, loginValidations);
    }

    @Override
    public Result create(DomainEntity domainEntity) {
        String entityName = domainEntity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(entityName);
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(CREATE);

        result = executeValidations(domainEntity, validations);

        if(!result.hasErrors() && dao != null) { // break any validation?
            if(!dao.create(domainEntity)) { // persistence errors?
                result.addErrorMsg("Error!!!");
            }
        }

        return result;
    }

    @Override
    public Result retrieve(DomainEntity domainEntity) {
        String entityName = domainEntity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(entityName);
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(RETRIEVE);

        result = executeValidations(domainEntity, validations);

        if(!result.hasErrors() && dao != null) {
            try {
                result.putEntities(dao.retrieve("1 = 1"));
            } catch(RuntimeException e) {
                result.addErrorMsg(e.getMessage());
            }
        }

        return result;
    }

    @Override
    public Result update(DomainEntity domainEntity) {
        String entityName = domainEntity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(entityName);
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(UPDATE);

        result = executeValidations(domainEntity, validations);

        if(!result.hasErrors() && dao != null) {
            if(!dao.update(domainEntity)) {
                result.addErrorMsg("Error!!!");
            }
        }

        return result;
    }

    @Override
    public Result delete(DomainEntity domainEntity) {
        String entityName = domainEntity.getClass().getSimpleName();
        result = new Result();
        IDAO dao = daos.get(entityName);
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(DELETE);

        result = executeValidations(domainEntity, validations);

        if(!result.hasErrors() && dao != null) {
            if(!dao.delete(domainEntity)) {
                result.addErrorMsg("Error !!!");
            }
        }

        return null;
    }

    @Override
    public Result insertForm(DomainEntity domainEntity) {
        result = new Result();
        String entityName = domainEntity.getClass().getSimpleName();

        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(INSERTFORM);

        result = executeValidations(domainEntity, validations);

        return result;
    }

    @Override
    public Result editForm(DomainEntity domainEntity) {
    	String entityName = domainEntity.getClass().getSimpleName();
    	String whereClause = "%s.id = %d";
    	IDAO dao = daos.get(entityName);
    	result = new Result();
        
        Map<String, List<IStrategy>> rules = requirements.get(entityName);
        List<IStrategy> validations = rules.get(EDITFORM);

        domainEntity = dao.retrieve(String.format(whereClause, entityName.toLowerCase().charAt(0), domainEntity.getId())).get(0);
        result = executeValidations(domainEntity, validations);
        result.setEntity(domainEntity);

        return result;
    }

    private Result executeValidations(DomainEntity domainEntity, List<IStrategy> validations) {
        for(IStrategy validation : validations) {
            result = validation.process(domainEntity, result);

            if(result.hasErrors()) {
                result.setEntity(domainEntity);
                break;
            }
        }

        return result;
    }
}
