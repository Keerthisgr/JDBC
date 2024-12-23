package com.xworkz.libraryapp.tester;
import java.sql.*;
public class Book {
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
            String insert = "insert into book_info values(0,'Atomic Habits','James clear')";
            String insert1 = "insert into book_info values(0,'Death','Sadhguru')";
            String insert2 = "insert into book_info (book_name,author_name) values ('Here and there','Sudhamurthy')";
            String insert3 = "insert into book_info values(0,'Think like a monk','James')";
            String insert4 = "insert into book_info (book_name,author_name) values ('Health','Swamy')";
            String insert5 = "insert into book_info values(0,'Ikigai','Japanese')";
            String insert6 = "insert into book_info values(0,'Alchemist','Paulo Coelho')";
            String insert7 = "insert into book_info (book_name,author_name) values ('Eat those frogs','John')";
            String insert8 = "insert into book_info values(0,'Hyper focus','Cherish')";
            String insert9 = "insert into book_info (book_name,author_name) values ('How to talk','Sudharshan')";
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(insert);
            row = statement.executeUpdate(insert1);
            row = statement.executeUpdate(insert2);
            row = statement.executeUpdate(insert3);
            row = statement.executeUpdate(insert4);
            row = statement.executeUpdate(insert5);
            row = statement.executeUpdate(insert6);
            row = statement.executeUpdate(insert7);
            row = statement.executeUpdate(insert8);
            row = statement.executeUpdate(insert9);

            System.out.println(row + " row inserted");
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
