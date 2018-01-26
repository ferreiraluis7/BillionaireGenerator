package org.academiadecodigo.hackathon.model;

import org.academiadecodigo.hackathon.currency.Currency;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.DecimalFormat;

@Entity
@Table(name = "wallet")
public class Wallet extends AbstractModel {

    private double cAmount;
    private double dAmount = 500;

    public Wallet(){
    }

    public void addCrypto(double amount){


        if(amount <= dAmount){
            dAmount -= amount;
            cAmount += amount*Currency.getRate();

        }
        else{
            System.out.println("Not enough funds");
        }
    }

    public void subtractCrypto(double amount){


        if(amount <= cAmount){
            cAmount -= amount;
            dAmount += amount/Currency.getRate();
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
        DecimalFormat round = new DecimalFormat("#.##");

        return Double.parseDouble(round.format(cAmount));
    }

    public void setcAmount(double cAmount) {
        this.cAmount = cAmount;
    }

    public double getdAmount() {
        DecimalFormat round = new DecimalFormat("#.##");

        return Double.parseDouble(round.format(dAmount));
    }

    public void setdAmount(double dAmount) {
        this.dAmount = dAmount;
    }

}
