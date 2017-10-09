package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
        openConnection();
        SalesParamsDAO spDao = new SalesParamsDAO();

        Book book = (Book) entity;
        String query = "INSERT INTO " +
                "books(enabled, title, edition, synopsis, isbn, barcode, publishYear, numberOfPages," +
                "height, width, depth, weight, author_id, sales_paremeters_id, price_group_id, publisher_id," +
                "created_at, update_at)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        // save sales parameters before save the book
        if(spDao.create(book.getSaleParameterization())) {
            // retrieve last ID inserted
            // the method 'getLastInsertID' is defined at AbstractDAO class
            Long salesParamsId = getLastInsertID();
            salesParamsId = salesParamsId == 0 ? 1 : salesParamsId;
            book.getSaleParameterization().setId(salesParamsId);
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setBoolean(1, false);
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getEdition());
            stmt.setString(4, book.getSynopsis());
            stmt.setString(5, book.getIsbn());
            stmt.setString(6, book.getBarcode());
            stmt.setString(7, book.getPublishYear());
            stmt.setInt(8, book.getNumberOfPages());
            stmt.setDouble(9, book.getDimensions().getHeight());
            stmt.setDouble(10, book.getDimensions().getWeight());
            stmt.setDouble(11, book.getDimensions().getDepth());
            stmt.setDouble(12, book.getDimensions().getWeight());
            stmt.setLong(13, book.getAuthor().getId());
            stmt.setLong(14, book.getSaleParameterization().getId());
            stmt.setLong(15, book.getPriceGroup().getId());
            stmt.setLong(16, book.getPublisher().getId());
            stmt.setTimestamp(17, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setTimestamp(18, new java.sql.Timestamp(new java.util.Date().getTime()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public List<Entity> retrieve() {
        openConnection();

        List<Entity> books = new ArrayList<>();
        /*String query = "SELECT * FROM books b " +
                "JOIN authors a ON (b.author_id = a.id)" +
                "JOIN books_categories bc ON (b.id = bc.book_id) " +
                "JOIN categories c ON (bc.category_id = c.id) " +
                "JOIN price_group pg ON (b.price_group_id = pg.id)" +
                "JOIN publishers p ON (b.publishser_id = p.id)" +
                "JOIN sales_parametrization sp (b.sales_parameters_id = sp.id)";*/

        // mockup query just to get create operation functional
        return books;
    }

    @Override
    public boolean update(Entity entity) {
        return false;
    }

    @Override
    public boolean delete(Entity entity) {
        return false;
    }
}
