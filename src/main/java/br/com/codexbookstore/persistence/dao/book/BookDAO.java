package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.book.Category;
import br.com.codexbookstore.domain.book.SaleParameterization;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends AbstractDAO {
    private SalesParamsDAO salesParamsDAO;
    private CategoryDAO categoryDAO;

    public BookDAO() {
        salesParamsDAO = new SalesParamsDAO();
        categoryDAO = new CategoryDAO();
    }

    @Override
    public boolean create(Entity entity) {
        openConnection();

        Book book = (Book) entity;
        SaleParameterization saleParams = book.getSaleParameterization();

        String query = "INSERT INTO " +
                "books(enabled, title, edition, synopsis, isbn, barcode, publishYear, numberOfPages," +
                "height, width, depth, weight, author_id, sales_paremeters_id, price_group_id, publisher_id," +
                "created_at, update_at)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String querySalesParam = "INSERT INTO sales_parametrization (min_sale_limit, periodicity, periodicity_unit, created_at, updated_at)" +
                "VALUES (?,?,?,?,?)";

        try {
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(query);
            PreparedStatement stmtSalesParams = conn.prepareCall(querySalesParam);

            stmtSalesParams.setInt(1, saleParams.getMinSaleLimit());
            stmtSalesParams.setInt(2, saleParams.getPeriodicity());
            stmtSalesParams.setString(3, saleParams.getPeriodicityUnit());
            stmtSalesParams.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmtSalesParams.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));

            stmtSalesParams.execute();
            book.getSaleParameterization().setId(getLastInsertID());

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

            Long bookId = getLastInsertID();
            insertCategoryAssociation(bookId, book.getCategories());

            conn.commit();
        } catch (SQLException e) {
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
