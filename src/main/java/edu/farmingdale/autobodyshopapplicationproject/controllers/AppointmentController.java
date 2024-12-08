package edu.farmingdale.autobodyshopapplicationproject.controllers;

import edu.farmingdale.autobodyshopapplicationproject.dao.DbConnection;
import edu.farmingdale.autobodyshopapplicationproject.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class AppointmentController extends AbstractController {

    @FXML
    private Button about_us_button, clearbutton, current_coupons, customerfeedback, gallery_button, home_button, home_login_button, next_service_due, service_history, submitbutton;

    @FXML
    private TextField address_text_field, appointment_time_dropdown, apt_text_field, city_text_field, email_text_field, first_name_text_field, last_name_text_field, license_plate_text_field, make_text_field, mi_text_field, mileage_text_field, model_text_field, telephone_text_field, year_text_field, zip_code_text_field;

    @FXML
    private DatePicker appointment_date;

    @FXML
    private ChoiceBox<String> appointment_time;

    @FXML
    private Label selected_time_label;

    @FXML
    private MenuItem auto_glass_replacement, auto_repairs_maintenance, collision_repairs, celd;

    @FXML
    private TextArea customer_comments;

    @FXML
    private ComboBox<String> license_plate_state_dropdown, select_transport_needs_dropdown, service_request_dropdown, preferred_contact_dropdown;

    @FXML
    private Region speedometerRegion;
    @FXML
    private Button next_appointment_date;

    @FXML
    private ComboBox<String> state_dropdown;

    @FXML
    private ImageView v15_227;

    @FXML
    void onLicensePlateStateScrolldown(MouseEvent event) {
        // Populate states in the dropdown
        ObservableList<String> usStates = FXCollections.observableArrayList(
                "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
                "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV",
                "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
                "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
        );

        license_plate_state_dropdown.setItems(usStates);

        // Optional: Set a default placeholder or selection
        license_plate_state_dropdown.setPromptText("Select State");

        // Listener for selected state
        license_plate_state_dropdown.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("Selected State: " + newValue);
            }
        });

    }


    @FXML
    void onAppointmenTimeScrolldown(MouseEvent event) {
        // Populate appointment_time ChoiceBox with 30-minute intervals
        ObservableList<String> timeSlots = FXCollections.observableArrayList();
        LocalTime startTime = LocalTime.of(9, 0); // Start time: 9:00 AM
        LocalTime endTime = LocalTime.of(17, 0); // End time: 5:00 PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        while (!startTime.isAfter(endTime)) {
            timeSlots.add(startTime.format(formatter));
            startTime = startTime.plusMinutes(30);
        }

        appointment_time.setItems(timeSlots);

        // Set a listener to display the selected time
        appointment_time.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selected_time_label.setText("Selected Time: " + newValue);
            }
        });
    }

    @FXML
    void onAppointmentDateButtonClick(ActionEvent event) {

    }

    @FXML
    void onClearButtonClick(ActionEvent event) {
        if (validateFields()) {
            // Proceed with clearing fields or submitting data
        }
    }

    @FXML
    void onSubmitButtonClick(ActionEvent event) {
        if (validateFields()) {
            // Proceed with clearing fields or submitting data
        }
    }

    @FXML
    void onNextAppointmentButtonClick(ActionEvent event) {
        String userEmail = LoginController.getLoggedInUserEmail(); // Retrieve logged-in user's email

        if (userEmail == null || userEmail.isEmpty()) {
            // Prompt user to log in
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login Required");
            alert.setHeaderText("You must log in first");
            alert.setContentText("Please log in to view your next appointment.");
            alert.showAndWait();
            return;
        }

        DbConnection dbConnection = new DbConnection();
        Person person = dbConnection.getPerson(userEmail);

        if (person != null && person.getNextAppointmentDate() != null) {
            // Load the next appointment view and pass person data
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/next-appointment.fxml"));
                Parent root = loader.load();

                // Pass the person data to the NextAppointmentController
                NextAppointmentController controller = loader.getController();
                controller.setPerson(person);

                // Display the next appointment view
                Stage stage = new Stage();
                stage.setTitle("Next Appointment Details");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Appointment Found");
            alert.setHeaderText("No Upcoming Appointments");
            alert.setContentText("No next appointment found for the logged-in user.");
            alert.showAndWait();
        }
    }


    @FXML
    void onCustomerFeedbackButtonClick(ActionEvent event) {

    }


    @FXML
    void onNextServiceDueButtonClick(ActionEvent event) {

    }

    @FXML
    void onPreferredContactScrolldown(MouseEvent event) {
        // Populate preferred_contact_dropdown
        ObservableList<String> contactMethods = FXCollections.observableArrayList(
                "Email",
                "Telephone",
                "Text"
        );
        preferred_contact_dropdown.setItems(contactMethods);
        preferred_contact_dropdown.setPromptText("Select Preferred Contact");
    }

    @FXML
    void onSelectTransportNeedsScrolldown(MouseEvent event) {
        // Populate select_transport_needs_dropdown
        ObservableList<String> transportNeeds = FXCollections.observableArrayList(
                "I'll be Dropping my vehicle off",
                "I'd like a courtesy loaner vehicle during my service",
                "I'd like to wait for my service"
        );
        select_transport_needs_dropdown.setItems(transportNeeds);
        select_transport_needs_dropdown.setPromptText("Select Transportation Needs");
    }

    @FXML
    void onServiceHistoryButtonClick(ActionEvent event) {

    }

    @FXML
    void onServiceRequestScrolldown(MouseEvent event) {
        // Populate service_request_dropdown
        ObservableList<String> serviceRequests = FXCollections.observableArrayList(
                "Collision Repairs",
                "Auto Repair and Maintenance",
                "CELD",
                "Auto Glass Replacement"
        );
        service_request_dropdown.setItems(serviceRequests);
        service_request_dropdown.setPromptText("Select a Service Request");
    }

        @FXML
    void onStateScrolldown(MouseEvent event) {
            // Populate states in the dropdown
            ObservableList<String> usStates = FXCollections.observableArrayList(
                    "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
                    "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV",
                    "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
                    "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
            );

            state_dropdown.setItems(usStates);

            // Optional: Set a default placeholder or selection
            state_dropdown.setPromptText("Select State");

            // Listener for selected state
            state_dropdown.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    System.out.println("Selected State: " + newValue);
                }
            });
    }


    public boolean validateFields() {
        StringBuilder errors = new StringBuilder();

        if (address_text_field.getText().isEmpty()) {
            errors.append("Address cannot be empty.\n");
        }

        if (apt_text_field.getText().length() > 10) { // Example constraint
            errors.append("Apt/Unit field must be less than 10 characters.\n");
        }

        if (city_text_field.getText().isEmpty()) {
            errors.append("City cannot be empty.\n");
        }

        if (!email_text_field.getText().matches("^\\S+@\\S+\\.\\S+$")) {
            errors.append("Invalid email address format.\n");
        }

        if (first_name_text_field.getText().isEmpty()) {
            errors.append("First Name cannot be empty.\n");
        }

        if (last_name_text_field.getText().isEmpty()) {
            errors.append("Last Name cannot be empty.\n");
        }

        if (!license_plate_text_field.getText().matches("^[A-Za-z0-9]{1,7}$")) {
            errors.append("License Plate must be alphanumeric and up to 7 characters.\n");
        }

        if (make_text_field.getText().isEmpty()) {
            errors.append("Make cannot be empty.\n");
        }

        if (!mi_text_field.getText().matches("^[A-Za-z]$")) {
            errors.append("M.I must be a single letter.\n");
        }

        if (!mileage_text_field.getText().matches("^\\d+$")) {
            errors.append("Mileage must be a number.\n");
        }

        if (model_text_field.getText().isEmpty()) {
            errors.append("Model cannot be empty.\n");
        }

        if (!telephone_text_field.getText().matches("^\\d{10}$")) {
            errors.append("Telephone must be a 10-digit number.\n");
        }

        if (!year_text_field.getText().matches("^\\d{4}$")) {
            errors.append("Year must be a 4-digit number.\n");
        }

        if (!zip_code_text_field.getText().matches("^\\d{5}$")) {
            errors.append("Zip Code must be a 5-digit number.\n");
        }

        if (state_dropdown.getValue() == null) {
            errors.append("Please select a state.\n");
        }

        if (license_plate_state_dropdown.getValue() == null) {
            errors.append("Please select a state.\n");
        }

        if (errors.length() > 0) {
            // Show error messages in an alert dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Errors");
            alert.setHeaderText("Please fix the following errors:");
            alert.setContentText(errors.toString());
            alert.showAndWait();
            return false;
        }

        return true;
    }
    @FXML
    void onAboutUsButtonClick(ActionEvent event) {
        loadScene("/edu/farmingdale/autobodyshopapplicationproject/fxml/about-us.fxml", event.getSource(), 1440, 650);
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
