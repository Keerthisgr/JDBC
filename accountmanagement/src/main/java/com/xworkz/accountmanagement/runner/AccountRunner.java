package com.xworkz.accountmanagement.runner;
import java.sql.*;


public class AccountRunner {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver found");
            String url="jdbc:mysql://localhost:3306/account";
            String userName="root";
            String password="Keerthi8088169847";
            DriverManager.getConnection(url,userName,password);
            System.out.println("Establish the connection");
        }catch (ClassNotFoundException|SQLException e){
            System.out.println("JDBC Driver not found "+e.getMessage());
        }
    }
}
