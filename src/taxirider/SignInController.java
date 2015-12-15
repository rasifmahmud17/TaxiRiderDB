package taxirider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author shadman264
 */
public class SignInController implements Initializable {

    @FXML
    private TextField SIID;
    @FXML
    private Button SISignInButt;
    @FXML
    private TextField SIPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SISignInButtClick(ActionEvent event) throws IOException {
        if (SIID.getText() != null && SIPassword.getText() != null && !"".equals(SIID.getText()) && !"".equals(SIPassword.getText())) {

            DontDelete dontDelete = new DontDelete();

            dontDelete.connectDatabase();

            ///CHECK IF THIS IS A VALID USER
            if (LoginController.partytype.equals("user")) {
                ///CHECK IF THIS IS A VALID USER
            }
            else{
                ///CHECK IF THIS IS A VALID DRIVER
            }
            
            Stage stage = (Stage) SISignInButt.getScene().getWindow();
            Parent p = FXMLLoader.load(getClass().getResource("Successful.fxml"));
            FadeTransition f = new FadeTransition(Duration.millis(1700), p);
            f.setFromValue(0.0);
            f.setToValue(1.0);
            f.play();
            Scene scene = new Scene(p);

            stage.setScene(scene);
            stage.setX(480);
            stage.setY(250);
            stage.setResizable(false);
            stage.show();
            
            dontDelete.closeDatabase();
        }
        else{
            LoginController.errorMsg = "EMPTY FIELD(S)!!";
            Parent p = FXMLLoader.load(getClass().getResource("Error.fxml"));
            Stage Banks = new Stage();
            Scene scene = new Scene(p);
            Banks.initModality(Modality.WINDOW_MODAL);
            Banks.initOwner(
                    ((Node) event.getSource()).getScene().getWindow());
            Banks.setScene(scene);
            Banks.showAndWait();
        }

    }

}
