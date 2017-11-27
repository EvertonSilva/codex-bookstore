package br.com.codexbookstore.control.viewHelpers.sales;


import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.sale.OrderItem;
import br.com.codexbookstore.domain.sale.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateCartVh implements br.com.codexbookstore.control.viewHelpers.IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        ShopCart cart = new ShopCart();
        Book book = new Book();
        OrderItem item = new OrderItem();

        book.setId(Long.valueOf(request.getParameter("book_id")));
        item.setBook(book);

        item.setQuantity(Integer.valueOf(request.getParameter("book_quantity")));
        cart.addOrderItem(item);

        request.getSession().setAttribute("shopCart", cart);
        return cart;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
