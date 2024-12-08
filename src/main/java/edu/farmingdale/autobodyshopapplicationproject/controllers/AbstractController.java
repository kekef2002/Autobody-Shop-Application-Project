package edu.farmingdale.autobodyshopapplicationproject.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class AbstractController {

    protected void loadScene(String fxmlPath, Object eventSource, int width, int height) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load(), width, height);

            // Determine the stage from the event source
            Stage stage;
            if (eventSource instanceof javafx.scene.Node) {
                stage = (Stage) ((javafx.scene.Node) eventSource).getScene().getWindow();
            } else if (eventSource instanceof javafx.scene.control.MenuItem) {
                stage = (Stage) ((javafx.scene.control.MenuItem) eventSource).getParentPopup().getOwnerWindow();
            } else {
                throw new IllegalArgumentException("Unsupported event source type");
            }

            // Set the new scene
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showErrorDialog("Page Load Error", "Failed to load the requested page.");
        }
    }

    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}