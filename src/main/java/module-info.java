module com.example.proyecto_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires org.apache.pdfbox;
    requires org.apache.fontbox;
    requires commons.logging;

    requires java.xml;


    opens GUI to javafx.fxml;
    exports GUI;
}