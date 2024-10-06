module edu.farmingdale.autobodyshopapplicationproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.autobodyshopapplicationproject to javafx.fxml;
    exports edu.farmingdale.autobodyshopapplicationproject;
}