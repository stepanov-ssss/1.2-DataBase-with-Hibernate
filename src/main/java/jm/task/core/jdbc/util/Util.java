package jm.task.core.jdbc.util;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "4848imirpes";
    public static Connection getConnection()  {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
//            System.out.println("Connection established");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
