package br.com.codexbookstore.business.book.views;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.IDAO;
import br.com.codexbookstore.persistence.dao.book.AuthorDAO;

import java.util.List;

public class RetrieveAuthors implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        IDAO dao = new AuthorDAO();
        List<Entity> authors = dao.retrieve();
        result.putEntities(authors);
        return result;
    }
}
