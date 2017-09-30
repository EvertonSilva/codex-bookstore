package br.com.codexbookstore.business.book.views;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.IDao;
import br.com.codexbookstore.persistence.dao.book.CategoryDao;

import java.util.List;

/**
 * Created by everton on 27/09/17.
 */
public class RetrieveBookCategories implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        IDao dao = new CategoryDao();
        List<Entity> categories = dao.retrieve(entity);
        result.putEntities(categories);
        return result;
    }
}
