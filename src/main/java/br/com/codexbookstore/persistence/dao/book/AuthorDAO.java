package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.Author;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.util.List;

public class AuthorDAO extends AbstractDAO {

    @Override
    public Long save(DomainEntity entity) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DomainEntity> findAll() {
        return session.createCriteria(Author.class).list();
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
