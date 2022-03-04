package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PatientPanelController {


    public Label disease_tf;
    public Label status_tf;

    public void getNationalCode(String nationalCode){
        try {
            File f1 = new File("doctorOpinion.txt");

            FileReader fileReader = new FileReader("doctorOpinion.txt");
            BufferedReader br = new BufferedReader(new FileReader("doctorOpinion.txt"));

            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals(nationalCode)) {

                    while (!(s = br.readLine()).equals("information")) {
                        if (s.equals("disease")){
                            s = br.readLine();
                                disease_tf.setText(s);
                        }
                        if (s.equals("status")) {
                            s = br.readLine();
                                status_tf.setText(s);
                        }

                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onClickBackBtn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) disease_tf.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PatientLogin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
