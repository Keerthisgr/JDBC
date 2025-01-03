package com.xworkz.productapp.runner;

import com.xworkz.service.ServiceDao;
import com.xworkz.service.ServiceDaoImpl;

public class ServiceRunner {
    static private ServiceDao serviceDao = new ServiceDaoImpl();
    public static void main(String[] args) {
       boolean save = serviceDao.validateAndSave("Think pad","Lenova","Black",89000.90,"Electronic Gadgets",true);
        if(save==false){
            System.out.println("All data is saved");
        }else {
            System.out.println("Invalid data");
        }
    }
}
