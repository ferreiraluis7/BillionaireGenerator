package org.academiadecodigo.hackathon.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.currency.Currency;
import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.service.UserService;

import java.util.Timer;
import java.util.TimerTask;

public class UserWalletController implements Controller {

    private static final String NAME = "userWallet";

    @FXML
    private ImageView uparrow;

    @FXML ImageView downarrow;

    @FXML
    private Button sell;

    @FXML
    private Label value;

    @FXML
    private MenuItem data;

    @FXML
    private MenuItem logOut;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem BlaBlaBla;

    @FXML
    private Button buy;

    @FXML
    private Button transfer;

    @FXML
    private Label dollar;

    @FXML
    private Label criptoCoins;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField emailField;

    @FXML
    private TextField buyField;

    @FXML
    private TextField sellField;

    @FXML
    private TextField transferField;

    private UserService userService;

    private Navigation navigation;

    private Double prevCurr = 1.0;




    public UserWalletController(UserService userService, Navigation navigation) {
        this.userService = userService;
        this.navigation = navigation;
    }

    public void initialize(){
        if(this.userService == null){
            throw new IllegalStateException("Unable to load user service from registry");

        }
        updateBudget();
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        Double newCurr = Currency.getRate();

                        value.setText("" + newCurr);
                        if(prevCurr < newCurr){
                            uparrow.setVisible(true);
                            downarrow.setVisible(false);
                        }else{
                            downarrow.setVisible(true);
                            uparrow.setVisible(false);
                        }
                        prevCurr = newCurr;

                    }
                });

            }
        }, 0, 5000);
    }

    private void updateBudget() {
        dollar.setText(Double.toString(userService.getCurrentUser().getWallet().getdAmount()) + "$");

        criptoCoins.setText(Double.toString(userService.getCurrentUser().getWallet().getcAmount()) + "฿");
    }

    @FXML
    void buy(ActionEvent event) {
        if (buyField.getText().isEmpty()) {
            messageLabel.setText("You don't have enough money");
            return;
        }
        if(!buyField.getText().matches("[-+]?[0-9]*\\.?[0-9]+")){
            messageLabel.setText("Only numeric values");
            return;
        }

        userService.buy(Double.parseDouble(buyField.getText()));

        updateBudget();
        clearField();

    }

    @FXML
    void sell(ActionEvent event) {
        if (sellField.getText().isEmpty()) {
            messageLabel.setText("You on't have enough money");
            return;
        }
        if(!sellField.getText().matches("[-+]?[0-9]*\\.?[0-9]+")){
            messageLabel.setText("Only numeric values");
            return;
        }

        userService.sell(Double.parseDouble(sellField.getText()));
        updateBudget();
        clearField();

    }

    @FXML
    void transfer(ActionEvent event) {

        User user = userService.findbyEmail(emailField.getText());

        if(user == null){
            messageLabel.setText("Invalid user email");
            return;
        }

        if(!transferField.getText().matches("[-+]?[0-9]*\\.?[0-9]+")){
            messageLabel.setText("Only numeric values");
            return;
        }

        userService.transfer(Double.parseDouble(transferField.getText()), user);
        messageLabel.setText("Transfer successful");

        updateBudget();
        clearField();

    }

    @FXML
    void goBack(ActionEvent event) {
        navigation.loadScreen("login");
    }

    private void clearField(){
        emailField.setText("");
        buyField.setText("");
        sellField.setText("");
        transferField.setText("");
    }
}
