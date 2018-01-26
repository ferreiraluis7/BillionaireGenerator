package org.academiadecodigo.hackathon.model;

import java.text.DecimalFormat;

public final class Currency {

    private static Currency instance;
    private double supply;
    public static final double limit = 300;
    private double rate = 1.0;

    private Currency(){

    }

    public static synchronized Currency getInstance(){
        if(instance == null){
            instance = new Currency();
        }
        return instance;
    }

    public static void main(String[] args) {

        DecimalFormat round = new DecimalFormat("#.##");

        int i;

        Double result;

        while (true) {

            i = (int) Math.floor(Math.random() * 2);

            switch (i) {

                case 0:
                    result =  Double.parseDouble(round.format(getInstance().getRate() - Math.floor(Math.random() * 101) / 100));
                    getInstance().setRate(result);
                    break;

                case 1:
                    result = Double.parseDouble(round.format(getInstance().getRate() + Math.floor(Math.random() * 101) / 100));
                    getInstance().setRate(result);
                    break;
            }

            System.out.println(getInstance().getRate());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
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

    public void setRate(Double rate) {
        if (rate <= 0){
            return;
        }
        this.rate = rate;
    }

}
