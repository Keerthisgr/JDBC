package com.xworkz.service;

public interface ServiceDao {
     boolean validateAndSave(String productName,String brand,String color,double price,String category,boolean isActive);
}
