package br.com.codexbookstore.persistence.dao.sale;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.util.List;

public class OrderDAO extends AbstractDAO {
    @Override
    public boolean create(DomainEntity domainEntity) {
        return false;
    }

    @Override
    public List<DomainEntity> retrieve(String queryModifiers) {
        return null;
    }

    @Override
    public boolean update(DomainEntity domainEntity) {
        return false;
    }

    @Override
    public boolean delete(DomainEntity domainEntity) {
        return false;
    }
}
