package com.xworkz.customerapp.servicedao;

public interface ServiceDao {
    boolean validateData(String customerName,String address, int pincode, String phoneNumber, String state,boolean isActive);
}
