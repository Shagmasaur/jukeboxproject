package main.coding.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Connection connection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jukeboxdb";
        String user="root";
        String pass="abhishek";
        connection= DriverManager.getConnection(url, user, pass);
        return connection;

    }

}
