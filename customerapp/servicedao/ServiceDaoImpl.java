package com.xworkz.customerapp.servicedao;

import com.xworkz.customerapp.dao.CustomerDao;
import com.xworkz.customerapp.dao.CustomerImplementation;

public class ServiceDaoImpl implements ServiceDao{
    private static CustomerDao customerDao = new CustomerImplementation();
    @Override
    public boolean validateData(String customerName, String address, int pincode, String phoneNumber, String state, boolean isActive) {
        boolean isCustomerName = false;
            boolean isAddress = false;
            boolean isPincode = false;
            boolean isPhoneNumber = false;
            boolean isState = false;
            if(customerName!=null && customerName.length()>3){
                System.out.println("Customer name is valid");
                isCustomerName = true;
            }else {
                System.out.println("Customer name is in valid");
                isCustomerName = false;
            }
            if(address!=null && address.length()>3){
                System.out.println("Address is valid");
                isAddress = true;
            }else {
                System.out.println("Address is in valid");
                isAddress = false;
            }
            if(pincode!=0 && pincode>4){
                System.out.println("Pincode is valid");
                isPincode = true;
            }else {
                System.out.println("Pincode is in valid");
                isPincode = false;

            }
            if(phoneNumber!=null&&phoneNumber.length()>=10 ){
                System.out.println("Phone number is valid");
                isPhoneNumber = true;
            }else {
                System.out.println("Phone number is in valid");
                isPhoneNumber = false;
            }
        if(state!=null){
            System.out.println("State is valid");
            isState =true;
        }else {
            System.out.println("State is in valid");
            isState = false;
        }
            if(isCustomerName!=false&&isAddress!=false&&isPincode!=false&&isPhoneNumber!=false&&isState!=false) {
                System.out.println("All fields are valid");
                int row = customerDao.save(customerName,address,pincode,phoneNumber,state,isActive);
                if(row>0){
                    return true;
                }else{
                    return false;
                }

            }else{
                System.out.println("Fields are invalid");
                return false;
            }
    }
}
