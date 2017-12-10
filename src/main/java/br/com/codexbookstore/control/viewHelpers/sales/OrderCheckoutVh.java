package br.com.codexbookstore.control.viewHelpers.sales;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.sale.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderCheckoutVh implements IViewHelper {
    @Override
    public DomainEntity getEntity(HttpServletRequest request) {
        return new Order();
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
