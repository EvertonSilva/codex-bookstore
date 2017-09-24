package br.com.codexbookstore.control.operationfactory;

/**
 * Created by everton on 24/09/17.
 */
public class InsertOperationFactory implements AbstractOperationFactory {
    @Override
    public IOperation createOperation() {
        IOperation operation = new InsertOperation();
        return operation;
    }
}
