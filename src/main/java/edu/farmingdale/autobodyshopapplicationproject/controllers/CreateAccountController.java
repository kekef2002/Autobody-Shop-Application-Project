package edu.farmingdale.autobodyshopapplicationproject.controllers;

import edu.farmingdale.autobodyshopapplicationproject.dao.DbConnection;
import edu.farmingdale.autobodyshopapplicationproject.model.Person;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class CreateAccountController {

    @FXML
    private Label alreadyhaveanaccount;

    @FXML
    private TextField confirm_email_text_field;

    @FXML
    private PasswordField confirrm_password_text_field;

    @FXML
    private Button create_account_button;

    @FXML
    private TextField email_text_field;

    @FXML
    private TextField first_name_text_field;

    @FXML
    private TextField last_name_text_field;

    @FXML
    private PasswordField password_text_field;

    @FXML
    private ImageView v15_179;

    private static String registeredEmail;

    public static String getRegisteredEmail() {
        return registeredEmail;
    }

    private static String registeredPassword;

    public static String getRegisteredPassword() {
        return registeredPassword;
    }

    // Regex patterns for validation
    private static final String NAME_PATTERN = "^[A-Za-z]{2,25}$";
    private static final String EMAIL_PATTERN = "^[\\w.%+-]+@[\\w.-]+\\.(com|edu|org)$";
    private static final String PASSWORD_PATTERN = "^[0-9A-Za-z]{8,20}$";

    /**
     * Initializes event listeners for each input field to provide validation feedback
     * and to enable the register button only when all fields are valid.
     */
    @FXML
    public void initialize() {
        create_account_button.setDisable(true);

        first_name_text_field.textProperty().addListener((observable, oldValue, newValue) -> enableCreateAccountButton());
        last_name_text_field.textProperty().addListener((observable, oldValue, newValue) -> enableCreateAccountButton());
        email_text_field.textProperty().addListener((observable, oldValue, newValue) -> enableCreateAccountButton());
        password_text_field.textProperty().addListener((observable, oldValue, newValue) -> enableCreateAccountButton());
        confirm_email_text_field.textProperty().addListener((observable, oldValue, newValue) -> enableCreateAccountButton());
        confirrm_password_text_field.textProperty().addListener((observable, oldValue, newValue) -> enableCreateAccountButton());

        // Trigger initial validation
        enableCreateAccountButton();
    }

    /**
     * Validates the given TextField's input against the specified regex pattern.
     * Changes the TextField border color based on validity.
     *
     * @param textField The TextField to validate.
     * @param pattern   The regex pattern for validation.
     * @throws IllegalArgumentException if the text field or pattern is null.
     */
    private void validateField(TextField textField, String pattern) {
        if (!textField.getText().matches(pattern)) {
            textField.setStyle("-fx-border-color: red;"); // Highlight the field in red
            if (textField == email_text_field) { // Check if this is the email field
                textField.setPromptText("This email is not valid");
            } else {
                textField.setPromptText("Invalid input");
            }
        } else {
            textField.setStyle("-fx-border-color: green;"); // Highlight the field in green
            textField.setPromptText(""); // Clear the prompt text
        }
    }

    private void validateMatch(TextField confirmField, TextField originalField, String errorMessage) {
        if (!confirmField.getText().equals(originalField.getText())) {
            confirmField.setStyle("-fx-border-color: red;");
            confirmField.setPromptText(errorMessage);
        } else {
            confirmField.setStyle("-fx-border-color: green;");
        }
    }

    /**
     * Enables the register button if all fields are valid, otherwise disables it.
     */
    private void enableCreateAccountButton() {
        boolean firstNameValid = first_name_text_field.getText().matches(NAME_PATTERN);
        boolean lastNameValid = last_name_text_field.getText().matches(NAME_PATTERN);
        boolean emailValid = email_text_field.getText().matches(EMAIL_PATTERN);
        boolean emailMatches = confirm_email_text_field.getText().equals(email_text_field.getText());
        boolean passwordValid = password_text_field.getText().matches(PASSWORD_PATTERN);
        boolean passwordMatches = confirrm_password_text_field.getText().equals(password_text_field.getText());

        boolean allValid = firstNameValid && lastNameValid && emailValid && emailMatches && passwordValid && passwordMatches;

        // Debugging output
        System.out.println("First Name Valid: " + firstNameValid);
        System.out.println("Last Name Valid: " + lastNameValid);
        System.out.println("Email Valid: " + emailValid);
        System.out.println("Email Matches: " + emailMatches);
        System.out.println("Password Valid: " + passwordValid);
        System.out.println("Password Matches: " + passwordMatches);
        System.out.println("All Valid: " + allValid);

        create_account_button.setDisable(!allValid);
    }

    @FXML
    void onAlreadyHaveAnAccountClick(MouseEvent event) {
        try {
            // Load Appointment Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/login-page.fxml"));
            Scene homeLoginScene = new Scene(loader.load(), 1440, 650);

            // Get the Stage from the Event Source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeLoginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onCreateAccountButtonClick(ActionEvent event) {
        // Show success message
        confirm_email_text_field.setStyle("-fx-border-color: green;");
        confirrm_password_text_field.setStyle("-fx-border-color: green;");
        create_account_button.setText("Create Account successful!");

        String firstName = first_name_text_field.getText();
        String lastName = last_name_text_field.getText();
        String email = email_text_field.getText();
        String password = password_text_field.getText();

        Person newPerson = new Person();
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setEmail(email);
        newPerson.setPassword(password);

        DbConnection dbConnection = new DbConnection();
        boolean isRegistered = dbConnection.registerUser(newPerson);

        if (isRegistered) {
            registeredEmail = email; // Store the registered email
            registeredPassword = password; // Store the registered password
            navigateToLogin(event);
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "Problem inserting registration to database.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void navigateToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/login-page.fxml"));
            Stage stage = (Stage) create_account_button.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
