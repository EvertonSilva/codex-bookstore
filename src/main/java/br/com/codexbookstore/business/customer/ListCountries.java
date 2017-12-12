package br.com.codexbookstore.business.customer;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

public class ListCountries implements IStrategy {
    @Override
    public Result process(DomainEntity domainEntity, Result result) {
        return result;
    }
}
