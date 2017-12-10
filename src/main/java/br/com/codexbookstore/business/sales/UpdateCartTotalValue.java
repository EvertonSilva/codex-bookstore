package br.com.codexbookstore.business.sales;

import br.com.codexbookstore.business.IStrategy;
import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.sale.ShopCart;

public class UpdateCartTotalValue implements IStrategy {
    @Override
    public Result process(DomainEntity domainEntity, Result result) {
        ShopCart cart = (ShopCart) domainEntity;
        cart.updateCartTotal();

        return result;
    }
}
