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
public class ShowDriverStatusController implements Initializable {
    @FXML
    private TableView<?> SDSTable;
    @FXML
    private TableColumn<?, ?> SDSDriverIDTc;
    @FXML
    private TableColumn<?, ?> SDSCarRegNoTc;
    @FXML
    private TableColumn<?, ?> SDSDriverLocTc;
    @FXML
    private TableColumn<?, ?> SDSDriverStatusTc;
    @FXML
    private TableColumn<?, ?> SDSUserIDTc;
    @FXML
    private TableColumn<?, ?> SDSTourIDTc;
    @FXML
    private Button SDSBackButt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SDSBackButtClick(ActionEvent event) {
    }
    
}
