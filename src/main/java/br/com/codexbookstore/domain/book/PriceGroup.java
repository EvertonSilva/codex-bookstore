package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.Entity;

public class PriceGroup extends Entity {
    private double markup;

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
