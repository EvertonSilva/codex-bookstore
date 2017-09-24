package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;

/**
 * Created by everton on 24/09/17.
 */
public interface ICrudService {
    Result create(Entity entity);
    Result retrieve(Entity entity);
    Result update(Entity entity);
    Result delete(Entity entity);
}
