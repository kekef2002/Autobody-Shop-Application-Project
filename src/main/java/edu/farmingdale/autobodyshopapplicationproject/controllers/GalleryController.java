package edu.farmingdale.autobodyshopapplicationproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


    public class GalleryController extends AbstractController {

    @FXML
    ImageView zoomInImage;

    @FXML
    StackPane blurPane;

    @FXML
    private MenuItem auto_glass_replacement, auto_repairs_maintenance, collision_repairs, celd;

    @FXML
    private Button gallery_button, home_button, home_login_button, schedule_an_appointment_button;

    @FXML
    private void onImageViewClicked(MouseEvent event){
        System.out.println("It works");
        ImageView clickedImageView = (ImageView) event.getSource();
        Image image = clickedImageView.getImage();
        zoomInImage.setImage(image);
        zoomInImage.setOpacity(1);
        blurPane.setMouseTransparent(false);
        blurPane.setOpacity(.5);
    }

    @FXML
    private void onClickOutsideZoom(MouseEvent event){
        System.out.println("It works part 2");
        zoomInImage.setOpacity(0);
        blurPane.setOpacity(0);
        blurPane.setMouseTransparent(true);
    }

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
