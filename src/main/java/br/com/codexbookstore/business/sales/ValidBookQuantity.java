package br.com.codexbookstore.business.sales;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.sale.OrderItem;
import br.com.codexbookstore.domain.stock.Stock;

public class ValidBookQuantity implements IStrategy {

    @Override
    public Result process(DomainEntity domainEntity, Result result) {
        OrderItem item = (OrderItem) domainEntity;
        Stock bookStock = item.getBook().getStock();

        if(item.getQuantity() > bookStock.getAvailable()) { // invalid quantity info
            result.addErrorMsg("Quantity overflow");
        }

        return result;
    }
}
