package org.academiadecodigo.hackathon.model;

public class Currency {

    private double supply;
    public static final double limit = 300;
    private double rate;

    public double getSupply() {
        return supply;
    }

    public void setSupply(double supply) {
        this.supply = supply;
    }

    public static double getLimit() {
        return limit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
