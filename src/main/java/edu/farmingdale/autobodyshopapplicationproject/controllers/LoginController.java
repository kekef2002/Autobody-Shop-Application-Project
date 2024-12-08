package edu.farmingdale.autobodyshopapplicationproject.controllers;

import edu.farmingdale.autobodyshopapplicationproject.dao.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordTextField;

    private static String loggedInUserEmail;

    public static String getLoggedInUserEmail() {
        return loggedInUserEmail;
    }

    @FXML
    public void onLoginButtonClick(ActionEvent event) {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        // Validate input fields
        if (email.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Login Error", "Please enter both email and password.");
            return;
        }

        // Authenticate user
        if (authenticateUser(email, password)) {
            loggedInUserEmail = email; // Store the logged-in user's email
            navigateToHomePage(event);
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid email or password.");
        }
    }

    private boolean authenticateUser(String email, String password) {
        // Dummy authentication logic (replace with actual DB query)
        DbConnection dbConnection = new DbConnection();
        return dbConnection.authenticateUser(email, password);
    }

    private void navigateToHomePage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/home-page.fxml"));
            Scene scene = new Scene(root, 1440, 650);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onSignUpButtonClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/create-account-page.fxml"));
            Scene scene = new Scene(root, 1440, 650);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
