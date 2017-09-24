package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.crudService.CrudService;
import br.com.codexbookstore.control.crudService.ICrudService;

/**
 * Created by everton on 24/09/17.
 */
public abstract class AbstractOperation implements IOperation {
    protected ICrudService crudService;

    public AbstractOperation() {
        crudService = new CrudService();
    }
}
