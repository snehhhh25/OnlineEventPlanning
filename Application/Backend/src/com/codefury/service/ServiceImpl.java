package com.codefury.service;

import com.codefury.enums.Status;
import com.codefury.exceptions.InvalidAccessException;
import com.codefury.exceptions.UpdateAlreadyExistException;
import com.codefury.exceptions.UserAlreadyExistException;
import com.codefury.ifaces.*;
import com.codefury.impl.UserImpl;
import com.codefury.model.*;
import com.codefury.model.Package;

import java.sql.SQLException;
import java.util.List;
public class ServiceImpl {
      private Dao daoObj;
      private Verification verificationObj;
      public ServiceImpl(Dao daoObj,Verification verificationObj) {
    	  this.daoObj=daoObj;
    	  this.verificationObj=verificationObj;
      }
      public boolean add(Object object1,Object object2) throws UserAlreadyExistException, InvalidAccessException, SQLException  {
    	 if(verificationObj.verify(object1, object2)) {
    	 boolean result= this.daoObj.addObject(object2);
    	  if(object2 instanceof Package && object1 instanceof Vendor) {
    		  addToList(object1,object2);
    	  }
    	  return result;
    	 }
    	 return false;
      }
      public List<Object> viewAll(Object object1,Object object2) throws InvalidAccessException, SQLException {
    	  if(verificationObj.verify(object1, object2)) {
    	  return this.daoObj.selectAll(object1);
    	  }
    	  return null;
      }
      public boolean update(Object object1,Object object2) throws UpdateAlreadyExistException, InvalidAccessException, SQLException  {
    	  if(verificationObj.verify(object1, object2)) {
    	  return this.daoObj.updateItem(object1);
      }
    	  return false;
      }
      public void addToList(Object object1,Object object2) {
    	  Package packageObj=(Package)object2;
    	  Vendor vendor=(Vendor)object1;
    	  List<Integer> list=vendor.getPackageIds();
    	  list.add(packageObj.getPackageId()); 
      }
      public boolean updateStatus(Quotation quotation,Status status,User user) throws UpdateAlreadyExistException, InvalidAccessException, SQLException {
    	  if(this.daoObj instanceof UserImpl) {
    		  UserImpl userService=(UserImpl)daoObj;
    		  return userService.updateStatus(quotation, status);
    	  }
    	  return false;
      }
}
