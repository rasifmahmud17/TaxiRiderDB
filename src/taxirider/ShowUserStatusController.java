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
public class ShowUserStatusController implements Initializable {
    @FXML
    private TableView<?> SUSTable;
    @FXML
    private TableColumn<?, ?> SUSUserIDTc;
    @FXML
    private TableColumn<?, ?> SUSUserLocTc;
    @FXML
    private TableColumn<?, ?> SUSUserStatTc;
    @FXML
    private TableColumn<?, ?> SUSTourIDTc;
    @FXML
    private TableColumn<?, ?> SUSFinalDestinationTc;
    @FXML
    private TableColumn<?, ?> SUSDriverIDTc;
    @FXML
    private TableColumn<?, ?> SUSCarRegNoTc;
    @FXML
    private Button SUSBackButt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SUSBackButtClick(ActionEvent event) {
    }
    
}
