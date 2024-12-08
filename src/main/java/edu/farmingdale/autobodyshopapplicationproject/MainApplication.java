package edu.farmingdale.autobodyshopapplicationproject;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader splashLoader = new FXMLLoader(MainApplication.class.getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/splashscreen-page.fxml"));
        Pane splashPane = splashLoader.load();

        Scene splashScene = new Scene(splashPane, 650, 650);
        stage.setTitle("Solution AutoBody Shop");
        stage.setScene(splashScene);
        stage.show();

        // Apply Fade Transition
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), splashPane);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(event -> {
            try {
                // Load Home Page
                FXMLLoader homeLoader = new FXMLLoader(MainApplication.class.getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/home-page.fxml"));
                Scene homeScene = new Scene(homeLoader.load(), 1440, 650);
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

