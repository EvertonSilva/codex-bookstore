package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "price_group")
public class PriceGroup extends DomainEntity {
    @Column
    private double markup;

    public PriceGroup() {}

    public PriceGroup(Long id) {
        super.setId(id);
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }
}
