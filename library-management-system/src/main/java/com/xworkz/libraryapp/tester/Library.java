package com.xworkz.libraryapp.tester;
import java.sql.*;

public class Library {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Found");
            String url = "jdbc:mysql://localhost:3306/institute";
            String userName = "root";
            String password = "Keerthi8088169847";
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Establish the connection");
            String insert = "insert into institute_info values(1,'JNNCE','Shivamogga')";
            String insert1 = "insert into institute_info values(2,'GHS','Sagar')";
            String insert2 = "insert into institute_info (institute_id,institute_name,city) values (3,'PES','Shivamogga')";
            String insert3 = "insert into institute_info values(4,'JnanaDeepa','Shivamogga')";
            String insert4 = "insert into institute_info (institute_id,institute_name,city) values (5,'Hongeerana','Sagar')";
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(insert);
            row = statement.executeUpdate(insert1);
            row = statement.executeUpdate(insert2);
            row = statement.executeUpdate(insert3);
            row = statement.executeUpdate(insert4);
            System.out.println(row+" row inserted");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
