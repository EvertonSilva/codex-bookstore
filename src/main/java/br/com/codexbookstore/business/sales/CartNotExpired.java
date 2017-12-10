package br.com.codexbookstore.business.sales;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

public class CartNotExpired implements IStrategy {
    @Override
    public Result process(DomainEntity domainEntity, Result result) {
        return result;
    }
}
