package com.xworkz.customerapp.runner;

import com.xworkz.customerapp.servicedao.ServiceDao;
import com.xworkz.customerapp.servicedao.ServiceDaoImpl;

public class ServiceRunner {
    private static ServiceDao serviceDao = new ServiceDaoImpl();
    public static void main(String[] args) {
        boolean save = serviceDao.validateData("Keerthana","R R Nagar",577401,"8976543251","Karnataka",true);
        if(save==true){
            System.out.println("All data is saved");
        }else {
            System.out.println("Invalid data");
        }
    }
}
