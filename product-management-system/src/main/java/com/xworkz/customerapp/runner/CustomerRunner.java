package com.xworkz.customerapp.runner;

import com.xworkz.customerapp.dao.CustomerDao;
import com.xworkz.customerapp.dao.CustomerImplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRunner {
    private static CustomerDao customerDao = new CustomerImplementation();
    public static void main(String[] args) {
//        int row =  customerDao.save("Adhya","Amruth Nagar",577401,"9078665437","Karnataka");
//        System.out.println(row+" row affected");

        ResultSet resultSet =customerDao.getAllDetails();

        try {

            if(resultSet.isFirst()==false){
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String customerName = resultSet.getString(2);
                    String address = resultSet.getString(3);
                    int pincode = resultSet.getInt(4);
                   String phoneNumber = resultSet.getString(5);
                    String state = resultSet.getString(6);

                    System.out.println("Id: "+id+"    Customer Name: "+customerName+"  Address: "+address+"  Pincode: "+pincode+  "   Phone number: "+phoneNumber+"  State: "+state);
                }
            }else{
                System.out.println("No data found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Get by id");
        boolean isEmapty = true;
        ResultSet resultSet1 = customerDao.getById(2);
        try{
            while (resultSet1.next()){
                isEmapty = false;
                int id = resultSet1.getInt(1);
                String customerName = resultSet1.getString(2);
                String address = resultSet1.getString(3);
                int pincode = resultSet1.getInt(4);
                String phoneNumber = resultSet1.getString(5);
                String state = resultSet1.getString(6);

                System.out.println("Id: "+id+"    Customer Name: "+customerName+"  Address: "+address+"  Pincode: "+pincode+  "   Phone number: "+phoneNumber+"  State: "+state);


            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmapty) System.out.println("No data found");
        }

        System.out.println("Get by name");
        boolean isEmapty2= true;
        ResultSet resultSet2 = customerDao.getByName("Akash",577901);
        try{
            while (resultSet2.next()){
                isEmapty2 = false;
                int id = resultSet2.getInt(1);
                String customerName = resultSet2.getString(2);
                String address = resultSet2.getString(3);
                int pincode = resultSet2.getInt(4);
                String phoneNumber = resultSet2.getString(5);
                String state = resultSet2.getString(6);

                System.out.println("Id: "+id+"    Customer Name: "+customerName+"  Address: "+address+"  Pincode: "+pincode+  "   Phone number: "+phoneNumber+"  State: "+state);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmapty2) System.out.println("No data found");
        }

        System.out.println("Get by Activeness");
        boolean isEmapty3= true;
        ResultSet resultSet3 = customerDao.getByActive(true);
        try{
            while (resultSet3.next()){
                isEmapty3 = false;
                int id = resultSet3.getInt(1);
                String customerName = resultSet3.getString(2);
                String address = resultSet3.getString(3);
                int pincode = resultSet3.getInt(4);
                String phoneNumber = resultSet3.getString(5);
                String state = resultSet3.getString(6);
                boolean isActive = resultSet3.getBoolean(7);

                System.out.println("Id: "+id+"    Customer Name: "+customerName+"  Address: "+address+"  Pincode: "+pincode+  "   Phone number: "+phoneNumber+"  State: "+state+ "  Is Active:  "+isActive);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmapty2) System.out.println("No data found");
        }
        int row =  customerDao.updateById(4,"Kuvempu nagar","9878651124");
        System.out.println(row+ "row affected!!");

    }

}
