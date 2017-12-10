package br.com.codexbookstore.persistence.dao.book;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.book.Author;
import br.com.codexbookstore.persistence.dao.IDAO;

import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements IDAO {
    @Override
    public boolean create(DomainEntity domainEntity) {
        return false;
    }

    @Override
    public List<DomainEntity> retrieve(String queryModifiers) {
        List<DomainEntity> authors = new ArrayList<>();
        authors.add(new Author(1L, "DOSTOIEVKSI, Fiodor"));
        authors.add(new Author(2L, "GOGÓL, Nikolai"));
        authors.add(new Author(3L, "TOLSTÓI, Liev"));

        return authors;
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
