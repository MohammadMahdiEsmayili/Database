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
import java.util.ArrayList;

public class DoctorLoginController {
    public Button bt;
    public PasswordField doctor_password_tf;
    public TextField doctor_username_tf;

    public void btn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) bt.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("WellcomeStage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onClickLoginBtn(ActionEvent actionEvent) throws IOException {
        int found = 0;
        String doctorName = null;
        try {
            File f1 = new File("DoctorInformation.txt");

            FileReader fileReader = new FileReader("DoctorInformation.txt");
            BufferedReader br = new BufferedReader(new FileReader("DoctorInformation.txt"));

            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals(doctor_username_tf.getText())) {
                    found = 1;
                    s = br.readLine();
                    if (found == 1) {
                        if (s.equals(doctor_password_tf.getText())) {
                            found = 2;
                            s = br.readLine();
                            doctorName = s;
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
                int nationalCodelength = -1;
                int nameLenght = -1;
                ArrayList<String> listNationalCode = new ArrayList<>();
                ArrayList<String> listName = new ArrayList<>();
                try {
                    File f2 = new File("PatientInformation.txt");

                    FileReader fr = new FileReader("PatientInformation.txt");
                    BufferedReader br2 = new BufferedReader(new FileReader("PatientInformation.txt"));

                    String s2;
                    while ((s2 = br2.readLine()) != null) {
                        if (s2.equals(doctorName)) {
                            while ((s2 = br2.readLine()) != null) {
                                if (s2.equals("nationalcode")) {
                                    s2 = br2.readLine();
                                    listNationalCode.add(s2);
                                    nationalCodelength += 1;
                                    break;
                                }
                            }
                            while ((s2 = br2.readLine()) != null) {
                                if (s2.equals("name")) {
                                    s2 = br2.readLine();
                                    listName.add(s2);
                                    nameLenght += 1;
                                    break;
                                }
                            }
                        }
                    }

                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage primaryStage = (Stage) bt.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorPanel.fxml"));
                Parent root = loader.load();
                DoctorPanelController controller = loader.getController();
                controller.setNational_code_list(listNationalCode, nationalCodelength);
                controller.setName_list(listName, nameLenght);
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
