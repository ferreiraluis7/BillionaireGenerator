package CurrencyRate;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CurrencyRate extends Application{

    private Parent root;

    @Override
    public void init() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Untitled.fxml"));
        root = fxmlLoader.load();

        CurrencyRate currencyRate = fxmlLoader.getController();
    }

    public static void main(String[] args) {

        Currency currency = new Currency();

        int i;

        Double result;

        while (true){


            i = (int) Math.floor(Math.random()*2);

            switch (i){

                case 0:
                    result = currency.getRate() - Math.floor(Math.random()*101) / 100;
                    currency.setRate(result);
                    break;

                case 1:
                    result = currency.getRate() + Math.floor(Math.random()*101) /100;
                    currency.setRate(result);
                    break;
            }

            System.out.println(currency.getRate());


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        if(root == null){
            throw new IllegalStateException("Root view not properly loaded");
        }

        primaryStage.setTitle("Academia de Código");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

}
