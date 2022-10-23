package GUI;

import Logica.Documento;
import Logica.Mensaje;
import Socket.Cliente;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WindowMainController implements Initializable {
    @FXML
    private Label test_label;
    @FXML
    private Label archivos;
    @FXML
    private Pane pane_archivos;
    @FXML
    private Button search_button;
    @FXML
    private Button indizar_button;
    @FXML
    private Button moveFile_button;
    @FXML
    private ChoiceBox<String> choiceBox_Algoritmo;
    @FXML
    private TextField searchWord_textField;
    @FXML
    private TextField moveFile_textField;
    @FXML
    private VBox vBox_search_word;
    private Stage stage;
    private ArrayList<Documento> lista_contiene_palabra = new ArrayList<>();
    private String searching_word = "";
    private String[] algoritmos = {"Nombre", "Fecha", "Palabras"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox_Algoritmo.getItems().addAll(algoritmos);
        choiceBox_Algoritmo.setOnAction(this::ChoiceBox_Algoritmo_Selection);
    }

    private void ChoiceBox_Algoritmo_Selection(Event event) {
//Esto habra que cambiarlo
        /*this.searching_word = choiceBox_Algoritmo.getValue();
        System.out.println(searching_word);


        Cliente cliente = new Cliente("192.168.1.184",9000);
        Mensaje mensaje = new Mensaje(null, searching_word);


        test_label.setText(cliente.sendSearch(mensaje).getMensaje());*/
    }

    @FXML
    private void closeApp(ActionEvent event) {
        this.stage.close();
    }
    @FXML
    private void moveFile(){
        File file = new File(moveFile_textField.getText());
        File carpeta = new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos");

        String carpeta_ruta = carpeta.getAbsolutePath() + "\\" + file.getName();
        System.out.println(carpeta_ruta);

        try {
            Files.move(file.toPath(), Path.of(carpeta_ruta), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    @FXML
    private void search_word(){
        //Adrian Ip aparta "192.168.1.184"
        //Adrian Ip casa "192.168.5.171"
        //Sebas Ip
        //Sebas Ip


        Cliente cliente = new Cliente("192.168.5.171",9000);
        this.searching_word = searchWord_textField.getText();
        Mensaje mensaje = new Mensaje(searching_word,null);

        test_label.setText(cliente.sendSearch(mensaje).getMensaje());

        //vBox_search_word_llenar(cliente.sendSearch(mensaje));
        searchWord_textField.clear();
    }



    @FXML
    private void indizar(){
        Cliente cliente = new Cliente("192.168.5.171",9000);
        Mensaje mensaje = new Mensaje(null, "Indizando");

        cliente.sendIndizacion(mensaje);


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
    private void vBox_search_word_llenar(ArrayList<Documento> lista_contiene_palabra){
        Label[] labels = new Label[lista_contiene_palabra.size()];
        for (int i = 0; i<=lista_contiene_palabra.size(); i++){
            labels[i] = new Label();
            vBox_search_word.getChildren().add(labels[i]);
            labels[i].setText(lista_contiene_palabra.get(i).getNombre());

        }

    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void show(){
        stage.show();
    }
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}