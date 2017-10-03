package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.domain.Entity;

import java.util.List;

/**
 * Created by everton on 27/09/17.
 */
public interface IDao {
    boolean create(Entity entity);
    List<Entity> retrieve(Entity entity);
    boolean update(Entity entity);
    boolean delete(Entity entity);
}
