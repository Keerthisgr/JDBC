package com.xworkz.dealersapp.servicedao;


import com.xworkz.dealersapp.dao.DealerDao;
import com.xworkz.dealersapp.dao.DealerImplementation;

public class ServiceDaoImpl implements ServiceDao{
    private static DealerDao dealerDao = new DealerImplementation();
    @Override
    public boolean validateData(String dealerName, String address, int pincode, String phoneNumber, String state, boolean isActive) {
        boolean isDealerName = false;
        boolean isAddress = false;
        boolean isPincode = false;
        boolean isPhoneNumber = false;
        boolean isState = false;
        if (dealerName != null && dealerName.length() > 3) {
            System.out.println("Dealer name is valid");
            isDealerName = true;
        } else {
            System.out.println("Dealer name is in valid");
            isDealerName = false;
        }
        if (address != null && address.length() > 3) {
            System.out.println("Address is valid");
            isAddress = true;
        } else {
            System.out.println("Address is in valid");
            isAddress = false;
        }
        if (pincode != 0 && pincode > 4) {
            System.out.println("Pincode is valid");
            isPincode = true;
        } else {
            System.out.println("Pincode is in valid");
            isPincode = false;

        }
        if (phoneNumber != null && phoneNumber.length() >= 10) {
            System.out.println("Phone number is valid");
            isPhoneNumber = true;
        } else {
            System.out.println("Phone number is in valid");
            isPhoneNumber = false;
        }
        if (state != null) {
            System.out.println("State is valid");
            isState = true;
        } else {
            System.out.println("State is in valid");
            isState = false;
        }
        if (isDealerName != false && isAddress != false && isPincode != false && isPhoneNumber != false && isState != false) {
            System.out.println("All fields are valid");
            int row = dealerDao.save(dealerName, address, pincode, phoneNumber, state, isActive);
            if (row > 0) {
                return true;
            } else {
                return false;
            }

        } else {
            System.out.println("Fields are invalid");
            return false;
        }
    }
}
