package org.academiadecodigo.hackathon;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.academiadecodigo.hackathon.controller.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Navigation {

    public final static int MIN_WIDTH = 1024;
    public final static int MIN_HEIGHT = 768;
    public final static String VIEW_PATH = "/view";
    private LinkedList<Scene> scenes = new LinkedList<>();
    private Map<String, Controller> controllers = new HashMap<>();
    private Stage stage;

    public Navigation() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Controller getController(Class<?> param) {
        return controllers.get(param.getSimpleName());
    }

    public void loadScreen(String param) {

        Parent root = loadView(param);

        Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
        scenes.push(scene);

        setScene(scene);

    }

    public Parent loadView(String view) {

        Parent root = null;

        try {

            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));

            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> param){
                    return controllers.get(param.getSimpleName());
                }
            });

            root = fxmlLoader.load();

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
            e.printStackTrace();
        }

        return root;

    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        scenes.pop();

        setScene(scenes.peek());

    }

    private void setScene(Scene scene) {
        stage.setScene(scene);

        stage.show();
    }

    public void close() {

        stage.close();

    }

    public void setControllers(Map controllers) {
        this.controllers = controllers;
    }

}
