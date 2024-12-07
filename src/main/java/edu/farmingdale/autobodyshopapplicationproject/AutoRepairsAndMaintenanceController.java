package edu.farmingdale.autobodyshopapplicationproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AutoRepairsAndMaintenanceController {



    @FXML
    private Button about_us_button;

    @FXML
    private MenuItem auto_glass_replacement_button;

    @FXML
    private MenuItem auto_repairs_maintenance_button;

    @FXML
    private MenuItem celd_button;

    @FXML
    private MenuItem collision_repairs_button;

    @FXML
    private Button gallery_button;

    @FXML
    private Button home_button;

    @FXML
    private Button home_login_button;

    @FXML
    private Button schedule_an_appointment_button;

    @FXML
    private ImageView v15_67;

    @FXML
    private ImageView v164_30;

    @FXML
    private ImageView v164_31;

    @FXML
    private ImageView v164_32;

    @FXML
    void onAboutUsButtonClick(ActionEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("about-us.fxml"));
            Scene homeLoginScene = new Scene(loader.load(), 1440, 1024);

            // Get the Stage from the Event Source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeLoginScene);
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
    void onAutoGlassReplacementButtonClick(ActionEvent event) {

    }

    @FXML
    void onAutoRepairsMaintenanceButtonClick(ActionEvent event) {

    }

    @FXML
    void onCELDButtonClick(ActionEvent event) {

    }

    @FXML
    void onCollisionRepairsButtonClick(ActionEvent event) {

    }

    @FXML
    void onGalleryButtonClick(ActionEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gallery-page.fxml"));
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
