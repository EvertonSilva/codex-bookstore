package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.domain.book.*;
import br.com.codexbookstore.persistence.dao.book.BookDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest {
    BookDAO dao = null;
    Book book = null;

    @Before
    public void setup() {
        dao = new BookDAO();
        book = new Book();
    }

    @Test
    public void testValidInsert() {
        validBook();
        assertTrue(dao.create(book));
    }

    private void validBook() {
        book.setTitle("Notes from Underground");
        book.setEdition("4th");
        book.setSynopsis("Lorem ipsum dolor sit amet");
        book.setIsbn("0123456789");
        book.setBarcode("9876543210");
        book.setPublishYear("2010");
        book.setNumberOfPages(152);

        // associations
        book.setPriceGroup(new PriceGroup(1L));
        book.setAuthor(new Author(1L));
        book.setPublisher(new Publisher(1L));

        Dimensions d = new Dimensions();
        d.setHeight(21);
        d.setWidth(14);
        d.setDepth(5);
        d.setWeight(120);
        book.setDimensions(d);

        List<Category> categories = Arrays.asList(new Category(1L), new Category(2L));
        book.setCategories(categories);

        SaleParameterization sp = new SaleParameterization();
        sp.setMinSaleLimit(10);
        sp.setPeriodicity(7);
        sp.setPeriodicityUnit("day");
        book.setSaleParameterization(sp);

        book.setEnabled(false);

    }

}
