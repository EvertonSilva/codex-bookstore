package br.com.codexbookstore.control.abstractFactory;

import br.com.codexbookstore.control.operations.AbstractOperation;
import br.com.codexbookstore.control.operations.FormInsertOperation;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.control.viewHelpers.book.InsertFormVh;

/**
 * Created by everton on 25/09/17.
 */
public class FormInsertOperationFactory implements AbstractOperationFactory {
    @Override
    public AbstractOperation defineOperation() {
        AbstractOperation operation = new FormInsertOperation();
        return operation;
    }

    @Override
    public IViewHelper defineViewHelper() {
        IViewHelper vh = new InsertFormVh();
        return vh;
    }
}
