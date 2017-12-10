package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

public class PriceGroup extends DomainEntity {
    private double markup;

    public PriceGroup(Long id) {
        super.setId(id);
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = 1 + (markup / 100.0);
    }

    public double displayMarkupInPercents() {
        return (markup - 1) * 100.0;
    }
}
