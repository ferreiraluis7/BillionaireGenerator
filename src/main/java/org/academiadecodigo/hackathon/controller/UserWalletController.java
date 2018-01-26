package org.academiadecodigo.hackathon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.service.UserService;

public class UserWalletController implements Controller {

    private static final String NAME = "userWallet";

    @FXML
    private ImageView arrow;

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

    private UserService userService;

    private Navigation navigation;

}
