package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.book.Category;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
        openConnection();
        Category category = (Category) entity;
        String query = "INSERT INTO categories (name, description, cretead_at, updated_at) VALUES (?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            stmt.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));

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
    public List<Entity> retrieve(String queryModifiers) {
        List<Entity> categories = new ArrayList<>();
        categories.add(new Category(1L, "Romance", "Lorem ipsum"));
        categories.add(new Category(2L, "Mistery & Suspense", "Lorem ipsum"));
        categories.add(new Category(3L, "Terror", "Lorem ipsum"));
        categories.add(new Category(4L, "Sci-FI & Fantasy", "Lorem ipsum"));
        return categories;
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
