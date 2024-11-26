module edu.farmingdale.autobodyshopapplicationproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens edu.farmingdale.autobodyshopapplicationproject to javafx.fxml;
    exports edu.farmingdale.autobodyshopapplicationproject;
}