package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListCustomers implements Initializable {
    ObservableList<Hotel> list= FXCollections.observableArrayList();
    public TableView<Hotel> tableView;
    public TableColumn<Hotel, String> NameColumn;
    public TableColumn<Hotel, String> NumberColumn;
    public TableColumn<Hotel, String> StayColumn;
    public TableColumn<Hotel, String> GuestsColumn;

    public void initialize(URL location, ResourceBundle resources) {
        initCol();

        loadData();
    }

    private void loadData() {
        list.clear();
        MysqlConnector mysqlConnector=new MysqlConnector();
        String qu = "SELECT * FROM CustomerDetails";
        ResultSet rs = mysqlConnector.executeQuery(qu);
        try {
            while (rs.next()) {
                String name = rs.getString("customername");
                String number = rs.getString("customernumber");
                String stay= rs.getString("customerstay");
                String guests = rs.getString("customerguests");

                list.add(new Hotel(name,number,stay,guests));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        tableView.getItems().setAll(list);
    }

    private void initCol(){
        NameColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("Name"));
        NumberColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("Number"));
        StayColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("Stay"));
        GuestsColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("Guests"));

    }

    public static class Hotel {

        private final SimpleStringProperty name;
        private final SimpleStringProperty number;
        private final SimpleStringProperty stay;
        private final SimpleStringProperty guests;


        public Hotel(String customername, String customernumber, String customerstay, String customerguests) {
            this.name = new SimpleStringProperty(customername);
            this.number = new SimpleStringProperty(customernumber);
            this.guests = new SimpleStringProperty(customerstay);
            this.stay = new SimpleStringProperty(customerguests);

        }

        public String getName() {
            return name.get();
        }

        public String getNumber() {
            return number.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public void setNumber(String number) {
            this.number.set(number);
        }

        public void setStay(String stay) {
            this.stay.set(stay);
        }

        public void setGuests(String guests) {
            this.guests.set(guests);
        }

        public String getStay() {
            return stay.get();
        }

        public String getGuests() {
            return guests.get();
        }


    }
}