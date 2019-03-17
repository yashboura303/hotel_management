package sample;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.*;

public class LoginModel {
    int flag=0;

    @Nullable
    @NotNull
    Connection connection;

    public LoginModel() {
        connection = MysqlConnector.Connector();
    }

    public boolean isDBConnected() {
        try {
            boolean b = !connection.isClosed();
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
            boolean c = false;
            return c;


        }

    }

    public boolean isLogin(String user, String pass) throws SQLException {
        PreparedStatement preparedstatement = null;
        ResultSet resultSet = null;
        String query = "select * from employee where employeename=? and employeepassword = ?";
        try {
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, user);
            preparedstatement.setString(2, pass);
            resultSet = preparedstatement.executeQuery();
            if (resultSet.next()) {
                flag=1;
                return true;
            }
            else{
                return false;
            }


        } catch (Exception e) {
            return false;
        } finally {
            preparedstatement.close();
            resultSet.close();
        }
    }
}



