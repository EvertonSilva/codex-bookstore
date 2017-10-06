package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.book.Category;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.AbstractDAO;
import br.com.codexbookstore.persistence.dao.IDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everton on 27/09/17.
 */
public class CategoryDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
        return false;
    }

    @Override
    public List<Entity> retrieve(Entity entity) {
        List<Entity> categories = new ArrayList<>();
        categories.add(new Category("Romance", "Lorem ipsum"));
        categories.add(new Category("Mistery & Suspense", "Lorem ipsum"));
        categories.add(new Category("Terror", "Lorem ipsum"));
        categories.add(new Category("Sci-FI & Fantasy", "Lorem ipsum"));
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
