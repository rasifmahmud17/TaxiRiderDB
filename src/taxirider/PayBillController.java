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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class PayBillController implements Initializable {
    @FXML
    private Button TPCOMPLETEButt;
    @FXML
    private Label TPTourIdL;
    @FXML
    private Label TPDriverIDL;
    @FXML
    private Label TPCarRegNoL;
    @FXML
    private Label TPGeneratedCodeL;
    @FXML
    private Label TPTourDistanceL;
    @FXML
    private Label TPIdleTimeL;
    @FXML
    private Label TPEndTimeL;
    @FXML
    private Label TPAmountL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void TPCOMPLETEButtClick(ActionEvent event) {
    }
    
}
