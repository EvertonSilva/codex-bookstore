package br.com.codexbookstore.control.viewHelpers.sales;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.User;
import br.com.codexbookstore.domain.sale.Order;
import br.com.codexbookstore.domain.sale.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class OrderCheckoutVh implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // create a new Order
        Order order = new Order();

        // get user from session
        User user = (User) session.getAttribute("user");
        order.setUser(user);

        // get OrderItem from cart
        ShopCart cart = (ShopCart) session.getAttribute("shopCart");
        order.setOrderItems(cart.getOrderItems());

        // set date
        order.setOrderDate(new Date());

        // return the order
        return order;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
