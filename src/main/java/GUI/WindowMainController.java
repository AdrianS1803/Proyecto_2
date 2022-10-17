package GUI;

import Socket.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class WindowMainController {
    @FXML
    private Label test_label;
    @FXML
    private Label archivos;
    @FXML
    private Pane pane_archivos;
    @FXML
    private Button search_button;
    @FXML
    private Button test;
    @FXML
    private TextField textField_search_word;
    private Stage stage;

    @FXML
    private void closeApp(ActionEvent event) {
        this.stage.close();
    }
    @FXML
    private void search_word(){
        //Adrian Ip aparta "192.168.1.184"
        //Adrian Ip casa "192.168.5.171"
        //Sebas Ip
        //Sebas Ip

        Cliente cliente = new Cliente("192.168.1.184",9000);

        test_label.setText(cliente.send(textField_search_word.getText()));
    }
    @FXML
    private void indizar(){
        pane_archivos.getChildren().clear();
        File ruta = new File("Archivos");
        archivos.setText(ruta.getName());
        String[] archives_name = ruta.list();
        Label[] archivos_labels = new Label[archives_name.length];

        for (int i=0; i<archives_name.length; i++){
            archivos_labels[i] = new Label();
            pane_archivos.getChildren().add(archivos_labels[i]);
            archivos_labels[i].setText(archives_name[i]);
            File f = new File(ruta.getAbsolutePath(), archives_name[i]);

            if (f.isDirectory()){
                String[] archivos_subcarpeta = f.list();

                for (int j=0;j<archivos_subcarpeta.length;j++){
                    archivos_labels[i] = new Label();
                    pane_archivos.getChildren().add(archivos_labels[j]);
                    archivos_labels[j].setText("    " + archivos_subcarpeta[j]);
                }
            }


        }
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void show(){
        stage.show();
    }


}