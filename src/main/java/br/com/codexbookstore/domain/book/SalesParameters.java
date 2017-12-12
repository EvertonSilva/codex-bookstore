package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sales_parametrization")
public class SalesParameters extends DomainEntity {

    @Column(name = "min_sale_limit")
    private int minSaleLimit;

    @Column
    private int periodicity;

    @Column(name = "periodicity_unit")
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
