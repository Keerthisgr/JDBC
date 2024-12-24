package com.xworkz.libraryapp.tester;
import java.sql.*;

public class AuthorTester {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Found");
            String url = "jdbc:mysql://localhost:3306/institute";
            String userName = "root";
            String password = "Keerthi8088169847";
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Establish the connection");

            String insert1 = "insert into author_info values(0,'James clear',4)";
            String insert2 = "insert into author_info values(0,'Sadhguru',5)";
            String insert3 = "insert into author_info values(0,'Sudhamurthy',8)";
            String insert4 = "insert into author_info values(0,'Kuvempu',24)";
            String insert5 = "insert into author_info values(0,'Girish',5)";
            String insert6 = "insert into author_info values(0,'Rajani',1)";

            Statement statement = connection.createStatement();

            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);
            statement.addBatch(insert6);
            int[] row = statement.executeBatch();
            System.out.println("one row inserted "+row.length);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

    }

}
