package br.com.codexbookstore.control.viewHelpers.sales;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.sale.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ListShopCartVh implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShopCart cart = (ShopCart) session.getAttribute("shopCart");

        if(cart == null) {
            cart = new ShopCart();
        }
        session.setAttribute("shopCart", cart);
        return cart;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            ShopCart cart = (ShopCart) request.getSession().getAttribute("shopCart");
            request.setAttribute("result", result);
            request.setAttribute("cartItems", cart.getOrderItems());
            request.getRequestDispatcher("/WEB-INF/views/shopcart.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
