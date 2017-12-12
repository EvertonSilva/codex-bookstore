package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

public class DeleteOperation extends AbstractOperation {
    @Override
    public Result execute(DomainEntity domainEntity) {
        return crudService.delete(domainEntity);
    }
}
