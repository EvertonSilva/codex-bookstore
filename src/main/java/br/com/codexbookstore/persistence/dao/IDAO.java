package br.com.codexbookstore.persistence.dao;

import br.com.codexbookstore.domain.Entity;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {
    boolean create(Entity entity);
    List<Entity> retrieve(String queryModifiers);
    boolean update(Entity entity);
    boolean delete(Entity entity);
}
