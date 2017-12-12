package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

/**
 * Created by everton on 24/09/17.
 */
public class RetrieveOperation extends AbstractOperation {
    @Override
    public Result execute(DomainEntity domainEntity) {
        return crudService.retrieve(domainEntity);
    }
}
