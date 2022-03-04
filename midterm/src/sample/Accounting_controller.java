package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Accounting_controller {


    public Button bt;
    public TextField national_code_tf;
    public TextField full_name_tf;
    public TextField disease_tf;
    public TextField age_tf;
    public TextField gender_tf;
    public TextField specific_diseases_tf;
    String s;

    public void onClickCancel(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) bt.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("WellcomeStage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onClickOk(ActionEvent actionEvent) throws IOException {
        FileManager fm;
        fm = new FileManager();
        fm.writeToFile("PatientInformation.txt", national_code_tf.getText(), full_name_tf.getText(), age_tf.getText(),
                gender_tf.getText(), disease_tf.getText(), specific_diseases_tf.getText());
    }
}
