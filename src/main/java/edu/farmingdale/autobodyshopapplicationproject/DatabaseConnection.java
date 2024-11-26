package edu.farmingdale.autobodyshopapplicationproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnection {

    public Connection databaseLink;

    final static String DB_NAME = "Solution AutoBody Shop ";
    final static String SQL_SERVER_URL = "jdbc:mysql://semcsc311server.mysql.database.azure.com";//update this server name
    final static String DB_URL = SQL_SERVER_URL + "/" + DB_NAME;
    final static String USERNAME = "semadmin";// update this username
    final static String PASSWORD = "CSC311Programming";// update this password


}
