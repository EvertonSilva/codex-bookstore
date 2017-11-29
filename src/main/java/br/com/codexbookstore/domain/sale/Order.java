package br.com.codexbookstore.domain.sale;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.User;

import java.util.Date;
import java.util.List;

public class Order extends Entity {
    private User user;
    private List<OrderItem> orderItems;
    private Date orderDate;

    public Order() {
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
