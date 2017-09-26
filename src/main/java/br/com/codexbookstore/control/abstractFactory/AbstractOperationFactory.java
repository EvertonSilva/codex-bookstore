package br.com.codexbookstore.control.abstractFactory;

import br.com.codexbookstore.control.operations.AbstractOperation;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;

/**
 * Created by everton on 24/09/17.
 */
public interface AbstractOperationFactory {

    AbstractOperation defineOperation();
    IViewHelper defineViewHelper();
}
