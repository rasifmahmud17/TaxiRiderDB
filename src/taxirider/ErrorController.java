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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class ErrorController implements Initializable {
    @FXML
    private Button EOkButt;
    @FXML
    private Label EErrorMessageL;
    

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EErrorMessageL.setText(LoginController.errorMsg);
        
    }  

    
    @FXML
    private void ErrorOkButtClick(ActionEvent event) {
        Stage stage=(Stage) EOkButt.getScene().getWindow();
        stage.close();
    }
    
}
