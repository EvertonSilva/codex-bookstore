package br.com.codexbookstore.domain.sale;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.User;
import br.com.codexbookstore.domain.customer.Customer;
import br.com.codexbookstore.domain.location.Address;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order extends Entity {
    private Customer customer;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for(OrderItem item : orderItems) {
            total = total.add(item.getSubTotal());
        }

        return total;
    }
}
