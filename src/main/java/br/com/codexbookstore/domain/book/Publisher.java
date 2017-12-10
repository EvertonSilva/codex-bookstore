package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

/**
 * Created by everton on 24/09/17.
 */
public class Publisher extends DomainEntity {
    private String name;

    public Publisher() {
    }

    public Publisher(Long id) {
        super.setId(id);
    }

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
