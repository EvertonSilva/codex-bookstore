package br.com.codexbookstore.business.book.notBlank;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.book.SalesParameters;

public class SalesParamsNotBlank implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        Book book = (Book)entity;
        SalesParameters sp = book.getSalesParameters();

        if(String.valueOf(sp.getMinSaleLimit()).isEmpty()) {
            result.addErrorMsg("Minimum sale limit can't be blank");
        }
        if(String.valueOf(sp.getPeriodicity()).isEmpty()) {
            result.addErrorMsg("Period can't be blank");
        }

        return result;
    }
}
