/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LSignUpButtClick(ActionEvent event) {
    }

    @FXML
    private void LSignInButtClick(ActionEvent event) {
    }
    
}