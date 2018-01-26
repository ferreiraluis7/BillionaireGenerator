package org.academiadecodigo.hackathon.model;

public final class Currency {

    private static Currency instance;
    private double supply;
    public static final double limit = 300;
    private double rate;

    private Currency(){

    }

    public static synchronized Currency getInstance(){
        if(instance == null){
            instance = new Currency();
        }
        return instance;
    }

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
