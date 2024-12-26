package com.xworkz.libapp.tester;

import java.sql.*;

public class LibraryRunner {
    public static void main(String[] args) {
        Connection connection = null;
        try{
            String url = "jdbc:mysql://localhost:3306/library_management";
            String userName = "root";
            String password = "Keerthi8088169847";
            connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement();
            String insert = "insert into library_details values(0,'Tunga','Government','Shivamogga',8900,'Academic')";
            String insert1 = "insert into library_details values(0,'Bhadra','Private','Bhadravathi',9000,'Academic')";
            String insert2 = "insert into library_details values(0,'Sharavathi','Government','Sagara',18000,'Academic')";
            String insert3 = "insert into library_details values(0,'Netravathi','Private','Mangalore',20000,'Academic')";
            String insert4 = "insert into library_details values(0,'Kaali','Government','Mysore',35000,'Academic')";
            String insert5 = "insert into library_details values(0,'Varadha','Private','Shivamogga',18900,'Academic')";
            String insert6 = "insert into library_details values(0,'Krishna','Government','Sagara',6500,'Academic')";

            statement.addBatch(insert);
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);
            statement.addBatch(insert6);
//            statement.executeBatch();




            String query1 = "select count(*) from library_details where location = 'Shivamogga'";
            ResultSet resultSet1 = statement.executeQuery(query1);
            resultSet1.next();
            System.out.println(resultSet1.getInt(1));

            String query2 = "select count(*) from library_details where no_of_books < 20000";
            ResultSet resultSet2 = statement.executeQuery(query2);
            resultSet2.next();
            System.out.println(resultSet2.getInt(1));
            System.out.println("Minimum");
            String query3 = "SELECT MIN(no_of_books) FROM library_details WHERE no_of_books < 10000";
            ResultSet resultSet3 = statement.executeQuery(query3);
            resultSet3.next();
            System.out.println(resultSet3.getInt(1));
            System.out.println("Maximum");
            String query4 = "SELECT MAX(no_of_books) FROM library_details WHERE no_of_books < 20000";
            ResultSet resultSet4 = statement.executeQuery(query4);
            resultSet4.next();
            System.out.println(resultSet4.getInt(1));

            System.out.println("Average");
            String query5 = "SELECT AVG(no_of_books) FROM library_details";
            ResultSet resultSet5 = statement.executeQuery(query5);
            resultSet5.next();
            System.out.println(resultSet5.getInt(1));


            System.out.println("Sum");
            String query6 = "SELECT SUM(no_of_books) FROM library_details";
            ResultSet resultSet6 = statement.executeQuery(query6);
            resultSet6.next();
            System.out.println(resultSet6.getInt(1));

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
