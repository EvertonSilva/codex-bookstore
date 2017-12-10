package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

/**
 * Created by everton on 24/09/17.
 */
public class Author extends DomainEntity {
    private String name;

    public Author(Long id) {
        super.setId(id);
    }

    public Author(Long id, String name) {
        super.setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
