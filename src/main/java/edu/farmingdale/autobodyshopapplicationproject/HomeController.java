package edu.farmingdale.autobodyshopapplicationproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button about_us_button;

    @FXML
    private MenuItem auto_glass_replacement;

    @FXML
    private MenuItem auto_repairs_maintenance;

    @FXML
    private MenuItem celd;

    @FXML
    private MenuItem collision_repairs;


    @FXML
    private Button gallery_button;

    @FXML
    private Button home_button;

    @FXML
    private Button home_login_button;

    @FXML
    private Button schedule_an_appointment_button;

    @FXML
    private ImageView v13_14;

    @FXML
    private ImageView v13_28;

    @FXML
    void onAboutUsButtonClick(ActionEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("about-us-page.fxml"));
            Scene aboutUsScene = new Scene(loader.load(), 1440, 1024);

            // Get the Stage from the Event Source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(aboutUsScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onApptointmentButtonClick(ActionEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("appointment-page.fxml"));
            Scene appointmentScene = new Scene(loader.load(), 1440, 1024);

            // Get the Stage from the Event Source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(appointmentScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onAutoGlassReplacementClick(ActionEvent event) {
        try {
            // Load the FXML for the target page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("auto-repairs-and-maintenance-page.fxml"));
            Scene autoGlassReplacementScene = new Scene(loader.load(), 1440, 1980);

            // Get the current stage from the event source (parent scene)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

            // Set the new scene
            stage.setScene(autoGlassReplacementScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, you can show an error dialog to the user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Page Load Error");
            alert.setContentText("Failed to load the Auto Glass Repair page.");
            alert.showAndWait();
        }
    }

    @FXML
    void onAutoRepairsMaintenanceClick(ActionEvent event) {
        try {
            // Load the FXML for the target page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("auto-repairs-and-maintenance-page.fxml"));
            Scene autoRepairScene = new Scene(loader.load(), 1440, 2555);

            // Get the current stage from the event source (parent scene)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

            // Set the new scene
            stage.setScene(autoRepairScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, you can show an error dialog to the user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Page Load Error");
            alert.setContentText("Failed to load the Auto Repairs and Maintenance page.");
            alert.showAndWait();
        }
    }

    @FXML
    void onCELDClick(ActionEvent event) {
        try {
            // Load the FXML for the target page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("auto-repairs-and-maintenance-page.fxml"));
            Scene CELDScene = new Scene(loader.load(), 1440, 1024);

            // Get the current stage from the event source (parent scene)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

            // Set the new scene
            stage.setScene(CELDScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, you can show an error dialog to the user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Page Load Error");
            alert.setContentText("Failed to load the Check Engine Light Diagnostics page.");
            alert.showAndWait();
        }
    }

    @FXML
    void onCollisionRepairsClick(ActionEvent event) {
        try {
            // Load the FXML for the target page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("auto-repairs-and-maintenance-page.fxml"));
            Scene collisionRepairsScene = new Scene(loader.load(), 1440, 1024);

            // Get the current stage from the event source (parent scene)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

            // Set the new scene
            stage.setScene(collisionRepairsScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, you can show an error dialog to the user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Page Load Error");
            alert.setContentText("Failed to load the Collision Repair page.");
            alert.showAndWait();
        }
    }

    @FXML
    void onGalleryButtonClick(ActionEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gallery/gallery-page.fxml"));
            Scene galleryScene = new Scene(loader.load(), 1440, 1024);

            // Get the Stage from the Event Source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(galleryScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onHomeButtonClick(ActionEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home-page.fxml"));
            Scene homeScene = new Scene(loader.load(), 1440, 1024);

            // Get the Stage from the Event Source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onHomeLoginButtonClick(ActionEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-page.fxml"));
            Scene homeLoginScene = new Scene(loader.load(), 1440, 1024);

            // Get the Stage from the Event Source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeLoginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
