package com.codefury.factory;

import java.sql.Connection;

import com.codefury.ifaces.Dao;
import com.codefury.impl.*;
import com.codefury.service.VerificationService;
import com.codefury.utils.ConnectionUtils;

public class FactoryClass {
     public static Dao getDaoObject(int choice) {
    	 Connection con=ConnectionUtils.getMySqlConnection();
    	 switch(choice) {
    	 case 1:return new AdminDaoImpl(con);
    	 case 2:return new UserImpl(con);
    	 default:return new VendorImpl(con);
    	 }
    	 
     }
     public static VerificationService getVerificationObject() {
    	 Connection con=ConnectionUtils.getMySqlConnection();
    	 return new VerificationService(con);
     }
}
