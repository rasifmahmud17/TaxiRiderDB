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
    private TableView<TourPaymentDB> STPTable;
    
    ObservableList<TourPaymentDB> STPData =FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DontDelete dontDelete=new DontDelete();
        dontDelete.connectDatabase();
        
        //Showing on table
        STPAmountTc.setCellValueFactory(new PropertyValueFactory<>("amount"));
        STPGenCodeTc.setCellValueFactory(new PropertyValueFactory<>("generatedCode"));
        STPPaymentTypeTc.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        STPTourIDTc.setCellValueFactory(new PropertyValueFactory<>("tourID"));
        STPUserIDTc.setCellValueFactory(new PropertyValueFactory<>("userID"));
        
        
        
        STPData.setAll(dontDelete.getTourPayment("SELECT * FROM TOUR_PAYMENT;"));
        

        
        STPTable.setItems(STPData);
        
        dontDelete.closeDatabase();
    }    

    @FXML
    private void STPBackButtClick(ActionEvent event) {
    }
    
}
