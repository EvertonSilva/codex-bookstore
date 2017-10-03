package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.Entity;

/**
 * Created by everton on 24/09/17.
 */
public abstract class AbstractCategory extends Entity {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
