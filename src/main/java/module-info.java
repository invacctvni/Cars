module com.example.cars {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cars to javafx.fxml;
    exports com.example.cars;
}