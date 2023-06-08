package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        final String URL = "jdbc:mysql://localhost:3306/jdbc_test?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String USER = "root";
        final String PASSWORD = "";
        String QUERY = "SELECT * FROM Programming_Languages";

        DbConnectionSettings dbSettings = new DbConnectionSettings(URL, USER, PASSWORD);
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.connectDB(dbSettings);
        IDbQueries dbQueries = new DbQueries();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n###############################################################\n" +
                             "#  Для помощи используйте комманду --help, для выхода --exit  #" +
                           "\n###############################################################\n"
        );

        console_loop:
        while(true) {
            System.out.print("Введите следующую комманду: ");
            String line = scanner.nextLine();
            switch (line) {
                case "getVal":
                    System.out.print("Введите название таблицы: ");
                    line = scanner.nextLine();
                    try {
                        ResultSet resultSet = dbQueries.getAllValuesFrom(connection, line);
                        dbQueries.printAllValues(resultSet);
                    }
                    catch (SQLSyntaxErrorException e) {
                        System.out.println("Запрос некорректный");
                    }
                    continue;
                case "addVal":
                    System.out.print("Введите sql запрос: ");
                    line = scanner.nextLine();
                    try {
                        dbQueries.insertValuesIn(connection, line);
                    }
                    catch (SQLSyntaxErrorException e) {
                        System.out.println("Запрос некорректный");
                    }
                    continue;
                case "updVal":
                    System.out.print("Введите sql запрос: ");
                    line = scanner.nextLine();
                    try {
                        dbQueries.insertValuesIn(connection, line);
                    }
                    catch (SQLSyntaxErrorException e) {
                        System.out.println("Запрос некорректный");
                    }
                    continue;
                case "delVal":
                    System.out.print("Введите название таблицы: ");
                    line = scanner.nextLine();
                    try {
                        dbQueries.deleteValuesIn(connection, line);
                    }
                    catch (SQLSyntaxErrorException e) {
                        System.out.println("Запрос некорректный");
                    }
                    continue;
                case "--exit":
                    break console_loop;
                case "--help":
                    System.out.println("1. getVal - получить значения\n2. addVal - добавить значение\n1. updVal - обновить значения\n1. delVal - удалить значения\n");
                    continue;
                default:
                    System.out.println("Комманда не распознана. Для помощи используйте --help");
                    continue;
            }
        }

        connection.close();
    }
}




























