package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
        openConnection();

        Book book = (Book) entity;
        String query = "INSERT INTO " +
                "books(enabled, title, edition, synopsis, isbn, barcode, publishYear, numberOfPages," +
                "height, width, depth, weight, author_id, sales_paremeters_id, price_group_id, publisher_id," +
                "created_at, update_at)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
    public List<Entity> retrieve(Entity entity) {
        return null;
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
