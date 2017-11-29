package br.com.codexbookstore.business.sales;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.sale.ShopCart;

public class UpdateCartTotalValue implements IStrategy {
    @Override
    public Result process(Entity entity, Result result) {
        ShopCart cart = (ShopCart) entity;
        cart.updateCartTotal();

        return result;
    }
}
