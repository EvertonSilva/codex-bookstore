package br.com.codexbookstore.domain.stock;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;

import java.math.BigDecimal;

public class Stock extends Entity {
    private int quantity;
    private BigDecimal purchasePrice;
    private Book book;

    public Stock() {}

    public Stock(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        double markup = book.getPriceGroup().getMarkup();
        return purchasePrice.multiply(BigDecimal.valueOf(markup));
    }
}
