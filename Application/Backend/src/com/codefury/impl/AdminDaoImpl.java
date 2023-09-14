package com.codefury.impl;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.codefury.exceptions.*;
import com.codefury.enums.Department;
import com.codefury.ifaces.Dao;
import com.codefury.model.User;
import com.codefury.model.Vendor;
import com.codefury.utils.StringToList;
public class AdminDaoImpl implements Dao {
	public static final String VendorTable = "vendor ";
	
	public static final String UserTable ="user ";
	private static final String ADDVENDOR = "insert into " + VendorTable + "values(?,?,?,?,?,?,?)";
	private static final String UPDATEUSER = "update " + UserTable + "set status=1 where id=?";

	private static final String SELECTUSERS = "select * from " + UserTable;

	private static final String SELECTVENDORS = "select * from "+VendorTable;
	
	private Connection con;
	public AdminDaoImpl(Connection con) {
		super();
		this.con = con;
		
	}
	@Override
	public boolean addObject(Object t) throws UserAlreadyExistException{
		
		int rowAffected = 0;
		if(t  instanceof Vendor) {	
			Vendor vendor = (Vendor)t;
			try(PreparedStatement ps =  con.prepareStatement(ADDVENDOR)) {
				ps.setInt(1,vendor.getId());
				ps.setString(2, vendor.getName());
				ps.setString(3, vendor.getAddress());
				ps.setString(4, vendor.getEmail());
				ps.setString(5, vendor.getContactNumbers().toString());
				ps.setString(6, vendor.getUserName());
				ps.setString(7, vendor.getPassword());
				rowAffected = ps.executeUpdate();
				
			} catch (SQLException e) {
				throw new UserAlreadyExistException("The details provided are already exist in records");
				
			}		
		}

		return rowAffected==1?true:false;	
	}


	@Override
	public Object selectById(int id) {
		
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(Object t) throws UpdateAlreadyExistException{
		User user = (User)t;
		int rowAffected=0;
		try(PreparedStatement ps = con.prepareStatement(UPDATEUSER)) {
			ps.setInt(1, user.getId());	
			rowAffected=ps.executeUpdate();
			System.out.println(rowAffected);
		
			if(rowAffected == 0) {
				throw new Exception();
			}
			user.setStatus(true);
			
		}
		catch (Exception e) {
			throw new UpdateAlreadyExistException("The update that needs to be done already exists");
			}
		return rowAffected==1?true:false;
	}
	

	@Override
	public List<Object> selectAll(Object type) {
			if(type instanceof User) {
		List<Object> list = new ArrayList<>();
	try(PreparedStatement pstmt = con.prepareStatement(SELECTUSERS)) {
		
		ResultSet rs =pstmt.executeQuery();
		
		while (rs.next()) {
			
			User user = maptoUser(rs);
			
			list.add(user);
			
			
			return list;
			
		}
	
	} catch (Exception e) {
		// TODO: handle exception
	}
	
		}
	else if(type instanceof Vendor) {
		
		List<Object> list = new ArrayList<>();
	try(PreparedStatement pstmt = con.prepareStatement(SELECTVENDORS)) {
		
		ResultSet rs =pstmt.executeQuery();
		
		while (rs.next()) {
			
			Vendor vendor = maptoVendor(rs);
			
			list.add(vendor);
			
			
			return list;
			
		}
		
		
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
}
		return null;		
		
	}


private User maptoUser(ResultSet rs) throws SQLException {
	int  id = rs.getInt("id");
	String fullName = rs.getString("full_name");
	String userName = rs.getString("user_name");
	String password = rs.getString("password");
	LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
	String key = rs.getString("department");
	Department department=Department.valueOf(key);	
	long mobile = rs.getLong("mobile");
	String email = rs.getString("email");
	String location = rs.getString("location");	
	return new User(id, fullName, userName, password, dateOfBirth, department, mobile, email, location);
}


private Vendor maptoVendor(ResultSet rs) throws SQLException{
	
	String name = rs.getString("name");
	
	int id = rs.getInt("id");
	
	String address = rs.getString("address");
	
	String Email = rs.getString("email");
	
	String contactNumbersString = rs.getString("contact_numbers");
	
	List<Long> contactNumbers = StringToList.convertToList(contactNumbersString, Long.class);
	String password = rs.getString("password");
	String userName = rs.getString("user_name");
	return new Vendor(name, id, address, Email, contactNumbers, userName, password);
	
	
}

}
 