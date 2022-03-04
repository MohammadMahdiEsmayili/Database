package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Random;

public class FileManager {

    public void writeToFile(String filename, String nationalCode, String fullName, String age, String gender, String disease, String specificDiseases) throws IOException {

        int min = 10000000;
        int max = 99999999;

        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

        String[] arry = {"Hamed azizi", "Ali samadi", "Karim kazemi", "Samad asgari", "behnam mosavat"};
        Random r = new Random();
        int randomNumber = r.nextInt(arry.length);
        String doctor = arry[randomNumber];

        String[] arr = {"Kamal shakeri", "Hossein tarvan", "Vahid mohammadi", "Navid eshghi", "Parham hasani"};
        Random rm = new Random();
        int randomNum = rm.nextInt(arr.length);
        String nurse = arr[randomNum];

        int found = 0;

        try {
            File f = new File(filename);
            if (!f.exists()) {
                f.createNewFile();
            }

            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(new FileReader(filename));


            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals(nationalCode)) {
                    found = 1;
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (found == 0) {
            try {
                File f1 = new File(filename);
                if (!f1.exists()) {
                    f1.createNewFile();
                }

                FileWriter fileWritter = new FileWriter(f1.getName(), true);
                BufferedWriter bw = new BufferedWriter(fileWritter);
                bw.write("information\n");
                bw.write(doctor + "\n");
                bw.write(nurse + "\n");
                bw.write("nationalcode\n");
                bw.write(nationalCode + "\n");
                bw.write(random_int + "\n");
                bw.write("name\n");
                bw.write(fullName + "\n");
                bw.write(age + "\n");
                bw.write(gender + "\n");
                bw.write(disease + "\n");
                bw.write(specificDiseases + "\n");

                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AccountingError.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }
}
