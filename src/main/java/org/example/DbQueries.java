package org.example;

import java.sql.*;
import java.util.HashMap;

public class DbQueries implements IDbQueries{
    @Override
    public ResultSet getAllValuesFrom(Connection connection, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }

    @Override
    public void insertValuesIn(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("Значение добавлено в базу данных");
    }

    @Override
    public void updateValuesIn(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("Значения успешно обновленны");
    }

    @Override
    public void deleteValuesIn(Connection connection, String table) throws SQLException {
        String query = "DELETE " + table;
        Statement statement = connection.createStatement();
        System.out.println("Значения успешно удалены");
    }

    @Override
    public void printAllValues(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            System.out.println(resultSet.getString(1) + ". " + resultSet.getString(2) + " - \"" + resultSet.getString(3) + "\"");
        }
    }
}
