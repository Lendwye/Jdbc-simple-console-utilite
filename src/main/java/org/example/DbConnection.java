package org.example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connectDB(DbConnectionSettings dbSettings) throws Exception {
        Connection connection = null;
        Driver driver;

        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e1) {
            System.out.println("Драйвер не зарегистрировался");
            throw new Exception();
        }

        try {
            connection = DriverManager.getConnection(dbSettings.getDB_URL(), dbSettings.getDB_USER(), dbSettings.getDB_PASSWORD());
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
            return connection;
        } catch (SQLException ex){
            System.err.println("Соединение не установлено");
            ex.printStackTrace();
            throw new Exception();
        }
    }
}
