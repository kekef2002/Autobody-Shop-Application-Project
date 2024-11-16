package edu.farmingdale.autobodyshopapplicationproject;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader splashLoader = new FXMLLoader(HelloApplication.class.getResource("splashscreen-page.fxml"));
        Pane splashPane = splashLoader.load();

        Scene splashScene = new Scene(splashPane, 1440, 1024);
        stage.setTitle("AutoBody Shop");
        stage.setScene(splashScene);
        stage.show();

        // Apply Fade Transition
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), splashPane);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(event -> {
            try {
                // Load Home Page
                FXMLLoader homeLoader = new FXMLLoader(HelloApplication.class.getResource("home-page.fxml"));
                Scene homeScene = new Scene(homeLoader.load(), 1440, 1024);
                stage.setScene(homeScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fadeTransition.play();
    }

    public static void main(String[] args) {
        launch();
    }
}
