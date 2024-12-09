module edu.farmingdale.autobodyshopapplicationproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens edu.farmingdale.autobodyshopapplicationproject to javafx.fxml;
    exports edu.farmingdale.autobodyshopapplicationproject;
    exports edu.farmingdale.autobodyshopapplicationproject.controllers;
    opens edu.farmingdale.autobodyshopapplicationproject.controllers to javafx.fxml;
}