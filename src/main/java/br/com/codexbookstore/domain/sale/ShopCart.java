package br.com.codexbookstore.domain.sale;

import br.com.codexbookstore.domain.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopCart extends Entity {
    private List<OrderItem> orderItems = new ArrayList<>();
    private BigDecimal total = new BigDecimal(0);

    public ShopCart() {
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
        updateCartTotal();
    }

    public OrderItem getOrderItemAt(int index) {
        return orderItems.get(index);
    }

    public void removeItem(int index) {
        orderItems.remove(index);
        updateCartTotal();
    }

    public BigDecimal getTotal() {
        return total;
    }

    private void updateCartTotal() {
        for(OrderItem item : orderItems) {
            total = total.add(item.getSubTotal());
        }
    }
}
