package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorController {
    public Button ok;

    public void onClickOk(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) ok.getScene().getWindow();
        primaryStage.close();

    }
}
