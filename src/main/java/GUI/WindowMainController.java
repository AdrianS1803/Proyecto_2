package GUI;

import Socket.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowMainController {
    @FXML
    private Label test_label;
    @FXML
    private Button test_button;
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


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void show(){
        stage.show();
    }


}