package sample;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.*;
public class Controller  implements Initializable {
    @NotNull
    @Nullable
    public LoginModel loginModel = new LoginModel();
    @FXML

    private Label db;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtpassword;



    @FXML
    Button abutton = new Button("Login");

    private AddCustomer  addCustomer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        if (loginModel.isDBConnected()) {
            db.setText("Connected to SERVER");
        } else {
            db.setText("Not Connected");
        }
        db.setTextFill(Color.LIGHTSALMON);
        db.setUnderline(true);
    }

    public void Login (ActionEvent event ) {
        try {
            if (loginModel.isLogin(txtUsername.getText(), txtpassword.getText())) {

                try {
                    FXMLLoader addCustomer= new FXMLLoader(getClass().getResource("/sample/addcustomer.fxml"));
                    Parent root1 = (Parent)addCustomer.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.setTitle("ENTRY RECORD");
                    stage.show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            } else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("YOU ARE NOT AUTHENTICATED");
                alert.show();


            }
        } catch (SQLException e) {


            e.printStackTrace();
        }
    }

    public void registerUser (ActionEvent event ) {
        try {
            FXMLLoader addCustomer = new FXMLLoader(getClass().getResource("/sample/addNew.fxml"));
            Parent root1 = (Parent) addCustomer.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("REGISTER");
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}






