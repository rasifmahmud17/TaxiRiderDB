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
public class ShowDriverInfoController implements Initializable {
    @FXML
    private TableView<?> SDITable;
    @FXML
    private TableColumn<?, ?> SDIDriverIDTc;
    @FXML
    private TableColumn<?, ?> SDINameTc;
    @FXML
    private TableColumn<?, ?> SDIEmailTc;
    @FXML
    private TableColumn<?, ?> SDIMobileNoTc;
    @FXML
    private TableColumn<?, ?> SDILanguageTc;
    @FXML
    private TableColumn<?, ?> SDICreditCardNoTc;
    @FXML
    private TableColumn<?, ?> SDICvvTc;
    @FXML
    private TableColumn<?, ?> SDIExpirationDateTc;
    @FXML
    private TableColumn<?, ?> SDIAddressTc;
    @FXML
    private TableColumn<?, ?> SDIDrivingLicenseTc;
    @FXML
    private TableColumn<?, ?> SDICarRegNoTc;
    @FXML
    private TableColumn<?, ?> SDICarModelTc;
    @FXML
    private Button SDIBackButt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SDIBackButtClick(ActionEvent event) {
    }
    
}
