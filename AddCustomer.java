package sample;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.SUCCESSFUL;

public   class AddCustomer {
    @FXML
    public TextField number;
    @FXML
    public TextField name;
    @FXML
    public TextField stay;
    @FXML
    public TextField noofguests;
    @FXML
    public Button savebutton;
    @FXML
    public Button cancelbutton;
    @FXML
    @NotNull
    @Nullable
    public  void addcustomer(ActionEvent actionEvent) throws Exception {


            String customername = name.getText();
            String customernumber = number.getText();
            String customerstay = stay.getText();
            String customerguests = noofguests.getText();
            if (customername.isEmpty() || customerguests.isEmpty() || customernumber.isEmpty() || customerstay.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("PLEASE ENTER ALL THE FIELDS");
                alert.show();
                return;

            }

            String qu = "INSERT INTO CustomerDetails VALUES(" + "'" + customername + "'," +
                    "'" + customernumber + "'," +
                    "'" + customerstay + "'," +
                    "'" + customerguests + "'" + ")";
            System.out.println(qu);

        @NotNull
        @Nullable
        MysqlConnector mysqlConnector=new MysqlConnector();
        try {

            if (mysqlConnector.executeAction(qu)) {
                @NotNull
                @Nullable
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("ADDED TO RECORD");
                alert.show();
            } else {
                @NotNull
                @Nullable
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("FAILED");
                alert.show();
            }
        }
        catch(Exception e)
        { e.printStackTrace();}

    }
    public void displaydata(ActionEvent actionEvent) {
        try {
            FXMLLoader addCustomer= new FXMLLoader(getClass().getResource("/sample/List View.fxml"));
            Parent root1 = (Parent)addCustomer.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("DISPLAY RECORD");
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteButton(ActionEvent actionEvent) {
        try {
            FXMLLoader addCustomer= new FXMLLoader(getClass().getResource("/sample/deleterow.fxml"));
            Parent root1 = (Parent)addCustomer.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("DELETE RECORD");
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateButton(ActionEvent actionEvent) {
        try {
            FXMLLoader addCustomer= new FXMLLoader(getClass().getResource("/sample/updaterow.fxml"));
            Parent root1 = (Parent)addCustomer.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("UPDATE RECORD");
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
