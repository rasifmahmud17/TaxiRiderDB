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
public class ShowDriverStatusController implements Initializable {
    @FXML
    private TableView<DriverStatusDB> SDSTable;
    @FXML
    private TableColumn<DriverStatusDB, String> SDSDriverIDTc;
    @FXML
    private TableColumn<DriverStatusDB, String> SDSCarRegNoTc;
    @FXML
    private TableColumn<DriverStatusDB, String> SDSDriverLocTc;
    @FXML
    private TableColumn<DriverStatusDB, String> SDSDriverStatusTc;
    @FXML
    private TableColumn<DriverStatusDB, String> SDSUserIDTc;
    @FXML
    private TableColumn<DriverStatusDB, Integer> SDSTourIDTc;
    @FXML
    private Button SDSBackButt;
    
    ObservableList<DriverStatusDB> SDSData =FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DontDelete dontDelete=new DontDelete();
        dontDelete.connectDatabase();
        
        //Showing on table
        SDSCarRegNoTc.setCellValueFactory(new PropertyValueFactory<>("carRegNo"));
        SDSDriverIDTc.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        SDSDriverLocTc.setCellValueFactory(new PropertyValueFactory<>("driverLocation"));
        SDSDriverStatusTc.setCellValueFactory(new PropertyValueFactory<>("driverStatus"));
        SDSTourIDTc.setCellValueFactory(new PropertyValueFactory<>("tourID"));
        SDSUserIDTc.setCellValueFactory(new PropertyValueFactory<>("userID"));
        
        
        
        SDSData.setAll(dontDelete.getDriverStatus("SELECT * FROM DRIVER_STATUS;"));
        

        
        SDSTable.setItems(SDSData);
        
        dontDelete.closeDatabase();
    }    

    @FXML
    private void SDSBackButtClick(ActionEvent event) {
    }
    
}
