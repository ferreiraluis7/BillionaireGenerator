package org.academiadecodigo.hackathon.models;

public class Wallet {

    private int id;
    private double cAmount;
    private double dAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getcAmount() {
        return cAmount;
    }

    public void setcAmount(double cAmount) {
        this.cAmount = cAmount;
    }

    public double getdAmount() {
        return dAmount;
    }

    public void setdAmount(double dAmount) {
        this.dAmount = dAmount;
    }
}
