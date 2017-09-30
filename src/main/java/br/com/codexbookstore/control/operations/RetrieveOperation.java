package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.book.Entity;

/**
 * Created by everton on 24/09/17.
 */
public class RetrieveOperation extends AbstractOperation {
    @Override
    public Result execute(Entity entity) {
        return crudService.retrieve(entity);
    }
}
