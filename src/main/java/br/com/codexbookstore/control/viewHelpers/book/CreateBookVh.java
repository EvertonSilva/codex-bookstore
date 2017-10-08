package br.com.codexbookstore.control.viewHelpers.book;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateBookVh implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        Book book = new Book();
        Author author;
        Publisher publisher;
        PriceGroup priceGroup;
        List<Category> categories = new ArrayList<>();
        Dimensions dimensions = new Dimensions();
        SaleParameterization salesParameters = new SaleParameterization();

        // get parameters from request
        try {
            // title, edition, publish year, number of pages, isbn, barcode, synopsis
            book.setTitle(request.getParameter("book-title"));
            book.setEdition(request.getParameter("book-edition"));
            book.setPublishYear(request.getParameter("book-year"));
            book.setNumberOfPages(Integer.valueOf(request.getParameter("book-pages-number")));
            book.setIsbn(request.getParameter("book-isbn"));
            book.setBarcode(request.getParameter("book-barcode"));
            book.setSynopsis(request.getParameter("book-synopsis"));

            // author
            author = new Author(Long.valueOf(request.getParameter("book-author")));
            book.setAuthor(author);

            // categories
            String[] catList = request.getParameterValues("book-category");
            for (String category : catList) {
                categories.add(new Category(Long.valueOf(category)));
            }
            book.setCategories(categories);

            // publisher
            publisher = new Publisher(Long.valueOf(request.getParameter("book-publisher")));
            book.setPublisher(publisher);

            // dimensions
            dimensions.setHeight(Double.valueOf(request.getParameter("book-height")));
            dimensions.setWidth(Double.valueOf(request.getParameter("book-width")));
            dimensions.setWeight(Double.valueOf(request.getParameter("book-weight")));
            dimensions.setDepth(Double.valueOf(request.getParameter("book-depth")));
            book.setDimensions(dimensions);

            // price group
            priceGroup = new PriceGroup(Long.valueOf(request.getParameter("book-price-group")));
            book.setPriceGroup(priceGroup);

            // sales parameters
            salesParameters.setMinSaleLimit(Integer.valueOf(request.getParameter("book-sales-min-number")));
            salesParameters.setPeriodicity(Integer.valueOf(request.getParameter("book-sales-value")));
            salesParameters.setPeriodicityUnit(request.getParameter("book-sales-period-unit"));
            book.setSaleParameterization(salesParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath().concat("/books/list"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
