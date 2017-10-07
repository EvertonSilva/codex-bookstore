package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.Entity;

public class State extends Entity {
    private String name;

    public State() {
    }

    public State(Long id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
