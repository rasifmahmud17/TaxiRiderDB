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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class ShowUserInfoController implements Initializable {

    @FXML
    private Label SUIUserIdLabel;
    @FXML
    private Label SUINameLabel;
    @FXML
    private Label SUIPasswordLabel;
    @FXML
    private Label SUIMobileNoLabel;
    @FXML
    private Label SUICreditCardNoLabel;
    @FXML
    private Label SUIExpirationDateLabel;
    @FXML
    private Label SUILanguageLabel;
    @FXML
    private Label SUIAddressLabel;
    @FXML
    private Label SUIEmailLabel;
    @FXML
    private Label SUICvvLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DontDelete dontDelete = new DontDelete();
        dontDelete.connectDatabase();

        ObservableList<UserInfoDB> row = FXCollections.observableArrayList();
        row = dontDelete.getUserInfo("SELECT * FROM USER_INFO WHERE USER_ID='"+ UserInfoEntryController.str +"';");
        for (UserInfoDB o : row) {
              SUIAddressLabel.setText(o.getPostalCode());
              SUICreditCardNoLabel.setText(o.getCreditCardNo());
              SUICvvLabel.setText(o.getCvv());
              SUIEmailLabel.setText(o.getEmail());
              Date date = new Date (o.getExpirationDate().getTime());
              String dateOnly =new  SimpleDateFormat("yyyy-MM-dd").format(date);;
              SUIExpirationDateLabel.setText(dateOnly);
              SUILanguageLabel.setText(o.getLanguage());
              SUIMobileNoLabel.setText(o.getMobileNo());
              SUINameLabel.setText(o.getName());
              SUIPasswordLabel.setText(o.getPassword());
              SUIUserIdLabel.setText(o.getUserID());
        }

        dontDelete.closeDatabase();

    }

}
