package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.Entity;

/**
 * Created by everton on 24/09/17.
 */
public class PriceGroup extends Entity {
    private double markup;

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }
}
