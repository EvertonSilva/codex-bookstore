package br.com.codexbookstore.persistence.dao.sale;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.util.List;

public class OrderDAO extends AbstractDAO {

    @Override
    public Long save(DomainEntity entity) {
        return null;
    }

    @Override
    public List<DomainEntity> findAll() {
        return null;
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
