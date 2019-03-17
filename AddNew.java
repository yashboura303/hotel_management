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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;

public class AddNew {
    MysqlConnector mysqlConnector = new MysqlConnector();
    public TextField txtUsername;
    public PasswordField txtPassword;
    public PasswordField txtPassword2;

    public void SaveButton(ActionEvent event) {

        if (txtPassword.getText().equals(txtPassword2.getText())) {
            try {
                String query = "insert into employee(employeename, employeepassword) values('" +  txtUsername.getText() + "','" + txtPassword.getText() + "')";
                System.out.println(query);
                mysqlConnector.stmt = mysqlConnector.conn.createStatement();
                mysqlConnector.stmt.executeUpdate(query);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("SUCCESS");
                alert.setContentText("YOU ARE REGISTERED,NOW LOGIN");
                alert.show();

            } catch (Exception e) {
                e.printStackTrace();

            }


        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("ENTER PASSWORD CORRECTLY");
            alert.show();

        }
    }
}


