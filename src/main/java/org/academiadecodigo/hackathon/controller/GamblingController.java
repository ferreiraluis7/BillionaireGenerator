package org.academiadecodigo.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.service.UserService;

public class GamblingController implements Controller {

    Image[] image = new Image[4];


    private static final String NAME = "gambling";

    private UserService userService;

    private Navigation navigation;

    @FXML
    private Menu menu;

    @FXML
    private Label console;

    @FXML
    private Label coins;

    @FXML
    private MenuItem logoutMenu;

    @FXML
    private MenuItem closeMenu;

    @FXML
    private MenuItem logOut;

    @FXML
    private MenuItem close;

    @FXML
    private TextField bet;

    @FXML
    private Button tryButton;

    @FXML
    private ImageView roulette0;

    @FXML
    private ImageView roulette1;

    @FXML
    private ImageView roulette2;

    @FXML
    private ImageView roulette3;

    @FXML
    private Button quitButton;

    ImageView[] imageViews = new ImageView[4];


    public GamblingController(UserService userService, Navigation navigation) {
        this.userService = userService;
        this.navigation = navigation;
    }

    public void initialize() {

        imageViews[0] = roulette0;
        imageViews[1] = roulette1;
        imageViews[2] = roulette2;
        imageViews[3] = roulette3;


        setNotVisible((int) Math.round(Math.random() * 2));
        coins.setText((String.valueOf(userService.getCurrentUser().getWallet().getcAmount())));

    }

    @FXML
    void placeBet(MouseEvent event) {

        int result = 0;


        if (bet.getText().isEmpty()) {
            console.setText("No risk, no reward. Bet something!");
            bet.setText("");
            return;
        }

        if(Double.parseDouble(bet.getText()) == 0.0){
            console.setText("No risk, no reward. Bet something");
            bet.setText("");
            return;
        }

        if (!bet.getText().matches("[0-9]*\\.?[0-9]+")) {
            console.setText("Numeric Positive Values please");
            bet.setText("");
            return;
        }

        if (userService.getCurrentUser().getWallet().getcAmount() < Double.parseDouble(bet.getText())) {
            console.setText("You have not enough Hackcoins!");
            bet.setText("");
            return;
        }

        for (int i = 0; i < Math.round((Math.random() + 5) * 11); i++) {

            int n = (int) Math.round(Math.random() * 3);

            setNotVisible(n);

        }

        for (int i = 0; i < imageViews.length; i++) {

            if (imageViews[i].isVisible()) {

                result = i;
                break;

            }

        }

        switch (result) {

            case 0:
                win(2);

                break;
            case 1:
                win(3);
                break;
            case 2:
                lose();
                break;
            case 3:
                win(100);
                break;

        }

    }

    @FXML
    void quitBet(MouseEvent event) {
        navigation.loadScreen("wallet");
    }

    private void setNotVisible(int n) {

        for (int i = 0; i < imageViews.length; i++) {

            if (n == i) {
                imageViews[i].setVisible(true);
            } else {

                imageViews[i].setVisible(false);

            }

        }

    }

    @FXML
    public void goBack(ActionEvent event) {
        navigation.loadScreen("wallet");
    }

    @FXML
    public void logout(ActionEvent event) {

        navigation.loadScreen("login");
    }

    public void win(int result) {

        User user = userService.getCurrentUser();

        Double moneyWon = Double.parseDouble(bet.getText()) * result;

        moneyWon = moneyWon + userService.getCurrentUser().getWallet().getcAmount();

        user.getWallet().setcAmount(moneyWon);

        userService.addUser(user);

        coins.setText((String.valueOf(userService.getCurrentUser().getWallet().getcAmount())));

    }

    public void lose() {

        User user = userService.getCurrentUser();

        Double moneyLost = user.getWallet().getcAmount() - Double.parseDouble(bet.getText());

        user.getWallet().setcAmount(moneyLost);

        userService.addUser(user);

        coins.setText((String.valueOf(userService.getCurrentUser().getWallet().getcAmount())));

    }

}

