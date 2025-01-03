package com.xworkz.dealersapp.servicedao;

public interface ServiceDao {
    boolean validateData(String dealerName,String address, int pincode, String phoneNumber, String state,boolean isActive);

}
