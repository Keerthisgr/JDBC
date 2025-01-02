package com.xworkz.customerapp.dao;
import java.sql.ResultSet;

public interface CustomerDao {
    public int save(String customerName, String address, int pincode, String phoneNumber, String state);
    ResultSet getAllDetails();
    ResultSet getById(int id);
    ResultSet getByName(String name,int pincode);
    ResultSet getByActive(boolean isActive);
    public int updateById(int id,String address,String phoneNumber);
    int deleteById(int id);

}
