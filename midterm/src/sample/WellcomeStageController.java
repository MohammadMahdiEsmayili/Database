package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WellcomeStageController {

    public Button a_d;

    public void onClickExit(ActionEvent mouseEvent) {
        System.exit(0);
    }

    public void accountingBtn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) a_d.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Accounting.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void doctorBtn(ActionEvent actionEvent) throws IOException {
        Doctor dr1 = new Doctor("Hamed azizi", 89011181, "hamed81");
        Doctor dr2 = new Doctor("Ali samadi", 89011182, "ali82");
        Doctor dr3 = new Doctor("Karim kazemi", 89011183, "karim83");
        Doctor dr4 = new Doctor("Samad asgari", 89011184, "samad84");
        Doctor dr5 = new Doctor("behnam mosavat", 89011185, "behnam85");

        try {
            File f1 = new File("DoctorInformation.txt");
            if (!f1.exists()) {
                f1.createNewFile();
                FileWriter fileWritter = new FileWriter(f1.getName(), true);
                BufferedWriter bw = new BufferedWriter(fileWritter);

                bw.write(dr1.getPersonnelCode() + "\n");
                bw.write(dr1.getPassword() + "\n");
                bw.write(dr1.getName() + "\n");
                bw.write(dr2.getPersonnelCode() + "\n");
                bw.write(dr2.getPassword() + "\n");
                bw.write(dr2.getName() + "\n");
                bw.write(dr3.getPersonnelCode() + "\n");
                bw.write(dr3.getPassword() + "\n");
                bw.write(dr3.getName() + "\n");
                bw.write(dr4.getPersonnelCode() + "\n");
                bw.write(dr4.getPassword() + "\n");
                bw.write(dr5.getPersonnelCode() + "\n");
                bw.write(dr5.getPassword() + "\n");
                bw.write(dr5.getName() + "\n");
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = (Stage) a_d.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DoctorLogin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void nurseBtn(ActionEvent actionEvent) throws IOException {
        Nurse n1 = new Nurse("Kamal shakeri", 89011186, "kamal86");
        Nurse n2 = new Nurse("Hossein tarvan", 89011187, "hossein87");
        Nurse n3 = new Nurse("Vahid mohammadi", 89011188, "vahid88");
        Nurse n4 = new Nurse("Navid eshghi", 89011189, "navid89");
        Nurse n5 = new Nurse("Parham hasani", 89011190, "parham90");
        try {
            File f1 = new File("NurseInformation.txt");
            if (!f1.exists()) {
                f1.createNewFile();
                FileWriter fileWritter = new FileWriter(f1.getName(), true);
                BufferedWriter bw = new BufferedWriter(fileWritter);

                bw.write(n1.getPersonnelCode() + "\n");
                bw.write(n1.getPassword() + "\n");
                bw.write(n1.getName() + "\n");

                bw.write(n2.getPersonnelCode() + "\n");
                bw.write(n2.getPassword() + "\n");
                bw.write(n2.getName() + "\n");

                bw.write(n3.getPersonnelCode() + "\n");
                bw.write(n3.getPassword() + "\n");
                bw.write(n3.getName() + "\n");

                bw.write(n4.getPersonnelCode() + "\n");
                bw.write(n4.getPassword() + "\n");
                bw.write(n4.getName() + "\n");

                bw.write(n5.getPersonnelCode() + "\n");
                bw.write(n5.getPassword() + "\n");
                bw.write(n5.getName() + "\n");
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = (Stage) a_d.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("NurseLogin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void patientBtn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) a_d.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PatientLogin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
