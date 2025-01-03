package com.xworkz.service;

import com.xworkz.productapp.dao.ProductDao;
import com.xworkz.productapp.dao.ProductImplementation;

public class ServiceDaoImpl implements ServiceDao{
static private ProductDao productDao = new ProductImplementation();

    @Override
    public boolean validateAndSave(String productName, String brand, String color,double price,String category,boolean isActive) {
        boolean isProductName = true;
        boolean isBrand = true;
        boolean isColor = true;
        boolean isPrice = true;
        boolean isCategory = true;
        boolean isActiveness = true;
        if(productName!=null && productName.length()>3){
            System.out.println("Product name is valid");
            isProductName = false;
        }else {
            System.out.println("Product name is in valid");
           isProductName = true;
        }
        if(brand!=null && brand.length()>3){
            System.out.println("Brand name is valid");
            isBrand = false;
        }else {
            System.out.println("Brand name is in valid");
            isBrand = true;
        }
        if(color!=null && color.length()>3){
            System.out.println("color name is valid");
          isColor = false;
        }else {
            System.out.println("color name is in valid");
            isColor = true;

        }
        if(price!=0.0 ){
            System.out.println("Price is valid");
            isPrice = false;
        }else {
            System.out.println("Price is in valid");
            isPrice = true;
        }
        if(category!=null&&category.length()>4 ){
            System.out.println("Category is valid");
            isCategory = false;
        }else {
            System.out.println("Category is in valid");
            isCategory = true;
        }
//        if(isActive!=false){
//            System.out.println("Active is valid");
//            isActiveness = false;
//        }else {
//            System.out.println("Active is in valid");
//            isActiveness = true;
//        }
        if(isProductName!=true&&isBrand!=true&&isColor!=true&&isPrice!=true&&isCategory!=true) {
            System.out.println("All fields are valid");
            int row = productDao.save(productName,brand,color,price,category,isActive);
            if(row>0){
                return false;
            }else{
                return  true;
            }
//            int row = productDao.save("Think pad", "Lenova", "Black", 89000.90, "Electronic gadgets");

        }else{
            System.out.println("Fields are invalid");
            return true;
        }
    }
}
