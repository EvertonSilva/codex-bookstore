package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.DomainEntity;

public class PublicPlace extends DomainEntity {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
