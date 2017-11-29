package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.stock.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Book extends Entity {
    private String title;
    private String edition;
    private String synopsis;
    private String isbn;
    private String barcode;
    private String publishYear;
    private int numberOfPages;
    private PriceGroup priceGroup;
    private Dimensions dimensions;
    private Author author;
    private Publisher publisher;
    private SalesParameters salesParameters;
    private List<Category> categories;
    private ChangeStatus changeStatus;
    private Stock stock;

    public Book() {
        categories = new ArrayList<>();
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public PriceGroup getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(PriceGroup priceGroup) {
        this.priceGroup = priceGroup;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public SalesParameters getSalesParameters() {
        return salesParameters;
    }

    public void setSalesParameters(SalesParameters salesParameters) {
        this.salesParameters = salesParameters;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategoryByIndex(int index) {
        return categories.get(index);
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public ChangeStatus getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(ChangeStatus changeStatus) {
        this.changeStatus = changeStatus;
    }

    public String getStatus() {
        return isEnabled() ? "enabled" : "disabled";
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
