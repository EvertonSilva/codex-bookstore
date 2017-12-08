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
        if(!isBookOnList(item)) {
            orderItems.add(item);
        }
    }

    public OrderItem getOrderItemAt(int index) {
        return orderItems.get(index);
    }

    public void removeItem(int index) {
        orderItems.remove(index);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void updateCartTotal() {
        total = BigDecimal.valueOf(0);
        for(OrderItem item : orderItems) {
            total = total.add(item.getSubTotal());
        }
    }

    private boolean isBookOnList(OrderItem item) {

        for(int i = 0, max = orderItems.size(); i < max; i++) {
            OrderItem it = orderItems.get(i);
            if(it.getBook().getTitle().equals(item.getBook().getTitle())) { // is item book already on the list?
                int currQty = it.getQuantity();
                it.setQuantity(currQty + item.getQuantity());
                orderItems.set(i, it);
                return true;
            }
        }

        return false;
    }
}
