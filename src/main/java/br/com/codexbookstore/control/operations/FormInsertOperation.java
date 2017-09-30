package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.book.Entity;

/**
 * Operation to get data for
 */
public class FormInsertOperation extends AbstractOperation {
    @Override
    public Result execute(Entity entity) {
        return crudService.insertForm(entity);
    }
}
