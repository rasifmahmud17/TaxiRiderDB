/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxirider;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import taxirider.DontDelete;
import taxirider.UserInfoDB;

/**
 * FXML Controller class
 *
 * @author razon
 */
public class UserInfoEntryController implements Initializable {
    @FXML
    private TextField UIEUserIDTf;
    @FXML
    private TextField UIENameTf;
    @FXML
    private PasswordField UIEPasswordTf;
    @FXML
    private PasswordField UIERetypePasswordTf;
    @FXML
    private TextField UIECreditCardNoTf;
    @FXML
    private DatePicker UIEExpirationDate;
    @FXML
    private TextField UIELanguageTf;
    @FXML
    private TextArea UIEAddressTextArea;
    @FXML
    private TextField UIEEmailTf;
    @FXML
    private TextField UIEMobileNoTf;
    @FXML
    private TextField UIECvvTf;
    @FXML
    private Button UIESignUpButt;

    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void UIESignUpButtClick(ActionEvent event) throws IOException {
        UserInfoDB userInfoDB = new UserInfoDB();

        userInfoDB.setCreditCardNo(UIECreditCardNoTextField.getText());
        userInfoDB.setCvv(UIECvvTextField.getText());
        userInfoDB.setEmail(UIEEmailTextField.getText());

        LocalDate dd = UIEExpirationDate.getValue();
        Date expirationDate = java.sql.Date.valueOf(dd);

        dd = UIEExpirationDate.getValue();
        Date todate = java.sql.Date.valueOf(dd);

        userInfoDB.setExpirationDate(Timestamp.valueOf(UIEExpirationDate.getValue().atStartOfDay()));
        userInfoDB.setLanguage(UIELanguageTextField.getText());
        userInfoDB.setMobileNo(UIEMobileNoTextField.getText());
        userInfoDB.setName(UIENameTextField.getText());
        userInfoDB.setPassword(UIEPassword.getText());
        userInfoDB.setPostalCode(UIEAddressTextArea.getText());
        userInfoDB.setUserID(UIEUserIDTextField.getText());

        DontDelete dontDelete = new DontDelete();

        dontDelete.connectDatabase();
        dontDelete.insertUserInfo(userInfoDB);

        str= userInfoDB.getUserID();
        
        
        UserStatusDB userStatusDB = new UserStatusDB(str, UIEAddressTextArea.getText(), "chill");
        dontDelete.insertUserStatus(userStatusDB);


        dontDelete.closeDatabase();
        str= userInfoDB.getUserID();

        Stage stage = (Stage) UIESignUpButt.getScene().getWindow();

        Parent p = FXMLLoader.load(getClass().getResource("ShowUserInfo.fxml"));
        FadeTransition f = new FadeTransition(Duration.millis(1700), p);
        f.setFromValue(0.0);
        f.setToValue(1.0);
        f.play();
        Scene scene = new Scene(p);

        stage.setScene(scene);
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }

}
