package com.xworkz.libapp.tester.dao;

import java.sql.*;

public class PreparedStatementImpl implements PreparedStatementDao{

    @Override
    public int save(String thing_name, String brand, String color) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String url = "jdbc:mysql://localhost:3306/library_management";
        String userName = "root";
        String password = "Keerthi8088169847";
        try {
            connection= DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement("insert into things values(?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, thing_name);
            preparedStatement.setString(3, brand);
            preparedStatement.setString(4, color);
            int row = preparedStatement.executeUpdate();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            if (connection != null) {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
