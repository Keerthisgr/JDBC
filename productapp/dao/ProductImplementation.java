package com.xworkz.productapp.dao;
import java.sql.*;
public class ProductImplementation implements ProductDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    private final String URL= "jdbc:mysql://localhost:3306/product_details";
    private  final String USERNAME = "root";
    private final String PASSWORD = "Keerthi8088169847";


    @Override
    public int save(String productName, String brand, String color, double price, String category,boolean isActive) {
        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            preparedStatement = connection.prepareStatement("insert into products_details values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, productName);
            preparedStatement.setString(3, brand);
            preparedStatement.setString(4, color);
            preparedStatement.setDouble(5,price);
            preparedStatement.setString(6,category);
            preparedStatement.setBoolean(7,isActive);
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
            preparedStatement = connection.prepareStatement("select * from products_details");
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
            preparedStatement = connection.prepareStatement("select * from products_details where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getByName(String name,String color) {
        try {
            connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("select * from products_details where product_name=? and color=?");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,color);
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
            preparedStatement = connection.prepareStatement("select * from products_details where is_active=?");
            preparedStatement.setBoolean(1,isActive);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int updateById(int id, String productName, String color) {
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            preparedStatement = connection.prepareStatement("update products_details set product_name=?,color=? where id=?");
            connection.setAutoCommit(false);
            preparedStatement.setString(1,productName);
            preparedStatement.setString(2,color);
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
            preparedStatement = connection.prepareStatement("delete from products_details where id=?");
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