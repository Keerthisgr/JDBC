package com.xworkz.libraryapp.retriver;
import java.sql.*;
public class Library {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Found");
            String url = "jdbc:mysql://localhost:3306/institute";
            String userName = "root";
            String password = "Keerthi8088169847";
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Establish the connection");

            statement = connection.createStatement();
            String query = "select * from institute_info";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int institute_id = resultSet.getInt(1);
                String institute_name = resultSet.getString(2);
                String city = resultSet.getString(3);

                System.out.println("Institute Id: "+institute_id+" Institute Name: "+institute_name+"  City Name: "+city);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("JDBC Driver not found " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
