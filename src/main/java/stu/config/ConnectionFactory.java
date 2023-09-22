package stu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnectionFactory {
    private  static Connection con = null;

    public static Connection getDBConnection() throws SQLException {
        if(con == null){

            ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");
            String url = bundle.getString("jdbc.url");
            String user = bundle.getString("jdbc.username");
            String  psw = bundle.getString("jdbc.password");

            con = DriverManager.getConnection(url, user,psw);
        }
        return con;
    }


}
