package edu.farmingdale.autobodyshopapplicationproject.dao;

import edu.farmingdale.autobodyshopapplicationproject.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class DbConnection {

    final static String DB_NAME = "Autobody Shop";
    final static String MYSQL_SERVER_URL = "jdbc:mysql://semcsc311server.mysql.database.azure.com";
    final static String DB_URL = MYSQL_SERVER_URL + "/" + DB_NAME;
    final static String USERNAME = "semadmin";
    final static String PASSWORD = "CSC311Programming";


    public boolean connectToDatabase() {
        boolean hasRegisteredUsers = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //First, connect to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            statement.close();
            conn.close();

            //Second, connect to the database and create the table "users" if not created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (" + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "first_name VARCHAR(200) NOT NULL,"
                    + "middle_initial CHAR(1), "
                    + "last_name VARCHAR(200) NOT NULL, "
                    + "address VARCHAR(200) NOT NULL, "
                    + "apt_unit VARCHAR(20), "
                    + "city VARCHAR(200) NOT NULL, "
                    + "state VARCHAR(2) NOT NULL, "
                    + "zip_code VARCHAR(10) NOT NULL, "
                    + "preferred_contact_method VARCHAR(50) NOT NULL, "
                    + "email VARCHAR(200) NOT NULL UNIQUE, "
                    + "telephone VARCHAR(15) NOT NULL, "
                    + "license_plate VARCHAR(20) NOT NULL UNIQUE, "
                    + "license_plate_state VARCHAR(2) NOT NULL, "
                    + "mileage INT(10) NOT NULL, "
                    + "year INT(4) NOT NULL, "
                    + "make VARCHAR(50) NOT NULL, "
                    + "model VARCHAR(50) NOT NULL, "
                    + "transportation_needs VARCHAR(100) NOT NULL, "
                    + "service_requested VARCHAR(100) NOT NULL, "
                    + "appointment_date DATE NOT NULL, "
                    + "appointment_time TIME NOT NULL, "
                    + "customer_comments TEXT, "
                    + "next_appointment_date DATE);";
            statement.executeUpdate(sql);

            //check if we have users in the table users
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegisteredUsers = true;
                }
            }

            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasRegisteredUsers;
    }


    public ObservableList<Person> getData() {
        connectToDatabase();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM users ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String middleInitial = resultSet.getString("middle_initial");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String aptUnit = resultSet.getString("apt_unit");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zipCode = resultSet.getString("zip_code");
                String preferredContactMethod = resultSet.getString("preferred_contact_method");
                String email = resultSet.getString("email");
                String telephone = resultSet.getString("telephone");
                String licensePlate = resultSet.getString("license_plate");
                String licensePlateState = resultSet.getString("license_plate_state");
                int mileage = resultSet.getInt("mileage");
                int year = resultSet.getInt("year");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String transportationNeeds = resultSet.getString("transportation_needs");
                String serviceRequested = resultSet.getString("service_requested");
                Date appointmentDate = resultSet.getDate("appointment_date");
                String appointmentTime = resultSet.getString("appointment_time");
                String customerComments = resultSet.getString("customer_comments");
                Date nextAppointmentDate = resultSet.getDate("next_appointment_date");

//                data.add(new Person(id, firstName, middleInitial, lastName, address, aptUnit, city, state, zipCode, preferredContactMethod, email
//                        ,telephone, licensePlate, licensePlateState, mileage, year, make, model, transportationNeeds, serviceRequested
//                        ,appointmentDate, appointmentTime, customerComments, nextAppointmentDate));

                System.out.println("ID: " + id);
                System.out.println("Name: " + firstName + " " + middleInitial + " " + lastName);
                System.out.println("Address: " + address + ", " + aptUnit + ", " + city + ", " + state + " " + zipCode);
                System.out.println("Next Appointment Date: " + nextAppointmentDate);
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        //return data;
    }

    // Insert a new Person into the database
    public void insertPerson(Person person) {
        connectToDatabase();
        String sql = "INSERT INTO persons (first_name, middle_initial, last_name, address, apt_unit, city, state, zip_code, " +
                "preferred_contact_method, email, telephone, license_plate, license_plate_state, mileage, year, make, model, " +
                "transportation_needs, service_requested, appointment_date, appointment_time, customer_comments, next_appointment_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getMiddleInitial());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getAddress());
            preparedStatement.setString(5, person.getAptUnit());
            preparedStatement.setString(6, person.getCity());
            preparedStatement.setString(7, person.getState());
            preparedStatement.setString(8, person.getZipCode());
            preparedStatement.setString(9, person.getPreferredContactMethod());
            preparedStatement.setString(10, person.getEmail());
            preparedStatement.setString(11, person.getTelephone());
            preparedStatement.setString(12, person.getLicensePlate());
            preparedStatement.setString(13, person.getLicensePlateState());
            preparedStatement.setInt(14, person.getMileage());
            preparedStatement.setInt(15, person.getYear());
            preparedStatement.setString(16, person.getMake());
            preparedStatement.setString(17, person.getModel());
            preparedStatement.setString(18, person.getTransportationNeeds());
            preparedStatement.setString(19, person.getServiceRequested());
            preparedStatement.setDate(20, new java.sql.Date(person.getAppointmentDate().getTime()));
            preparedStatement.setString(21, person.getAppointmentTime());
            preparedStatement.setString(22, person.getCustomerComments());
            preparedStatement.setDate(23, new java.sql.Date(person.getNextAppointmentDate().getTime()));
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}