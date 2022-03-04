package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PatientLoginController {
    public Button bt;
    public PasswordField patient_password_tf;
    public TextField patient_username_tf;

    public void btn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) bt.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("WellcomeStage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void patientLoginBtn(ActionEvent actionEvent) throws IOException {
        int found = 0;
        try {
            File f1 = new File("PatientInformation.txt");

            FileReader fileReader = new FileReader("PatientInformation.txt");
            BufferedReader br = new BufferedReader(new FileReader("PatientInformation.txt"));

            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals(patient_username_tf.getText())) {
                    found = 1;
                    s = br.readLine();
                    if (found == 1) {
                        if (s.equals(patient_password_tf.getText())) {
                            found = 2;
                        }
                    }
                }

            }
            br.close();
            if (found == 0 || found == 1) {
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
            if (found == 2) {
                Stage primaryStage = (Stage) bt.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientPanel.fxml"));
                Parent root = loader.load();
                PatientPanelController controller = loader.getController();
                controller.getNationalCode(patient_username_tf.getText());
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }

        } catch (IOException e) {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }

}
