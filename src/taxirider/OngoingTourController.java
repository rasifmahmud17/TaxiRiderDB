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
public class OngoingTourController implements Initializable {
    @FXML
    private Button OTIMakePaymentButt;
    @FXML
    private Label OTITourIdL;
    @FXML
    private Label OTIUserIDL;
    @FXML
    private Label OTIDriverIDL;
    @FXML
    private Label OTICarRegNoL;
    @FXML
    private Label OTIStartTimeL;
    @FXML
    private Label OTIFinalDestinationL;
    @FXML
    private Label OTIPickUpPointL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OTIMakePaymentButtClick(ActionEvent event) {
    }
    
}
