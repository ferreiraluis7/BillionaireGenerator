package org.academiadecodigo.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.hackathon.Navigation;
import org.academiadecodigo.hackathon.Security;
import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.Wallet;
import org.academiadecodigo.hackathon.service.AppUserService;
import org.academiadecodigo.hackathon.service.UserService;

public class LoginController implements Controller {

    private static final String NAME = "login";

    private UserService userService;

    private Navigation navigation;

    private boolean login;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label emailLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button loginBtn;

    @FXML
    private Label messageLabel;

    @FXML
    private Hyperlink switchLink;

    public LoginController(UserService userService, Navigation navigation){
        this.userService = userService;
        this.navigation = navigation;
    }

    public void initialize() {

        if (userService == null) {
            throw new IllegalStateException("Unable to load user service from registry");
        }

        showRegister();

    }

    private void showLogin() {

        login = true;
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");

        messageLabel.setVisible(false);
        emailField.setVisible(false);
        emailLabel.setVisible(false);


        loginBtn.setText("Login");
        switchLink.setText("Register");

    }

    private void showRegister() {

        login = false;
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");

        messageLabel.setVisible(false);
        emailField.setVisible(true);
        emailLabel.setVisible(true);

        loginBtn.setText("Register");
        switchLink.setText("Cancel");

    }

    private void doLogin() {

        if (usernameField.getText().isEmpty()) {
            showConsoleText("Username missing");
            return;
        }

        if (passwordField.getText().isEmpty()) {
            showConsoleText("Password missing");
            return;
        }

        if (!userService.authenticate(usernameField.getText(), Security.getHash(passwordField.getText()))) {
            showConsoleText("Authentication failed");
            return;
        }

        User user =  userService.findbyName(usernameField.getText());
        userService.setCurrentUser(user);

        showConsoleText("Login accepted");
        navigation.loadScreen("wallet");

    }

    private void doRegister() {

        if (usernameField.getText().isEmpty()) {
            showConsoleText("Username missing");
            return;
        }

        if (passwordField.getText().isEmpty()) {
            showConsoleText("Password missing");
            return;
        }

        if (emailField.getText().isEmpty()) {
            showConsoleText("Email missing");
            return;
        }

        if (!emailField.getText().contains("@")) {
            showConsoleText("Enter a proper email");
            return;
        }

        if (userService.findbyName(usernameField.getText()) != null) {
            showConsoleText("Username taken");
            return;
        }

        User user = new User(usernameField.getText(), Security.getHash(passwordField.getText()), emailField.getText());
        user.setWallet(new Wallet());
        userService.addUser(user);

        showLogin();
        showConsoleText("Registration successful");

    }

    private void showConsoleText(String text) {

        messageLabel.setText(text);
        messageLabel.setVisible(true);

    }

    public void onButton(ActionEvent event) {

        if (login) {
            doLogin();
        } else {
            doRegister();
        }


    }

    public void onLink(MouseEvent event) {

        if (login) {
            showRegister();
        } else {
            showLogin();
        }

    }

    public UserService getUserService() {
        return userService;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

}
