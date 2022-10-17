module com.example.proyecto_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto_2 to javafx.fxml;
    exports com.example.proyecto_2;
}