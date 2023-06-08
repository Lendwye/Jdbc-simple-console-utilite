package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public interface IDbQueries {
    public ResultSet getAllValuesFrom(Connection connection, String tableName) throws SQLException;
    public void insertValuesIn(Connection connection, String query) throws SQLException;
    public void updateValuesIn(Connection connection, String query) throws SQLException;
    public void deleteValuesIn(Connection connection, String table) throws SQLException;
    public void printAllValues(ResultSet resultSet) throws SQLException;
}
