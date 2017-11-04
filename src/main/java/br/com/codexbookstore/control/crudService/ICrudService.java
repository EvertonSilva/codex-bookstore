package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;

public interface ICrudService {
    Result create(Entity entity);
    Result retrieve(Entity entity);
    Result update(Entity entity);
    Result delete(Entity entity);
    Result insertForm(Entity entity);
    Result editForm(Entity entity);
}
