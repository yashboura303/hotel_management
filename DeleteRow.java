package sample;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import javafx.event.ActionEvent;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class DeleteRow {
    public Button buttonDelete;
    public TextField txtDelete;
    MysqlConnector mysqlConnector = new MysqlConnector();



    public void DeleteButton(ActionEvent event) {
        String qu= "DELETE FROM customerdetails WHERE  customername ="+ "'" + txtDelete.getText()+"'"+"";
        System.out.println(qu);
        try {
            mysqlConnector.stmt = mysqlConnector.conn.createStatement();
            mysqlConnector.stmt.executeUpdate(qu);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("DELETED SUCCESSFULLY");
            alert.show();
        }
        catch (Exception e )
        {e.printStackTrace();}
    }
}