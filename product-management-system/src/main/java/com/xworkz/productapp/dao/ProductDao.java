package com.xworkz.productapp.dao;

import java.sql.ResultSet;

public interface ProductDao {
    public int save(String productName, String brand, String color, double price, String category);
    ResultSet getAllDetails();
    ResultSet getById(int id);
    ResultSet getByName(String name,String color);
    ResultSet getByActive(boolean isActive);
    public int updateById(int id,String productName,String color);
    int deleteById(int id);
}
