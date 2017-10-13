package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.*;
import br.com.codexbookstore.persistence.dao.book.BookDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @After
    public void tearDown() {
        book = null;
    }

    @Test
    public void testValidInsert() throws Exception {
        validBook();
        assertTrue(dao.create(book));
    }

    @Test
    public void testInvalidInsert() throws Exception {
        invalidBook();
        assertFalse(dao.create(book));
    }

    @Test
    public void testRetrieveBooks() throws Exception {
        validBook();
        List<Entity> books;
        books = dao.retrieve();

        // TODO: change this weak assert
        assertEquals(3, books.size());
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

    private void invalidBook() {
        book.setTitle("The Demons");
        book.setEdition("3th");
        book.setSynopsis("Lorem ipsum dolor sit amet");
        book.setIsbn("999888999888");
        book.setBarcode("222333111");
        book.setPublishYear("2005");
        book.setNumberOfPages(280);

        // associations
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
        sp.setMinSaleLimit(1);
        sp.setPeriodicity(15);
        sp.setPeriodicityUnit("day");
        book.setSaleParameterization(sp);

        book.setEnabled(false);
    }

}
