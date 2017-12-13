package br.com.codexbookstore.domain.customer;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card_companies")
public class CreditCardCompany extends DomainEntity {
    @Column
    public String name;

    public CreditCardCompany() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
