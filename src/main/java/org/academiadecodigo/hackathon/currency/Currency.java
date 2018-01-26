package org.academiadecodigo.hackathon.currency;


import java.text.DecimalFormat;

public class Currency implements Runnable {

    public static final double limit = 300;
    private static Double rate = 1.0;

    public static double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        if (rate <= 0){
            return;
        }
        this.rate = rate;
    }

    @Override
    public void run() {

        DecimalFormat round = new DecimalFormat("#.##");

        int rateFactor;
        double temprate = 0;

        while (true) {

            rateFactor = (int) Math.floor(Math.random() * 2);

            switch (rateFactor) {

                case 0:
                    temprate =  Double.parseDouble(round.format(rate - Math.floor(Math.random() * 101) / 100));
                    break;

                case 1:
                    temprate = Double.parseDouble(round.format(rate + Math.floor(Math.random() * 101) / 100));
                    break;
            }

            if(temprate < 0){
                continue;
            }

            rate = temprate;

            System.out.println(rate);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

