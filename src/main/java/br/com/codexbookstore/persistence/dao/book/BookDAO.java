package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.*;
import br.com.codexbookstore.domain.stock.Stock;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

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
    private StockDAO stockDAO;

    public BookDAO() {
        salesParamsDAO = new SalesParamsDAO(true);
        categoryDAO = new CategoryDAO();
        stockDAO = new StockDAO();
    }

    @Override
    public boolean create(DomainEntity domainEntity) {
        openConnection();

        boolean result = false;

        Book book = (Book) domainEntity;
        SalesParameters saleParams = book.getSalesParameters();

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
            book.getSalesParameters().setId(salesPrmsId);

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
            stmt.setLong(14, book.getSalesParameters().getId());
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
                super.setTransaction(null);
            } catch (SQLException e) {
               throw new RuntimeException();
            }
            closeConnection();
        }
        return result;
    }

    @Override
    public List<DomainEntity> retrieve(String queryModifiers) {
        openConnection();

        List<DomainEntity> books = new ArrayList<>();
        StringBuilder q = new StringBuilder();
        q.append("SELECT b.*, a.id, a.name, ");
        q.append("sp.id as sp_id, sp.MIN_SALE_LIMIT sp_min, sp.PERIODICITY as sp_per, sp.PERIODICITY_UNIT as sp_unit, ");
        q.append("pg.ID, pg.MARKUP, ");
        q.append("pb.ID, pb.NAME, ");
        q.append("GROUP_CONCAT(c.ID SEPARATOR ', ') as catIDs, ");
        q.append("GROUP_CONCAT(c.NAME SEPARATOR ', ') as categories ");

        q.append("FROM BOOKS b ");
        q.append("JOIN BOOKS_CATEGORIES bc ON (b.id = bc.BOOK_ID) ");
        q.append("JOIN CATEGORIES c ON (c.id = bc.CATEGORY_ID) ");
        q.append("JOIN AUTHORS a ON (b.AUTHOR_ID = a.ID) ");
        q.append("JOIN SALES_PARAMETRIZATION sp ON (b.SALES_PAREMETERS_ID = sp.id) ");
        q.append("JOIN PRICE_GROUP pg ON (b.PRICE_GROUP_ID = pg.ID) ");
        q.append("JOIN PUBLISHERS pb ON (b.PUBLISHER_ID = pb.ID) ");

        q.append("WHERE ");
        q.append(queryModifiers);
        q.append(" GROUP BY b.ID ");
        q.append("ORDER BY b.ID ASC");

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

                Dimensions dim = new Dimensions();
                dim.setWeight(rs.getInt("books.weight"));
                dim.setDepth(rs.getInt("books.depth"));
                dim.setWidth(rs.getInt("books.width"));
                dim.setHeight(rs.getInt("books.height"));
                book.setDimensions(dim);

                Author author = new Author(rs.getLong("books.author_id"),
                                            rs.getString("authors.name"));
                book.setAuthor(author);

                Publisher pb = new Publisher();
                pb.setId(rs.getLong("books.publisher_id"));
                pb.setName(rs.getString("publishers.name"));
                book.setPublisher(pb);

                SalesParameters sp = new SalesParameters();
                sp.setId(rs.getLong("sp_id"));
                sp.setPeriodicity(rs.getInt("sp_per"));
                sp.setMinSaleLimit(rs.getInt("sp_min"));
                sp.setPeriodicityUnit(rs.getString("sp_unit"));
                book.setSalesParameters(sp);

                PriceGroup pg = new PriceGroup(rs.getLong("books.price_group_id"));
                pg.setMarkup(rs.getDouble("price_group.markup"));
                book.setPriceGroup(pg);

                Arrays.stream(rs.getString("categories").split(", "))
                        .forEach( c -> book.addCategory(new Category(null, c, null)));

                Arrays.stream(rs.getString("catIDs").split(", "))
                        .forEach(_id -> book.getCategories().forEach( c -> c.setId(Long.valueOf(_id))));

                Stock stock;
                String stockQuery = "book_id = ";
                stockQuery = stockQuery.concat(String.valueOf(book.getId()));
                stock = (Stock) stockDAO.retrieve(stockQuery).get(0);
                stock.setBook(book);
                book.setStock(stock);

                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    @Override
    public boolean update(DomainEntity domainEntity) {
        openConnection();
        boolean result = false;
        Book book = (Book) domainEntity;
        StringBuilder query = new StringBuilder();
        query.append("UPDATE books SET ");
        query.append("enabled = ?, ");
        query.append("title = ?, ");
        query.append("edition = ?, ");
        query.append("synopsis = ?, ");
        query.append("isbn = ?, ");
        query.append("barcode = ?, ");
        query.append("publishYear = ?, ");
        query.append("numberOfPages = ?, ");
        query.append("height = ?, ");
        query.append("width = ?, ");
        query.append("depth = ?, ");
        query.append("weight = ?, ");
        query.append("author_id = ?, ");
        query.append("sales_paremeters_id = ?, ");
        query.append("price_group_id = ?, ");
        query.append("publisher_id = ?, ");
        query.append("update_at = ? ");
        query.append("WHERE books.id = ? ");

        try {
            conn.setAutoCommit(false);
            super.setTransaction(conn);

            PreparedStatement stmt = conn.prepareStatement(query.toString());
            stmt.setBoolean(1, book.isEnabled());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getEdition());
            stmt.setString(4, book.getSynopsis());
            stmt.setString(5, book.getIsbn());
            stmt.setString(6, book.getBarcode());
            stmt.setString(7, book.getPublishYear());
            stmt.setInt(8, book.getNumberOfPages());
            stmt.setDouble(9, book.getDimensions().getHeight());
            stmt.setDouble(10, book.getDimensions().getWidth());
            stmt.setDouble(11, book.getDimensions().getDepth());
            stmt.setDouble(12, book.getDimensions().getWeight());
            stmt.setLong(13, book.getAuthor().getId());
            stmt.setLong(14, book.getSalesParameters().getId());
            stmt.setLong(15, book.getPriceGroup().getId());
            stmt.setLong(16, book.getPublisher().getId());
            stmt.setTimestamp(17, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setLong(18, book.getId());

            stmt.executeUpdate();
            updateCategoryAssociation(book.getId(), book.getCategories());

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
                super.setTransaction(null);
            } catch (SQLException e) {
                throw new RuntimeException();
            }
            closeConnection();
        }

        return result;
    }

    @Override
    public boolean delete(DomainEntity domainEntity) {
        return false;
    }

    private void insertCategoryAssociation(Long bookId, List<Category> categories) throws SQLException {
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
    }

    private void updateCategoryAssociation(Long bookId, List<Category> newCatList) throws SQLException {
        // removes previous records from assoc table
        String q = "DELETE FROM books_categories WHERE book_id = ?";
        PreparedStatement stmt = conn.prepareStatement(q);
        stmt.setLong(1, bookId);
        stmt.executeUpdate();

        // insert new ones
        insertCategoryAssociation(bookId, newCatList);
    }
}
