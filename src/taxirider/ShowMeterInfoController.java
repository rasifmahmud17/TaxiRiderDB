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
public class ShowMeterInfoController implements Initializable {
    @FXML
    private TableView<?> SMITable;
    @FXML
    private TableColumn<?, ?> SMITourIDTc;
    @FXML
    private TableColumn<?, ?> SMIDriverIDTc;
    @FXML
    private TableColumn<?, ?> SMICarRegNoTc;
    @FXML
    private TableColumn<?, ?> SMIGenCodeTc;
    @FXML
    private TableColumn<?, ?> SMITourDistanceTc;
    @FXML
    private TableColumn<?, ?> SMIIdleTimeTc;
    @FXML
    private TableColumn<?, ?> SMIEndTimeTc;
    @FXML
    private TableColumn<?, ?> SMIAmountTc;
    @FXML
    private Button SMIBackButt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SMIBackButtClick(ActionEvent event) {
    }
    
}
