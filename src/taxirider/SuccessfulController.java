/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class SuccessfulController implements Initializable {

    @FXML
    private Button SOkButt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SOkButtClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) SOkButt.getScene().getWindow();
        if (LoginController.partytype.equals("user")) {
            Parent p = FXMLLoader.load(getClass().getResource("UserHomePage.fxml"));
            Scene scene = new Scene(p);

            stage.setScene(scene);
            stage.show();
        }

    }

}
