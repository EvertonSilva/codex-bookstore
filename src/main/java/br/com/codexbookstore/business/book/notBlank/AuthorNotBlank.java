package br.com.codexbookstore.business.book.notBlank;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;

public class AuthorNotBlank implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        return null;
    }
}
