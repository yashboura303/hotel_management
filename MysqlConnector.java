package sample;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import javafx.fxml.FXML;

import java.sql.*;


public class MysqlConnector {
    @FXML
    public  Statement stmt;
    @FXML
    public  Connection conn;


    public MysqlConnector() {
        conn = Connector();
        String TableName = "CustomerDetails";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TableName.toUpperCase(), null);
            if (tables.next()) {
                System.out.println("Ready to go");

            } else {
                stmt.execute("CREATE TABLE " + TableName + "("
                        + " customername varchar(45) primary key,"
                        + " customernumber varchar(45),\n"
                        + "  customerstay varchar(45),\n"
                        + "  customerguests varchar(45)"
                        + ")");
            }
        } catch (SQLException e1) {
            System.err.println(e1.getMessage());
        }
    }


    @Nullable
    @NotNull
    public static Connection Connector() {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "password");
            return conn;
        } catch (Exception e) {
            return null;
        }

    }

    @NotNull
    @Nullable
    public ResultSet executeQuery(String query) {

        ResultSet result;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);


        } catch (SQLException e) {
            System.out.println("Error here");
            e.printStackTrace();
            return null;

        }
        return result;
    }

    @NotNull
    @Nullable
    public boolean executeAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}











