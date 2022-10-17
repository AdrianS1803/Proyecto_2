package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WindowMainController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void show(){
        stage.show();
    }

    @FXML
    void closeApp(ActionEvent event) {
        this.stage.close();
    }
}