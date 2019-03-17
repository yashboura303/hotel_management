package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateRow {
    public TextField txtUpdate;
    public Button buttonUpdate;
    public TextField txtName;
    MysqlConnector mysqlConnector = new MysqlConnector();

    public void UpdateButton(ActionEvent actionEvent) {
        String qu= "UPDATE customerdetails SET customerstay =" + "'" + txtUpdate.getText() + "'"
                + "WHERE customername  = " + "'"
                + txtName.getText() + "'";
        System.out.println(qu);
        try {
            mysqlConnector.stmt = mysqlConnector.conn.createStatement();
            mysqlConnector.stmt.executeUpdate(qu);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("UPDATE SUCCESSFULLY");
            alert.show();
        }
        catch (Exception e )
        {e.printStackTrace();}
    }
    }

