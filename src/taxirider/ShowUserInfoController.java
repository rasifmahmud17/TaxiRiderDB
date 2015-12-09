/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class ShowUserInfoController implements Initializable {
    @FXML
    private TableColumn<?, ?> SUIDriverIDTc;
    @FXML
    private TableColumn<?, ?> SUDINameTc;
    @FXML
    private TableColumn<?, ?> SUIEmailTc;
    @FXML
    private TableColumn<?, ?> SUIMobileNoTc;
    @FXML
    private TableColumn<?, ?> SUILanguageTc;
    @FXML
    private TableColumn<?, ?> SUICreditCardNoTc;
    @FXML
    private TableColumn<?, ?> SUICvvTc;
    @FXML
    private TableColumn<?, ?> SUIExpirationDateTc;
    @FXML
    private TableColumn<?, ?> SUIAddressTc;
    @FXML
    private Button SUIBackButt;
    @FXML
    private TableView<?> SUITable;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    @FXML
    private void SUIBackButtClick(ActionEvent event) {
    }

}
