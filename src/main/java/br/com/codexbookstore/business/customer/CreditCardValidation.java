package br.com.codexbookstore.business.customer;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;

public class CreditCardValidation implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        return result;
    }
}
