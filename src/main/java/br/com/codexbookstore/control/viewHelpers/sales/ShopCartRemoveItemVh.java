package br.com.codexbookstore.control.viewHelpers.sales;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.sale.ShopCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShopCartRemoveItemVh implements IViewHelper {
    @Override
    public DomainEntity getEntity(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShopCart cart = (ShopCart) session.getAttribute("shopCart");
        Integer removeItemIndex = Integer.valueOf(request.getParameter("item"));

        cart.removeItem(removeItemIndex);
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
