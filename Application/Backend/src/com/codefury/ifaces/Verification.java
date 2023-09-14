package com.codefury.ifaces;

import java.sql.SQLException;

import com.codefury.exceptions.InvalidAccessException;

public interface Verification {
	
	boolean verify(Object t, Object k) throws InvalidAccessException, SQLException; 
	

}
