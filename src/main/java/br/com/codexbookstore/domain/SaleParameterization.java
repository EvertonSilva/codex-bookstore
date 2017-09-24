package br.com.codexbookstore.domain;

/**
 * Created by everton on 24/09/17.
 */
public class SaleParameterization extends Entity {
    private int minSaleLimit;
    private int periodicity;

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
}
