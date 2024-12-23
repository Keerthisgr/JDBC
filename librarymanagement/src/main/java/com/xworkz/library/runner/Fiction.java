package com.xworkz.library.runner;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Fiction {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver found");
            String url = "jdbc:mysql://localhost:3306/LIBRARY";
            String userName = "root";
            String password = "Keerthi8088169847";
            DriverManager.getConnection(url, userName, password);
            System.out.println("Established");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("JDBC Driver not found "+e.getMessage());
        }
    }
}
