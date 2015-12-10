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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class MakeATourController implements Initializable {
    @FXML
    private Button MATGoButt;
    @FXML
    private TextField MATCurLocTf;
    @FXML
    private TextField MATFinalDestTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void MATGoButtClick(ActionEvent event) {
    }
    
}
