package br.com.codexbookstore.persistence.dao.customer;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.util.List;

public class CustomerDAO extends AbstractDAO {
    @Override
    public boolean create(Entity entity) {
        return false;
    }

    @Override
    public List<Entity> retrieve() {
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
