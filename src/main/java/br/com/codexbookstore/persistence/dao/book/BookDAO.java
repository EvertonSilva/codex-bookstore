package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.util.List;

public class BookDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
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
