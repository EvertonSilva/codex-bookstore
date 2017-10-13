package br.com.codexbookstore.business.book;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.business.book.notBlank.DimensionsNotBlank;
import br.com.codexbookstore.business.book.notBlank.SalesParamsNotBlank;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;

import java.util.Arrays;
import java.util.List;

public class BookNotBlank implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        Book book = (Book) entity;
        List<IStrategy> notBlankValidations =
                Arrays.asList(new SalesParamsNotBlank(), new DimensionsNotBlank());

        if(book.getTitle().isEmpty()) {
            result.addErrorMsg("Title can't be blank.");
        }
        if(book.getBarcode().isEmpty()) {
            result.addErrorMsg("Barcode can't be blank.");
        }
        if(book.getEdition().isEmpty()) {
            result.addErrorMsg("Edition can't be blank.");
        }
        if(book.getIsbn().isEmpty()) {
            result.addErrorMsg("ISBN can't be blank");
        }
        if(book.getSynopsis().isEmpty()) {
            result.addErrorMsg("Synopsis can't be blank");
        }
        if(book.getPublishYear().isEmpty()) {
            result.addErrorMsg("Publisher year can't be blank");
        }
        if(String.valueOf(book.getNumberOfPages()).isEmpty()) {
            result.addErrorMsg("Number of pages can't be blank");
        }

        for(IStrategy st : notBlankValidations) {
            result = st.process(book, result);
        }

        return result;
    }
}
