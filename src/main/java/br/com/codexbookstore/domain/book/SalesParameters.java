package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.Entity;

/**
 * Created by everton on 24/09/17.
 */
public class SalesParameters extends Entity {
    private int minSaleLimit;
    private int periodicity;
    private String periodicityUnit;

    public int getMinSaleLimit() {
        return minSaleLimit;
    }

    public void setMinSaleLimit(int minSaleLimit) {
        this.minSaleLimit = minSaleLimit;
    }

    public int getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    public String getPeriodicityUnit() {
        return periodicityUnit;
    }

    public void setPeriodicityUnit(String periodicityUnit) {
        this.periodicityUnit = periodicityUnit;
    }
}
