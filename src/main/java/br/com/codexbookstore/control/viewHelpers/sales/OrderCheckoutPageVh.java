package br.com.codexbookstore.control.viewHelpers.sales;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.domain.sale.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderCheckoutPageVh implements IViewHelper {
    @Override
    public DomainEntity getEntity(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Order order = new Order();
        Long customerId = (Long) session.getAttribute("customerId");
        Customer customer = new Customer();

        // TODO: remove ths conditional when login has done
        if(customerId != null) {
            customer.setId(customerId);
        } else {
            customer.setId(1L); // just while login has be disabled
        }

        order.setCustomer(customer);

        return order;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/views/sale/checkout.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
