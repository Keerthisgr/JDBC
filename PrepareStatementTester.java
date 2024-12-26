package com.xworkz.libapp.tester;

import java.sql.*;

public class PrepareStatementTester {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/library_management";
            String userName = "root";
            String password = "Keerthi8088169847";
            connection = DriverManager.getConnection(url, userName, password);
            String query = "insert into things values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,"Smartphone");
            preparedStatement.setString(3,"Realme");
            preparedStatement.setString(4,"Black");
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows+ " rows inserted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

