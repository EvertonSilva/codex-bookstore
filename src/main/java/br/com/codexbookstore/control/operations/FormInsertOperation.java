package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

/**
 * Operation to get data for
 */
public class FormInsertOperation extends AbstractOperation {
    @Override
    public Result execute(DomainEntity domainEntity) {
        return crudService.insertForm(domainEntity);
    }
}
