package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.DomainEntity;

public class AddressType extends DomainEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
