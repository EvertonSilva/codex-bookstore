package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Author;
import br.com.codexbookstore.persistence.dao.IDAO;

import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements IDAO {
    @Override
    public boolean create(Entity entity) {
        return false;
    }

    @Override
    public List<Entity> retrieve() {
        List<Entity> authors = new ArrayList<>();
        authors.add(new Author(1L, "DOSTOIEVKSI, Fiodor"));
        authors.add(new Author(2L, "GOGÓL, Nikolai"));
        authors.add(new Author(3L, "TOLSTÓI, Liev"));

        return authors;
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
