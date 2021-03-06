package org.academiadecodigo.hackathon;

import javafx.stage.Stage;
import org.academiadecodigo.hackathon.controller.Controller;
import org.academiadecodigo.hackathon.controller.LoginController;
import org.academiadecodigo.hackathon.controller.UserWalletController;
import org.academiadecodigo.hackathon.currency.Currency;
import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.Wallet;
import org.academiadecodigo.hackathon.persistence.AppUserDao;
import org.academiadecodigo.hackathon.persistence.UserDao;
import org.academiadecodigo.hackathon.service.AppUserService;
import org.academiadecodigo.hackathon.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main extends javafx.application.Application {

    private Thread t1;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring-config.xml");
        Navigation navigation = applicationContext.getBean("navigation", Navigation.class);

        t1 = new Thread(new Currency());
        t1.start();

        navigation.setStage(primaryStage);



        navigation.loadScreen("login");
        primaryStage.setResizable(false);

        primaryStage.setTitle("Billionaire Generator");
        primaryStage.show();

    }



}
