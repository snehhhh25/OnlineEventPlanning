package com.codefury.impl;

import java.sql.*;
import java.util.*;
import com.codefury.utils.*;
import com.codefury.enums.Service;
import com.codefury.exceptions.*;
import com.codefury.ifaces.Dao;
import com.codefury.model.Package;
import com.codefury.model.PlanRequest;
import com.codefury.model.Quotation;

public class VendorImpl implements Dao{
	Connection con;
	
     public VendorImpl(Connection con) {
    	 this.con=con;
     }
     
     //Adds the package and quotation based on the Object passed
     
	@Override
	public boolean addObject(Object obj1) throws UserAlreadyExistException {
		if(obj1 instanceof Quotation) {
			Quotation obj=(Quotation)obj1;
			String sql="insert into quotation values(?,?,?,?,?,?)";
			try(PreparedStatement psmt=con.prepareStatement(sql)){
				psmt.setInt(1, obj.getId());
				psmt.setDouble(2, obj.getEstimatedAmount());
				psmt.setInt(3, obj.getPackageId());
				psmt.setInt(4, obj.getRequestId());
				psmt.setString(5, obj.getStatus().toString()); 
				psmt.setInt(6,obj.getVendorId());
				psmt.executeUpdate();
				
			} catch (SQLException e) {
				throw new UserAlreadyExistException("Details entered are already there in the records");
			}
			
		}
		else if(obj1 instanceof Package) {
		Package obj=(Package)obj1;
		
		String sql="insert into package values(?,?,?,?,?,?)"; 
		try(PreparedStatement psmt=con.prepareStatement(sql)){
			psmt.setInt(1, obj.getPackageId());
			psmt.setString(2,obj.getType().toString());
			psmt.setString(3,obj.getServices().toString());
			psmt.setDouble(4, obj.getAmount());
			psmt.setInt(5, obj.getVendorId());
			psmt.setString(6,obj.getOtherServices().toString());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new UserAlreadyExistException("Details entered are already there in the records");
		}
		}
		return true;
	}
    
	//Listing all the requests

	@Override
	public List<Object> selectAll(Object t) {
		String sql="select * from request";
		List<Object> list=new ArrayList<>();
		try(PreparedStatement pstmt=con.prepareStatement(sql)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				PlanRequest obj=new PlanRequest();
				obj.setRequestId(rs.getInt(1));
				obj.setFromDate(rs.getDate(2).toLocalDate());
				obj.setToDate(rs.getDate(3).toLocalDate());
				obj.setNoOfVegPersonsAttend(rs.getInt(4));
				obj.setNoOfNonVegPersonsAttend(rs.getInt(5));
				obj.setServices(StringToList.convertToList((rs.getString(6)),Service.class));
				obj.setOtherServices(StringToList.convertToList((rs.getString(7)),String.class));
				obj.setUserId(rs.getInt(8));
			
				list.add(obj);
				
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

	@Override
	public boolean updateItem(Object t) throws UpdateAlreadyExistException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
