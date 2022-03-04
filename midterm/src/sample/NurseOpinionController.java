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

public class NurseOpinionController {
    public TextField date;
    public TextField time;
    public TextField medications;
    public TextField condition;
    public TextField description;

    String nationalCode;

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void onClickOkBtn(ActionEvent actionEvent) throws IOException {
        try {
            File f1 = new File("nurseOpinion.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(), true);
            BufferedWriter bw = new BufferedWriter(fileWritter);

            bw.write(nationalCode + "\n");
            bw.write(date.getText() + "\n");
            bw.write(time.getText() + "\n");
            bw.write(medications.getText() + "\n");
            bw.write(condition.getText() + "\n");
            bw.write(description.getText() + "\n");
            bw.write("information\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = (Stage) date.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("NurseLogin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
