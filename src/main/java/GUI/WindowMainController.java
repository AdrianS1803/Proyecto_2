package GUI;

import Logica.Documento;

import Logica.Mensaje;
import Socket.Cliente;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 octubre 2022
 */
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
    private Button deleteFile_button;
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
    ///------------------Cambiar esto siempre
    private String ip = "192.168.5.171";

    /**
     * Inicializa la datos en la ventana.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox_Algoritmo.getItems().addAll(algoritmos);
        choiceBox_Algoritmo.setOnAction(this::ChoiceBox_Algoritmo_Selection);
        indizar();
    }

    /**
     * Llama a las opciones del choiceBox para elegir como ordenar los resultados.
     * @param event
     */
    private void ChoiceBox_Algoritmo_Selection(Event event) {

        this.searching_word = choiceBox_Algoritmo.getValue();
        System.out.println(searching_word);


        Cliente cliente = new Cliente(ip,9000);
        Mensaje mensaje = new Mensaje(null, searching_word);

        lista_contiene_palabra = cliente.sendMensaje(mensaje);
        llenar();
    }

    /**
     * Cierra la aplicación.
     * @param event
     */
    @FXML
    private void closeApp(ActionEvent event) {
        this.stage.close();
    }

    /**
     * Mueve un archivo ya existente en el computador a la carpeta que se indiza.
     */
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

    /**
     * Borra un archivo de la carpeta que se indiza.
     */
    @FXML
    private void deleteFile(){
        File carpeta = new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto2\\Proyecto_2\\Archivos");
        File file = new File(carpeta.getAbsolutePath()+"\\"+moveFile_textField.getText());

        //No se elimina en tiempo real
        file.deleteOnExit();
    }

    /**
     * Manda una busqueda al servidor.
     */
    @FXML
    private void search_word(){
        //Adrian Ip aparta "192.168.1.184"
        //Adrian Ip casa "192.168.5.171"
        // TEC Ip "172.18.177.16"
        //Sebas Ip
        //Sebas Ip


        Cliente cliente = new Cliente(ip,9000);
        this.searching_word = searchWord_textField.getText();
        Mensaje mensaje = new Mensaje(searching_word,null);

        lista_contiene_palabra = cliente.sendMensaje(mensaje);


        llenar();

    }

    /**
     * Llena el apartado de busquedas con los resultados.
     */
    private void llenar(){
        //----------------

        vBox_search_word.getChildren().clear();

        VBox[] vBoxes = new VBox[lista_contiene_palabra.size()];
        for (int i = 0; i<=lista_contiene_palabra.size()-1; i++){
            vBoxes[i] = new VBox();
            vBox_search_word.getChildren().add(vBoxes[i]);


            Label labelNombre = new Label();
            labelNombre.setText(lista_contiene_palabra.get(i).getNombre());

            vBoxes[i].getChildren().add(labelNombre);

            //-----------------
            HBox hBox_button_searchText = new HBox();

            Label label_searchText = new Label();
            label_searchText.setText("Frase: " + "Antes: " + lista_contiene_palabra.get(i).getFraseShow()[0]+ "Frase: "+ lista_contiene_palabra.get(i).getFraseShow()[1]+ " Despues: "  + lista_contiene_palabra.get(i).getFraseShow()[2]);

            Button button_openDocument = new Button();
            button_openDocument.setText("Abrir");

            int finalI = i;
            button_openDocument.setOnAction(showFile ->{
                try {
                    showFile(lista_contiene_palabra.get(finalI).getRuta());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            hBox_button_searchText.getChildren().add(label_searchText);
            hBox_button_searchText.getChildren().add(button_openDocument);

            vBoxes[i].getChildren().add(hBox_button_searchText);
            //----------------------------------

            //---------------
            HBox hBox_arboles = new HBox();

            Label label_arbolBinario = new Label();
            label_arbolBinario.setText("Comparaciones A.Binario: "+String.valueOf(lista_contiene_palabra.get(i).getComparaciones_ArbolBinario())); // Hacer el metodo devolver comparaciones lista_contiene_palabra.get(i).getArbolBinario().getRoot().getData()

            Label label_AVL = new Label();
            label_AVL.setText("Comparaciones AVL: " + String.valueOf(lista_contiene_palabra.get(i).getComparaciones_AVL()));///Poner este resultado

            Label label_numPalabras = new Label();
            label_numPalabras.setText("Número de palabras: " + lista_contiene_palabra.get(i).getNumero_palabras().toString());


            hBox_arboles.getChildren().add(label_arbolBinario);
            hBox_arboles.getChildren().add(label_AVL);
            hBox_arboles.getChildren().add(label_numPalabras);

            vBoxes[i].getChildren().add(hBox_arboles);


            int color = 230;
            vBoxes[i].setBackground(new Background(new BackgroundFill(Color.rgb(color,color,color),CornerRadii.EMPTY, Insets.EMPTY)));
            //-------------------------------------

        }

        searchWord_textField.clear();
    }

    /**
     * Hace una llamada al servidor donde le suministra todos los archivos de la carpeta designada.
     */
    @FXML
    private void indizar() {
        Cliente cliente = new Cliente(ip, 9000);
        Mensaje mensaje = new Mensaje(null, "Indizando");

        ArrayList<Documento> archivos_hayados = new ArrayList<>();
        archivos_hayados = cliente.sendMensaje(mensaje);

        pane_archivos.getChildren().clear();

        Label espacio = new Label();
        espacio.setText(" ");
        pane_archivos.getChildren().add(espacio);

        Label[] archivosLabel = new Label[archivos_hayados.size()];

        for (int i = 0; i <= archivos_hayados.size() - 1; i++) {
            archivosLabel[i] = new Label();
            archivosLabel[i].setText(archivos_hayados.get(i).getNombre());
            pane_archivos.getChildren().add(archivosLabel[i]);
        }
    }

    /**
     * Abre el archivo en el escritorio del ordenador.
     * @param ruta_file String es la ruta del archivo a abrir.
     */
    private void showFile(String ruta_file){
        try
        {
            File file = new File(ruta_file);
            if(!Desktop.isDesktopSupported())
            {
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists())
                try {
                    desktop.open(file);
                }catch (Exception e){
                    desktop.edit(file);
                }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setea el escenario.
     * @param stage Stage es el escenario.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}