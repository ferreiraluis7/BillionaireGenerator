package org.academiadecodigo.hackathon;

import javafx.stage.Stage;
import org.academiadecodigo.hackathon.controller.LoginController;
import org.academiadecodigo.hackathon.model.User;
import org.academiadecodigo.hackathon.model.Wallet;
import org.academiadecodigo.hackathon.persistence.AppUserDao;
import org.academiadecodigo.hackathon.persistence.UserDao;
import org.academiadecodigo.hackathon.service.AppUserService;
import org.academiadecodigo.hackathon.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;

public class Test extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring-config.xml");
       /* Navigation navigation = applicationContext.getBean("navigation", Navigation.class);

        navigation.setStage(primaryStage);

        navigation.loadScreen(LoginController.class.getSimpleName());

        primaryStage.setTitle("Billionaire Generator");
        primaryStage.show();*/
        UserService service = (UserService) applicationContext.getBean("userService");
        User user = new User("soraia", "sss", "soraia@gmail.com");
        service.addUser(user);
        User user1 = service.findbyName("soraia");
        user1.setWallet(new Wallet());
        service.addUser(user1);

    }
}
