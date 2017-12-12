package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.domain.DomainEntity;

import java.util.List;

public interface IDAO {

    Long save(DomainEntity entity);
    List<DomainEntity> findAll();
    DomainEntity findById(Long id);
    boolean update(DomainEntity entity);
    boolean delete(DomainEntity entity);

}
