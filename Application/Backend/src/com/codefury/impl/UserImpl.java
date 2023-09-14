package com.codefury.impl;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.codefury.enums.*;
import com.codefury.exceptions.*;
import com.codefury.ifaces.Dao;
import com.codefury.model.*;

public class UserImpl implements Dao{
     Connection con;
     public UserImpl(Connection con) {
    	 this.con=con;
     }
   
     //Adds the PlanRequest
     
	@Override
	public boolean addObject(Object obj) throws UserAlreadyExistException {
		PlanRequest request=(PlanRequest)obj;
		String sql="insert into request values(?,?,?,?,?,?,?,?)";
		try(PreparedStatement psmt=con.prepareStatement(sql)){
			psmt.setInt(1,request.getRequestId());
			psmt.setDate(2,Date.valueOf(request.getFromDate()));
			psmt.setDate(3,Date.valueOf(request.getToDate()));
			psmt.setInt(4,request.getNoOfVegPersonsAttend() );
			psmt.setInt(5, request.getNoOfNonVegPersonsAttend());
			psmt.setString(6,request.getServices().toString());
			psmt.setString(7,request.getOtherServices().toString());
			psmt.setInt(8, request.getUserId());
			psmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			throw new UserAlreadyExistException("Details entered are already there in the records");
		}
		
		return true;
	}

	//Listing all the quotations
	
	@Override
	public List<Object> selectAll(Object obj) {
		User user=(User)obj;
		List<Object> list=new ArrayList<>();
		String sql="select q.id,q.estimated_amount,q.request_id,q.vendor_id,q.status,p.package_type from quotation q,package p "
				+ "where q.request_id in(select r.request_id from request r where r.user_id=?)";
		try(PreparedStatement psmt=con.prepareStatement(sql)){
			psmt.setInt(1, user.getId());
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				Quotation quotation=new Quotation();
				quotation.setId(rs.getInt(1));
				quotation.setEstimatedAmount(rs.getDouble(2));
				quotation.setRequestId(rs.getInt(3));
				quotation.setVendorId(rs.getInt(4));
				quotation.setStatus(Status.valueOf(rs.getString(5)));
				quotation.setType(PackageType.valueOf(rs.getString(6)));
				quotation.setUserId(user.getId());
				list.add(quotation);
				
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//Updating the user details/status of the quotation 

	@Override
	public boolean updateItem(Object obj) throws UpdateAlreadyExistException {
		int rowsUpdated=0;
		User user=(User)obj;
		String sql="update user set mobile=?,email=?,location=?,password=?";
		try(PreparedStatement psmt=con.prepareStatement(sql)){
			psmt.setLong(1,user.getMobile());
			psmt.setString(2, user.getEmail());
			psmt.setString(3,user.getLocation());
			psmt.setString(4,user.getPassword());
			rowsUpdated=psmt.executeUpdate();
			if(rowsUpdated==0) {
				throw new SQLException();
			}
		} 
		catch (SQLException e) {
			throw new UpdateAlreadyExistException("The update that needs to be done already exists");
		}
		
		return true;
	}
	
	//Updates the quotation status thats specified by user
	
	public boolean updateStatus(Quotation quotation,Status status) throws UpdateAlreadyExistException{
		int rowsUpdated=0;
		String sql="update quotation set status=? where id=?";
		try(PreparedStatement psmt=con.prepareStatement(sql)){
			psmt.setString(1,status.toString());
			psmt.setInt(2,quotation.getId());
			rowsUpdated=psmt.executeUpdate();
			if(rowsUpdated==0) {
				throw new SQLException();
			}
		} 
		catch (SQLException e) {
			throw new UpdateAlreadyExistException("The update that needs to be done already exists");
		}
		return true;
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
