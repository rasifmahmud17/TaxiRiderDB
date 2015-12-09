/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.sql.Timestamp;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author razon
 */
public class TaxiRider extends Application {

    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserInfoEntry.fxml"));

        Scene scene = new Scene(root);
        //stage.setResizable(false);
        //stage.setFullScreen(true);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        UserInfoDB userInfoDB = new UserInfoDB("shadman266", "shadman266@gmail.com", "Shadman Mahdi", "123456", "01711038706", "Bangla", "123456789", "123456789", date, "1219");
        DontDelete dontDelete = new DontDelete();
        dontDelete.connectDatabase();

        dontDelete.createUserInfo();
        dontDelete.createDriverInfo();
        dontDelete.createTourInfo();
        dontDelete.createUserStatus();
        ObservableList<UserInfoDB> row = FXCollections.observableArrayList();
        row = dontDelete.getUserInfo("SELECT * FROM USER_INFO;");
        printElements(row);

        dontDelete.closeDatabase();
        launch(args);
    }

    private static void printElements(ObservableList<UserInfoDB> list) {
        System.out.println("Size: " + list.size());
        for (UserInfoDB o : list) {
            System.out.print(o.getName());
            System.out.print(" " + o.getPassword());
            System.out.println(" " + o.getPostalCode());
        }
        System.out.println("");
    }

}
