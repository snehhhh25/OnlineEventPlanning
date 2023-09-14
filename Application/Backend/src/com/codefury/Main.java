package com.codefury;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.codefury.enums.Department;
import com.codefury.enums.PackageType;
import com.codefury.enums.Service;
import com.codefury.enums.Status;
import com.codefury.exceptions.InvalidAccessException;
import com.codefury.exceptions.UpdateAlreadyExistException;
import com.codefury.exceptions.UserAlreadyExistException;
import com.codefury.factory.FactoryClass;
import com.codefury.ifaces.*;
import com.codefury.model.Admin;
import com.codefury.model.Package;
import com.codefury.model.PlanRequest;
import com.codefury.model.Quotation;
import com.codefury.model.User;
import com.codefury.model.Vendor;
import com.codefury.service.*;

public class Main {
   public static void main(String[] args) {
	   Dao obj=FactoryClass.getDaoObject(2);
	   Verification verifyObject=FactoryClass.getVerificationObject();
	   ServiceImpl service=new ServiceImpl(obj,verifyObject);
	   Admin admin=Admin.getInstance();
	   User user=new User(1,"Ramesh","ramesh_ram","Ramesh1234@",LocalDate.of(2018, 9, 12),Department.IT,9090909090L,"ramesh@gmail.com","Hyderabad");
	   Vendor vendor=new Vendor("Ram", 1, "hyd", "ram@gmail.com",List.of(9590878756L) ,"ram_12","Ram@1234");
	   Map<Service,Integer> services=Map.of(Service.DECORATION,1000,Service.PHOTOGRAPHY,2000);
	   Map<String,Integer> others=Map.of("dj",9000);
	   List<Service> userServices=List.of(Service.DECORATION,Service.PHOTOGRAPHY);
	   List<String> otherServices=List.of("dj");
	   Package packageObj=new Package(1,PackageType.BASIC,services,others,vendor);
	   PlanRequest request=new PlanRequest(1,LocalDate.of(2023, 6, 8),LocalDate.of(2023,7,9),5,6,userServices,otherServices,user);
	   Quotation quotation=new Quotation(1,packageObj,request);
	   try {
		  // service.add(admin, vendor);
		//   service.add(vendor,packageObj);
		//   service.add(vendor,quotation);
		   service.updateStatus(quotation, Status.ACCEPTED, user);
		   
	
		
	} catch ( InvalidAccessException | SQLException e) {
		System.out.println(e.getMessage());
	} catch (UpdateAlreadyExistException e) {
		System.out.println(e.getMessage());
	}
     //   catch(UserAlreadyExistexception e) {
	//	   System.out.println(e.getMessage());
	 //  }
	   
   }
}
