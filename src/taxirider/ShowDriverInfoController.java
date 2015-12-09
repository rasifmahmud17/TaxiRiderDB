/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class ShowDriverInfoController implements Initializable {
    @FXML
    private TableView<DriverInfoDB> SDITable;
    @FXML
    private TableColumn<DriverInfoDB, String> SDIDriverIDTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDINameTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDIEmailTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDIMobileNoTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDILanguageTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDICreditCardNoTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDICvvTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDIExpirationDateTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDIAddressTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDIDrivingLicenseTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDICarRegNoTc;
    @FXML
    private TableColumn<DriverInfoDB, String> SDICarModelTc;
    @FXML
    private Button SDIBackButt;
    
    ObservableList<DriverInfoDB> SDIData =FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DontDelete dontDelete=new DontDelete();
        dontDelete.connectDatabase();
        
        //Showing on table
        SDIAddressTc.setCellValueFactory(new PropertyValueFactory<>("address"));
        SDICarModelTc.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        SDICarRegNoTc.setCellValueFactory(new PropertyValueFactory<>("carRegNo"));
        SDICreditCardNoTc.setCellValueFactory(new PropertyValueFactory<>("creditCardNo"));
        SDIDriverIDTc.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        SDIDrivingLicenseTc.setCellValueFactory(new PropertyValueFactory<>("drivingLicense"));
        SDIExpirationDateTc.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        SDILanguageTc.setCellValueFactory(new PropertyValueFactory<>("language"));
        SDIMobileNoTc.setCellValueFactory(new PropertyValueFactory<>("mobileNo"));
        SDINameTc.setCellValueFactory(new PropertyValueFactory<>("name"));
        SDICvvTc.setCellValueFactory(new PropertyValueFactory<>("cvv"));
        SDIEmailTc.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        
        SDIData.setAll(dontDelete.getDriverInfo("SELECT * FROM DRIVER_INFO;"));
        

        
        SDITable.setItems(SDIData);
        
        dontDelete.closeDatabase();
    }    

    @FXML
    private void SDIBackButtClick(ActionEvent event) {
    }
    
}
