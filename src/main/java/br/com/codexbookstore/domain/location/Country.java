package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.DomainEntity;

public class Country extends DomainEntity {

    private String name;

    public Country() {
    }

    public Country(Long id) {
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
