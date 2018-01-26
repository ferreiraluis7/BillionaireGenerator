package org.academiadecodigo.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet extends AbstractModel {

    private double rate = Currency.getInstance().getRate();
    private double cAmount;
    private double dAmount = 500;

    public Wallet(){
    }

    public void addCrypto(double amount){
        if(amount <= dAmount){
            dAmount -= amount;
            cAmount += amount*rate;
        }
        else{
            System.out.println("Not enough funds");
        }
    }

    public void subtractCrypto(double amount){
        if(amount <= cAmount){
            cAmount -= amount;
            dAmount += amount/rate;
        }
        else{
            System.out.println("Not enough funds");
        }
    }

    public void sendCrypto(double amount){
        if(amount <= cAmount){
            cAmount -= amount;
        }
        else{
            System.out.println("Not enough funds");
        }
    }

    public void receiveCrypto(double amount){
        cAmount += amount;
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
