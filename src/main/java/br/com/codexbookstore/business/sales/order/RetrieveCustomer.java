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
        CustomerDAO dao = new CustomerDAO();
        Order order = (Order) domainEntity;
        Long customerId = order.getCustomer().getId();
        Customer customer = (Customer) dao.retrieve("customer.id = ".concat(customerId.toString())).get(0);

        result.setEntity(customer);
        return result;
    }
}
