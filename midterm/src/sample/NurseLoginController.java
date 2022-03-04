package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class NurseLoginController {
    public Button bt;
    public TextField nurse_username_tf;
    public PasswordField nurse_password_tf;

    public void btn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) bt.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("WellcomeStage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onClickLogin(ActionEvent actionEvent) {
        int found = 0;
        String nurseName = null;
        try {
            File f1 = new File("NurseInformation.txt");

            FileReader fileReader = new FileReader("NurseInformation.txt");
            BufferedReader br = new BufferedReader(new FileReader("NurseInformation.txt"));

            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals(nurse_username_tf.getText())) {
                    found = 1;
                    s = br.readLine();
                    if (found == 1) {
                        if (s.equals(nurse_password_tf.getText())) {
                            found = 2;
                            s = br.readLine();
                            nurseName = s;
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
                        if (s2.equals(nurseName)) {
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NursePanel.fxml"));
                Parent root = loader.load();
                NursePanelController controller = loader.getController();
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
