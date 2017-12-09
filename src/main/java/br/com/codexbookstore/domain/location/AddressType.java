package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.Entity;

public class AddressType extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
