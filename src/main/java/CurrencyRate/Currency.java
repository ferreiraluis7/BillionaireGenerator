package CurrencyRate;

public class Currency {

    private Double rate = 1.0;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        if (rate <= 0){
            return;
        }
        this.rate = rate;
    }
}
