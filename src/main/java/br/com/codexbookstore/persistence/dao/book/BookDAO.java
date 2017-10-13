package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.*;
import br.com.codexbookstore.persistence.dao.AbstractDAO;
import com.sun.media.jfxmedia.logging.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDAO extends AbstractDAO {
    private SalesParamsDAO salesParamsDAO;
    private CategoryDAO categoryDAO;

    public BookDAO() {
        salesParamsDAO = new SalesParamsDAO(true);
        categoryDAO = new CategoryDAO();
    }

    @Override
    public boolean create(Entity entity) {
        openConnection();

        boolean result = false;

        Book book = (Book) entity;
        SaleParameterization saleParams = book.getSaleParameterization();

        String query = "INSERT INTO " +
                "books(enabled, title, edition, synopsis, isbn, barcode, publishYear, numberOfPages, " +
                "height, width, depth, weight, author_id, sales_paremeters_id, price_group_id, publisher_id, " +
                "created_at, update_at)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conn.setAutoCommit(false);
            super.setTransaction(conn);

            ResultSet rs = null;
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            salesParamsDAO.create(saleParams);
            Long salesPrmsId = saleParams.getId();
            book.getSaleParameterization().setId(salesPrmsId);

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
            rs = stmt.getGeneratedKeys();

            if(rs.next()) {
                Long bookId = rs.getLong(1);
                insertCategoryAssociation(bookId, book.getCategories());
            }

            conn.commit();
            result = true;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException excep) {
                throw new RuntimeException(excep);
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
               throw new RuntimeException();
            }
            closeConnection();
        }
        return result;
    }

    @Override
    public List<Entity> retrieve() {
        openConnection();

        AuthorDAO authorDAO = new AuthorDAO();
        List<Entity> books = new ArrayList<>();
        StringBuilder q = new StringBuilder();
        q.append("SELECT b.*, a.name, GROUP_CONCAT(c.NAME SEPARATOR ', ') as categories ");
        q.append("FROM BOOKS b JOIN BOOKS_CATEGORIES bc ON (b.id = bc.BOOK_ID) ");
        q.append("JOIN CATEGORIES c ON (c.id = bc.CATEGORY_ID) ");
        q.append("JOIN AUTHORS a ON (b.AUTHOR_ID = a.ID) ");
        q.append("GROUP BY b.ID");

        try {
            ResultSet rs = null;
            PreparedStatement stmt = conn.prepareStatement(q.toString());
            rs = stmt.executeQuery();
            while(rs.next()) {
                Book book = new Book();

                book.setEnabled(rs.getBoolean("books.enabled"));
                book.setId(rs.getLong("books.id"));
                book.setTitle(rs.getString("books.title"));
                book.setEdition(rs.getString("books.edition"));
                book.setSynopsis(rs.getString("books.synopsis"));
                book.setIsbn(rs.getString("books.isbn"));
                book.setBarcode(rs.getString("books.barcode"));
                book.setPublishYear(rs.getString("books.publishyear"));
                book.setNumberOfPages(rs.getInt("books.numberofpages"));

                Author author = new Author(rs.getLong("books.author_id"),
                                            rs.getString("name"));
                book.setAuthor(author);
                book.setPublisher(new Publisher(rs.getLong("books.publisher_id")));

                Arrays.stream(rs.getString("categories").split(", "))
                        .forEach( c -> book.addCategory(new Category(null, c, null)));

                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    private boolean insertCategoryAssociation(Long bookId, List<Category> categories) throws SQLException {
        String insertAssoc = "INSERT INTO books_categories (book_id, category_id, created_at, updated_at)" +
                       "VALUES (?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(insertAssoc);

        for(Category c : categories) {
            statement.setLong(1, bookId);
            statement.setLong(2, c.getId());
            statement.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            statement.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));

            statement.execute();
        }
        return true;
    }
}
