package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
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
