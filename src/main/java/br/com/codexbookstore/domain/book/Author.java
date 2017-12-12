package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author extends DomainEntity {

    private String name;

    public Author() {}

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
