package org.academiadecodigo.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet extends AbstractModel {


    private double cAmount;
    private double dAmount = 500;

    public Wallet(){
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
