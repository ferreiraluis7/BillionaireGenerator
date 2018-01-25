package org.academiadecodigo.hackathon;

import javafx.stage.Stage;
import org.academiadecodigo.hackathon.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
        Navigation navigation = applicationContext.getBean("navigation", Navigation.class);

        navigation.setStage(primaryStage);

        navigation.loadScreen(LoginController.class.getSimpleName());

        primaryStage.setTitle("Billionaire Generator");
        primaryStage.show();
    }
}
