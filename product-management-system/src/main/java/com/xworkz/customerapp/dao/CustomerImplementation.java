package com.xworkz.customerapp.dao;

import java.sql.*;

public class CustomerImplementation implements CustomerDao{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    private final String URL= "jdbc:mysql://localhost:3306/product_details";
    private  final String USERNAME = "root";
    private final String PASSWORD = "Keerthi8088169847";

    @Override
    public int save(String customerName, String address, int pincode, String phoneNumber, String state) {
        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            preparedStatement = connection.prepareStatement("insert into customer_details values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, customerName);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, pincode);
            preparedStatement.setString(5,phoneNumber);
            preparedStatement.setString(6,state);
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

    @Override
    public ResultSet getAllDetails() {
        try {
            connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("select * from customer_details");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getById(int id) {
        try {
            connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("select * from customer_details where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getByName(String name,int pincode) {
        try {
            connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("select * from customer_details where customer_name=? or pincode=?");
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,pincode);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getByActive(boolean isActive) {
        try {
            connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("select * from customer_details where is_active=?");
            preparedStatement.setBoolean(1,isActive);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int updateById(int id, String address, String phoneNumber) {
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            preparedStatement = connection.prepareStatement("update customer_details set address=?,phone_number=? where id=?");
            connection.setAutoCommit(false);
            preparedStatement.setString(1,address);
            preparedStatement.setString(2,phoneNumber);
            preparedStatement.setInt(3,id);
            int row = preparedStatement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try{
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
    @Override
    public int deleteById(int id) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("delete from customer_details where id=?");
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            connection.commit();
            return row;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
            return 0;
        }
    }
}


