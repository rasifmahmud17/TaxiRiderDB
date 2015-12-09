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
public class ShowTourInfoController implements Initializable {
    @FXML
    private TableColumn<TourInfoDB, Integer> STITourIDTc;
    @FXML
    private TableColumn<TourInfoDB, String> STIUserIDTc;
    private TableColumn<TourInfoDB, String> STIDriverIDTc;
    private TableColumn<TourInfoDB, String> STICarRegNoTc;
    private TableColumn<TourInfoDB, String> STIStartTimeTc;
    private TableColumn<TourInfoDB, String> STIPickupPointTc;
    private TableColumn<TourInfoDB, String> STIFinalDestinationTc;
    @FXML
    private TableView<TourInfoDB> STITable;
    
    ObservableList<TourInfoDB> STIData =FXCollections.observableArrayList();
    @FXML
    private Button STIBackButt;
    @FXML
    private TableColumn<?, ?> STIGenCodeTc;
    @FXML
    private TableColumn<?, ?> STIPaymentTypeTc;
    @FXML
    private TableColumn<?, ?> STIAmountTc;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DontDelete dontDelete=new DontDelete();
        dontDelete.connectDatabase();
        
        //Showing on table
        STICarRegNoTc.setCellValueFactory(new PropertyValueFactory<>("carRegNo"));
        STIDriverIDTc.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        STIFinalDestinationTc.setCellValueFactory(new PropertyValueFactory<>("finalDestination"));
        STIPickupPointTc.setCellValueFactory(new PropertyValueFactory<>("pickUpPoint"));
        STIStartTimeTc.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        STITourIDTc.setCellValueFactory(new PropertyValueFactory<>("tourID"));
        STIUserIDTc.setCellValueFactory(new PropertyValueFactory<>("userID"));
        
        
        
        STIData.setAll(dontDelete.getTourInfo("SELECT * FROM TOUR_INFO;"));
        

        
        STITable.setItems(STIData);
        
        dontDelete.closeDatabase();
    }    

    @FXML
    private void STIBackButtClick(ActionEvent event) {
    }
    
}
