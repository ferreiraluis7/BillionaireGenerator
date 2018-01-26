package org.academiadecodigo.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet extends AbstractModel {


    private double cAmount;
    private double dAmount;

    public Wallet(){
        dAmount = 500;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (Double.compare(wallet.cAmount, cAmount) != 0) return false;
        return Double.compare(wallet.dAmount, dAmount) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(cAmount);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
