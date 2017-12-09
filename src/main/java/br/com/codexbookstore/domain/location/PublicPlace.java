package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.Entity;

public class PublicPlace extends Entity {
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
