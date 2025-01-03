package com.xworkz.productapp.runner;

import com.xworkz.productapp.dao.ProductDao;
import com.xworkz.productapp.dao.ProductImplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRunner {
    private static ProductDao productDao = new ProductImplementation();
    public static void main(String[] args) {

//        int row =  productDao.save("Washing machine","LG","White",62600.99,"Electronic gadgets");
//        System.out.println(row+" row affected");

        ResultSet resultSet =productDao.getAllDetails();

        try {

            if(resultSet.isFirst()==false){
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String productName = resultSet.getString(2);
                    String brand = resultSet.getString(3);
                    String color = resultSet.getString(4);
                    double price = resultSet.getDouble(5);
                    String category = resultSet.getString(6);

                    System.out.println("Id: "+id+"    Product Name: "+productName+"  Brand: "+brand+"  Color: "+color+  "   price: "+price+"  category: "+category);
                }
            }else{
                System.out.println("No data found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Get by id");
        boolean isEmapty = true;
        ResultSet resultSet1 = productDao.getById(2);
        try{
            while (resultSet1.next()){
                isEmapty = false;
                int id = resultSet1.getInt(1);
                String productName = resultSet1.getString(2);
                String brand = resultSet1.getString(3);
                String color = resultSet1.getString(4);
                double price = resultSet1.getDouble(5);
                String category = resultSet1.getString(6);
                System.out.println("Id: "+id+"    Product Name: "+productName+"  Brand: "+brand+"  Color: "+color+  "   price: "+price+"  category: "+category);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmapty) System.out.println("No data found");
        }

        System.out.println("Get by name");
        boolean isEmapty1 = true;
        ResultSet resultSet2 = productDao.getByName("Projector","White");
        try{
            while (resultSet2.next()){
                isEmapty1 = false;
                int id = resultSet2.getInt(1);
                String productName = resultSet2.getString(2);
                String brand = resultSet2.getString(3);
                String color = resultSet2.getString(4);
                double price = resultSet2.getDouble(5);
                String category = resultSet2.getString(6);
                System.out.println("Id: "+id+"    Product Name: "+productName+"  Brand: "+brand+"  Color: "+color+  "   price: "+price+"  category: "+category);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmapty1) System.out.println("No data found");
        }
        System.out.println("Get by Activeness");
        boolean isEmapty3= true;
        ResultSet resultSet3 = productDao.getByActive(true);
        try{
            while (resultSet3.next()){
                isEmapty3 = false;
                int id = resultSet3.getInt(1);
                String productName = resultSet3.getString(2);
                String brand = resultSet3.getString(3);
                String color = resultSet3.getString(4);
                double price = resultSet3.getDouble(5);
                String category = resultSet3.getString(6);
                boolean isActive = resultSet3.getBoolean(7);
                System.out.println("Id: "+id+"    Product Name: "+productName+"  Brand: "+brand+"  Color: "+color+  "   price: "+price+"  category: "+category+"  Activeness:"+isActive);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            if(isEmapty3) System.out.println("No data found");
        }
        int row =  productDao.updateById(4,"Projector","White");
        System.out.println(row+ "row affected!!");

        int row1= productDao.deleteById(3);
        System.out.println(row1+" Row deleted successfully");

    }
}
