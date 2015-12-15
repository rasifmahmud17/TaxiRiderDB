/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class LoginController implements Initializable {

    @FXML
    private Button LSignUpButt;
    @FXML
    private Button LSignInButt;
    @FXML
    private RadioButton UserRB;
    @FXML
    private ToggleGroup UserDriverTg;
    @FXML
    private RadioButton DriverRB;

    public static String partytype = null;
    public static String errorMsg = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (UserRB.isSelected()) {
            LoginController.partytype = "user";
        } else {
            LoginController.partytype = "driver";
        }
    }

    @FXML
    private void LSignUpButtClick(ActionEvent event) {

    }

    @FXML
    private void LSignInButtClick(ActionEvent event) throws IOException {
        if (UserRB.isSelected() == true || DriverRB.isSelected() == true) {
            if (UserRB.isSelected()) {
                LoginController.partytype = "user";
            } else {
                LoginController.partytype = "driver";
            }
            Parent p = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            Stage Banks = new Stage();
            Scene scene = new Scene(p);
            Banks.initModality(Modality.WINDOW_MODAL);
            Banks.initOwner(
                    ((Node) event.getSource()).getScene().getWindow());
            Banks.setScene(scene);
            Banks.showAndWait();
        } else {

            LoginController.errorMsg = "LOGIN TYPE UNDEFIND!!";
            Parent p = FXMLLoader.load(getClass().getResource("Error.fxml"));
            Stage Banks = new Stage();
            Scene scene = new Scene(p);
            Banks.initModality(Modality.WINDOW_MODAL);
            Banks.initOwner(
                    ((Node) event.getSource()).getScene().getWindow());
            Banks.setScene(scene);
            Banks.showAndWait();
        }

    }

}
