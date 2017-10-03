package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everton on 24/09/17.
 */
public class Book extends Entity {
    private String title;
    private String edition;
    private String synopsis;
    private String isbn;
    private String barcode;
    private int publicationYear;
    private int numberOfPages;
    private PriceGroup priceGroup;
    private Dimensions dimensions;
    private List<Author> authors;
    private Publisher publisher;
    private SaleParameterization saleParameterization;
    private List<Category> categories;
    private ChangeStatus changeStatus;

    public Book() {
        authors = new ArrayList<>();
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
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

    public List<Author> getAuthors() {
        return authors.subList(0, authors.size());
    }

    public Author getAuthorByIndex(int index) {
        return authors.get(index);
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public SaleParameterization getSaleParameterization() {
        return saleParameterization;
    }

    public void setSaleParameterization(SaleParameterization saleParameterization) {
        this.saleParameterization = saleParameterization;
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
}
