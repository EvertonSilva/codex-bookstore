package br.com.codexbookstore.domain.book;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Dimensions {
    @Column
    private double depth;
    @Column
    private double height;
    @Column
    private double weight;
    @Column
    private double width;

    public Dimensions() {
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
