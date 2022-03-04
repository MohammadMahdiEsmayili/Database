package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DoctorOpinionController {


    public TextField disease_tf;
    public TextField date;
    public TextField Surgical_details_tf;
    public TextField Patient_status_tf;

    String nationalCode;

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void onClickOkBtn(ActionEvent actionEvent) throws IOException {
        try {
            File f1 = new File("doctorOpinion.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(), true);
            BufferedWriter bw = new BufferedWriter(fileWritter);

            bw.write(nationalCode + "\n");
            bw.write("disease\n");
            bw.write(disease_tf.getText() + "\n");
            bw.write("date\n");
            bw.write(date.getText() + "\n");
            bw.write("details\n");
            bw.write(Surgical_details_tf.getText() + "\n");
            bw.write("status\n");
            bw.write(Patient_status_tf.getText() + "\n");
            bw.write("information\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = (Stage) disease_tf.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DoctorLogin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
