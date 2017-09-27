package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.IDao;

import java.util.List;
import java.util.Map;

/**
 * Created by everton on 24/09/17.
 */
public class CrudService implements ICrudService {

    private Map<String, Map<String, List<IStrategy>>> requirements;
    private Map<String, IDao> daos;

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
        return null;
    }
}
