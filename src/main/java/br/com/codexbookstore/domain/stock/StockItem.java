package br.com.codexbookstore.domain.stock;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;

import java.math.BigDecimal;

public class StockItem extends Entity {
    private Book book;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private int quantity;

    public StockItem() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
