package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.Category;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO {

    @Override
    public Long save(DomainEntity entity) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DomainEntity> findAll() {
        return session.createCriteria(Category.class).list();
    }

    @Override
    public DomainEntity findById(Long id) {
        return null;
    }

    @Override
    public boolean update(DomainEntity entity) {
        return false;
    }

    @Override
    public boolean delete(DomainEntity entity) {
        return false;
    }
}
