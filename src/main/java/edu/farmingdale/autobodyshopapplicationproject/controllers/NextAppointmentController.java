package edu.farmingdale.autobodyshopapplicationproject.controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import edu.farmingdale.autobodyshopapplicationproject.model.Person;

public class NextAppointmentController {

    @FXML
    private Label customerCommentsLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private ImageView movingCar;

    @FXML
    private Label nameLabel;

    @FXML
    private Label serviceLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label vehicleInfoLabel;

    private Person person;

    private TranslateTransition carAnimation;

    @FXML
    void onCloseButtonClick(ActionEvent event) {
        // Add logic to handle the Close button click, e.g., close the stage or navigate to another page
    }

    public void setPerson(Person person) {
        this.person = person;
        populateAppointmentDetails();
    }

    private void populateAppointmentDetails() {
        nameLabel.setText(person.getFirstName() + " " + person.getLastName());
        dateLabel.setText(person.getNextAppointmentDate().toString());
        timeLabel.setText(person.getAppointmentTime());
        vehicleInfoLabel.setText(person.getYear() + " " + person.getMake() + " " + person.getModel());
        serviceLabel.setText(person.getServiceRequested());
        customerCommentsLabel.setText(person.getCustomerComments());
    }

    @FXML
    public void initialize() {
        startCarAnimation();
    }

    private void startCarAnimation() {
        // Create a TranslateTransition for the car animation
        carAnimation = new TranslateTransition(Duration.seconds(2), movingCar);
        carAnimation.setFromX(-200); // Start off-screen (to the left)
        carAnimation.setToX(800);   // Move off-screen (to the right)
        carAnimation.setCycleCount(TranslateTransition.INDEFINITE); // Infinite loop
        carAnimation.setAutoReverse(false); // No reversing, just keep looping
        carAnimation.play();
    }
}
