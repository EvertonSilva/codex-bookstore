package br.com.codexbookstore.business.book;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;

public class BookNotBlank implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        Book book = (Book) entity;
        if(book.getTitle().isEmpty()) {
            result.addErrorMsg("Title can't be blank.");
        } else if(book.getBarcode().isEmpty()) {
            result.addErrorMsg("Barcode can't be blank.");
        } else if(book.getEdition().isEmpty()) {
            result.addErrorMsg("Edition can't be blank.");
        } else if(book.getIsbn().isEmpty()) {
            result.addErrorMsg("ISBN can't be blank");
        }

        return result;
    }
}
