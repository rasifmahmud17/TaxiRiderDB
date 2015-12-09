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
public class ShowMeterInfoController implements Initializable {
    @FXML
    private TableView<MeterInfoDB> SMITable;
    @FXML
    private TableColumn<MeterInfoDB, Integer> SMITourIDTc;
    @FXML
    private TableColumn<MeterInfoDB, String> SMIDriverIDTc;
    @FXML
    private TableColumn<MeterInfoDB, String> SMICarRegNoTc;
    @FXML
    private TableColumn<MeterInfoDB, String> SMIGenCodeTc;
    @FXML
    private TableColumn<MeterInfoDB, Double> SMITourDistanceTc;
    @FXML
    private TableColumn<MeterInfoDB, Double> SMIIdleTimeTc;
    @FXML
    private TableColumn<MeterInfoDB, String> SMIEndTimeTc;
    @FXML
    private TableColumn<MeterInfoDB, Double> SMIAmountTc;
    @FXML
    private Button SMIBackButt;
    
    ObservableList<MeterInfoDB> SMIData =FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DontDelete dontDelete=new DontDelete();
        dontDelete.connectDatabase();
        
        //Showing on table
        SMIAmountTc.setCellValueFactory(new PropertyValueFactory<>("amount"));
        SMICarRegNoTc.setCellValueFactory(new PropertyValueFactory<>("carRegNo"));
        SMIDriverIDTc.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        SMIEndTimeTc.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        SMIGenCodeTc.setCellValueFactory(new PropertyValueFactory<>("generatedCode"));
        SMIIdleTimeTc.setCellValueFactory(new PropertyValueFactory<>("idleTime"));
        SMITourDistanceTc.setCellValueFactory(new PropertyValueFactory<>("tourDistance"));
        SMITourIDTc.setCellValueFactory(new PropertyValueFactory<>("tourID"));
        
        
        SMIData.setAll(dontDelete.getMeterInfo("SELECT * FROM METER_INFO;"));
        ObservableList<MeterInfoDB> row = FXCollections.observableArrayList();
        row = dontDelete.getMeterInfo("SELECT * FROM METER_INFO;");
        TaxiRider.printElements(row);

        
        SMITable.setItems(SMIData);
        
        dontDelete.closeDatabase();
        
    }    

    @FXML
    private void SMIBackButtClick(ActionEvent event) {
    }
    
}
