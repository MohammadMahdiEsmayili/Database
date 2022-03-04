package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AccountingError_controller {
    public Button ok;

    public void onClickOk(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ok.getScene().getWindow();
        primaryStage.close();
    }
}
