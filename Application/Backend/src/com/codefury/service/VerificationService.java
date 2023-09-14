package com.codefury.service;

import java.sql.*;
import com.codefury.exceptions.*;
import com.codefury.ifaces.Verification;
import com.codefury.model.*;
import com.codefury.model.Package;

public class VerificationService implements Verification {
	private static final String FINDADMINCREDENTIALS = "select password from admin where user_name=?";
	private static final String GETREQUEST = "select * from request where request_id=?";
	private static final String FINDUSERCREDENTIALS = "select password from user where user_name=?";
	private static final String GETQUOTATION = "select * from quotation from quotation where id=?";
	private static final String FINDVENDORCREDENTIALS = "select * from vendor where id=?";
	private static final String GETPACKAGE = "select * from package where  package_id=?";
	private Connection con;
	
	
	
	
	public VerificationService(Connection con) {
		super();
		this.con = con;
	}
	@Override
	public boolean verify(Object t, Object k) throws InvalidAccessException, SQLException {
		if(t instanceof Admin && k instanceof Vendor) {
			
			Admin admin = (Admin)t;
			
		
			
			try(PreparedStatement ps =  con.prepareStatement(FINDADMINCREDENTIALS)){
				ps.setString(1, admin.getUserName());
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
				if(rs.getString(1).equals(admin.getPassword())){
					return true;
				}else {
					throw new InvalidAccessException();
				}
				}
				
				return true;
				
			}catch(SQLException e){
				throw e;
			}
			
		}
			else if(t instanceof User && k instanceof PlanRequest) {
				User user = (User)t;
				
				PlanRequest request = (PlanRequest)k;
				

							
						try(PreparedStatement pstm =  con.prepareStatement(FINDUSERCREDENTIALS)){
							
							pstm.setString(1, user.getUserName());
							ResultSet rset = pstm.executeQuery();
							
							
							if(rset.next()&&rset.getString(1).equals(user.getPassword())&&request.getUserId()==user.getId()) {
								return true;
							}else {
								throw new InvalidAccessException();
							}
							
							
						}catch(SQLException| InvalidAccessException e){
							throw e;
						}
						
						
					}
		
						
			else if(t instanceof Vendor && k instanceof Quotation) {
				Vendor vendor = (Vendor)t;
				
				Quotation quotation = (Quotation)k;	

						
						try(PreparedStatement pstm =  con.prepareStatement(FINDVENDORCREDENTIALS)){
							
							pstm.setInt(1, vendor.getId());
							ResultSet rset = pstm.executeQuery();
							
							
							if(rset.next()&&rset.getString(7).equals(vendor.getPassword())&&quotation.getVendorId()==vendor.getId()) {
								return true;
							}else {
								throw new InvalidAccessException();
							}
							
							
							
						}catch(SQLException| InvalidAccessException e){
							throw e;
						}
			}
			else if(t instanceof Vendor && k instanceof Package) {
				Vendor vendor = (Vendor)t;
				
				Package pack = (Package)k;
			
						try(PreparedStatement pstm =  con.prepareStatement(FINDVENDORCREDENTIALS)){
							
							pstm.setInt(1, vendor.getId());
							ResultSet rset = pstm.executeQuery();
							
							
							if(rset.next() && rset.getString(7).equals(vendor.getPassword())&&vendor.getId()==pack.getVendorId()) {
								return true;
							}else {
								throw new InvalidAccessException("Credentials incorrect");
							}
							
							
							
						}catch(SQLException| InvalidAccessException e){
							throw e;
						}
						
						
					}else {
						throw new InvalidAccessException();
					}
					
				}
}
	
