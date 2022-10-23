module com.example.proyecto_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires java.xml;


    opens GUI to javafx.fxml;
    exports GUI;
}