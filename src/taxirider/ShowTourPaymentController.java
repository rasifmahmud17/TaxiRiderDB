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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class ShowTourPaymentController implements Initializable {
    @FXML
    private TableColumn<TourPaymentDB, String> STPTourIDTc;
    @FXML
    private TableColumn<TourPaymentDB, String> STPUserIDTc;
    @FXML
    private TableColumn<TourPaymentDB, String> STPGenCodeTc;
    @FXML
    private TableColumn<TourPaymentDB, String> STPPaymentTypeTc;
    @FXML
    private TableColumn<TourPaymentDB, Double> STPAmountTc;
    @FXML
    private Button STPBackButt;
    @FXML
    private TableView<TourPaymentDB> SDSTable;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void STPBackButtClick(ActionEvent event) {
    }
    
}
