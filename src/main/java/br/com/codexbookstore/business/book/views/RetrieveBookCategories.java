package br.com.codexbookstore.business.book.views;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.persistence.dao.IDAO;
import br.com.codexbookstore.persistence.dao.book.CategoryDAO;

import java.util.List;

/**
 * Created by everton on 27/09/17.
 */
public class RetrieveBookCategories implements IStrategy {
    @Override
    public Result process(DomainEntity domainEntity, Result result) {
        IDAO dao = new CategoryDAO();
        List<DomainEntity> categories = dao.retrieve("");
        result.putEntities(categories);
        return result;
    }
}
