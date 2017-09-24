package br.com.codexbookstore.control.operationfactory;

/**
 * Created by everton on 23/09/17.
 */
public class OperationRetrieveFactory implements AbstractOperationFactory {
    @Override
    public IOperation createOperation() {
        IOperation operation = new RetrieveOperation();
        return operation;
    }
}
