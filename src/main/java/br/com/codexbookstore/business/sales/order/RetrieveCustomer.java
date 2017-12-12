package br.com.codexbookstore.business.sales.order;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.domain.sale.Order;
import br.com.codexbookstore.persistence.dao.customer.CustomerDAO;

public class RetrieveCustomer implements IStrategy {

    @Override
    public Result process(DomainEntity domainEntity, Result result) {
        Order order = (Order) domainEntity;
        CustomerDAO dao = new CustomerDAO();
        Long id = order.getCustomer().getId();
        order.setCustomer(dao.findById(id));

        result.setEntity(order);

        return result;
    }
}
