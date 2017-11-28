package br.com.codexbookstore.domain.sale;

import br.com.codexbookstore.domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class ShopCart extends Entity {
    private List<OrderItem> orderItems = new ArrayList<>();

    public ShopCart() {
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }

    public OrderItem getOrderItemAt(int index) {
        return orderItems.get(index);
    }

    public void removeItem(int index) {
        orderItems.remove(index);
    }
}
