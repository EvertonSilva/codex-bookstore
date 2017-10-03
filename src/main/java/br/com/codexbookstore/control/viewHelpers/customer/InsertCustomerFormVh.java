package br.com.codexbookstore.control.viewHelpers.customer;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.customer.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by everton on 02/10/17.
 */
public class InsertCustomerFormVh implements br.com.codexbookstore.control.viewHelpers.IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        return new Customer();
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/views/customers/new.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
