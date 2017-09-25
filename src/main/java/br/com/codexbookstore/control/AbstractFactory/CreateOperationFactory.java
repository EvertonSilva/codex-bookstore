package br.com.codexbookstore.control.AbstractFactory;

import br.com.codexbookstore.control.operations.AbstractOperation;
import br.com.codexbookstore.control.operations.CreateOperation;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.control.viewHelpers.book.CreateBookViewHelper;

/**
 * Created by everton on 24/09/17.
 */
public class CreateOperationFactory implements AbstractOperationFactory {

    @Override
    public AbstractOperation defineOperation() {
        return new CreateOperation();
    }

    @Override
    public IViewHelper defineViewHelper() {
        return new CreateBookViewHelper();
    }
}
