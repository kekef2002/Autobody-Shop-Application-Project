package edu.farmingdale.autobodyshopapplicationproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;


public class AutoRepairsAndMaintenanceController extends AbstractController {

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
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/about-us.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onApptointmentButtonClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/appointment-page.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onAutoGlassReplacementClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/auto-glass-replacement-page.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onAutoRepairsMaintenanceClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/auto-repairs-and-maintenance-page.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onCELDClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/celd-page.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onCollisionRepairsClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/collision-repairs-page.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onGalleryButtonClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/gallery-page.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onHomeButtonClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/home-page.fxml", event.getSource(), 1440, 650);
    }

    @FXML
    void onHomeLoginButtonClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/login-page.fxml", event.getSource(), 1440, 650);
    }
}
