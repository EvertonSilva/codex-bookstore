package br.com.codexbookstore.domain.stock;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.Book;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stocks")
public class Stock extends DomainEntity {
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column
    private int quantity;

    @Transient
    private int blockQuantity;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    public Stock() {
        blockQuantity = 0;
    }

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
        double markup = 1 + (book.getPriceGroup().getMarkup() / 100);
        return purchasePrice.multiply(BigDecimal.valueOf(markup));
    }

    public void setBlockQuantity(int blockQuantity) {
        this.blockQuantity = blockQuantity;
    }

    public int getAvailable() {
        return quantity - blockQuantity;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
