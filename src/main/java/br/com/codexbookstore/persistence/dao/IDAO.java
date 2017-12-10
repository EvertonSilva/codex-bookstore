package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.domain.DomainEntity;

import java.util.List;

public interface IDAO {
    boolean create(DomainEntity domainEntity);
    List<DomainEntity> retrieve(String queryModifiers);
    boolean update(DomainEntity domainEntity);
    boolean delete(DomainEntity domainEntity);
}
