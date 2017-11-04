package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;

public class FormEditOperation extends AbstractOperation {
    @Override
    public Result execute(Entity entity) {
        return crudService.editForm(entity);
    }
}
