package br.com.codexbookstore.domain.sale;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.Book;

import java.math.BigDecimal;

public class OrderItem extends DomainEntity {
    private Book book;
    private int quantity;

    public OrderItem() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return book.getStock().getSalePrice().multiply(BigDecimal.valueOf(quantity));
    }
}
