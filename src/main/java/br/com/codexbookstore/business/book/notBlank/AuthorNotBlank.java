package br.com.codexbookstore.business.book.notBlank;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

public class AuthorNotBlank implements IStrategy {
    @Override
    public Result process(DomainEntity domainEntity, Result result) {
        return null;
    }
}
