package br.com.codexbookstore.domain.sale;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;

public class OrderItem extends Entity {
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
}
