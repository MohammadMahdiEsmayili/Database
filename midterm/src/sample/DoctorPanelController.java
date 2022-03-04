package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoctorPanelController {
    public ListView national_code_list;
    public ListView name_list;
    public TextField patient_national_code_tf;

    int length = 0;
    ArrayList<String> listNationalCode = new ArrayList<>();

    public void setNational_code_list(List<String> list , int length){
        this.length = length;
        for (int i = 0; i <= length; i++){
            national_code_list.getItems().add(list.get(i));
            listNationalCode.add(list.get(i));
        }
    }
    public void setName_list(List<String> list , int length){
        for (int i = 0; i <= length; i++)
            name_list.getItems().add(list.get(i));
    }

    public void onClickBackBtn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) name_list.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DoctorLogin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onClickOkBtn(ActionEvent actionEvent) throws IOException {
        int found = 0;
        for (int i = 0; i <= length; i++)
            if (patient_national_code_tf.getText().equals(listNationalCode.get(i)))
            {
                found = 1;
                Stage primaryStage = (Stage) name_list.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorOpinion.fxml"));
                Parent root = loader.load();
                DoctorOpinionController controller = loader.getController();
                controller.setNationalCode(patient_national_code_tf.getText());
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
        if (found == 0){
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }
}
