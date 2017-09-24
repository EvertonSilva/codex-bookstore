package br.com.codexbookstore.control.operationfactory;

/**
 * Created by everton on 23/09/17.
 */
public class OperationBuilder {
    IOperation operation;

    public IOperation getOperation() {
        return operation;
    }

    public void buildOperation(AbstractOperationFactory operationFactory) {
        this.operation = operationFactory.createOperation();
    }
}
