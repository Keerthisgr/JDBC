package com.xworkz.dealersapp.dao;

import java.sql.ResultSet;

public interface DealerDao {
    public int save(String name, String address, int pincode, String phoneNumber, String state);
    ResultSet getAllDetails();
    ResultSet getById(int id);
    ResultSet getByName(String name,String phoneNumber);
    ResultSet getByActive(boolean isActive);
    public int updateById(int id,String address,String phoneNumber);
}
