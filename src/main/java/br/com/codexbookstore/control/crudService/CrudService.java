package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.business.book.views.RetrieveBookCategories;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Book;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.IDao;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by everton on 24/09/17.
 */
public class CrudService implements ICrudService {

    // { entity: { rules: [IStrategy, IStrategy] } }
    private Map<String, Map<String, List<IStrategy>>> requirements;
    private Map<String, IDao> daos;
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

        // # Validations and Business rules
        // ## Combo box for views
        IStrategy retrieveBookCategories = new RetrieveBookCategories();
        List<IStrategy> insertFormValidations = Arrays.asList(retrieveBookCategories);

        // # context validations
        Map<String, List<IStrategy>> bookValidations = new HashMap<>();
        bookValidations.put(INSERTFORM, insertFormValidations);

        // # all requirements
        requirements = new HashMap<>();
        requirements.put(bookEntity, bookValidations);
    }

    @Override
    public Result create(Entity entity) {
        return null;
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
