package br.com.codexbookstore.business.book.notBlank;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.book.Dimensions;

public class DimensionsNotBlank implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        Book book = (Book)entity;
        Dimensions dimensions = book.getDimensions();

        if(String.valueOf(dimensions.getWidth()).isEmpty()) {
            result.addErrorMsg("Width can't be blank");
        }
        if(String.valueOf(dimensions.getHeight()).isEmpty()) {
            result.addErrorMsg("Height can't be blank");
        }
        if(String.valueOf(dimensions.getWeight()).isEmpty()) {
            result.addErrorMsg("Weight can't be blank");
        }
        if(String.valueOf(dimensions.getDepth()).isEmpty()) {
            result.addErrorMsg("Depth can't be blank");
        }

        return result;
    }
}
