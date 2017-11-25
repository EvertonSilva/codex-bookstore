package br.com.codexbookstore.domain.sale;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.User;

import java.util.Date;
import java.util.List;

public class Order extends Entity {
    private User user;
    private List<OrderItem> orderItems;
    private Date orderDate;

}
