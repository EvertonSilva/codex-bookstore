package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.book.Category;
import br.com.codexbookstore.domain.book.Entity;
import br.com.codexbookstore.persistence.dao.IDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everton on 27/09/17.
 */
public class CategoryDao implements IDao {
    @Override
    public boolean create(Entity entity) {
        return false;
    }

    @Override
    public List<Entity> retrieve(Entity entity) {
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
