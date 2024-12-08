package edu.farmingdale.autobodyshopapplicationproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    @FXML
    public void onLoginButtonClick(ActionEvent event) {
        String email = emailTextField.getText();
        String password = String.valueOf(passwordTextField.getText());

        getAuthenticatedUser(email, password);


        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/home-page.fxml"));
            Scene scene = new Scene(root, 1440, 650);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAuthenticatedUser(String email, String password) {

    }

    @FXML
    void onSignUpButtonClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/farmingdale/autobodyshopapplicationproject/fxml/create-account-page.fxml"));
            Scene scene = new Scene(root, 1440, 650);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

