package com.codefury.ifaces;

import java.util.List;

import com.codefury.exceptions.*;

public interface Dao {
	
	boolean addObject(Object t) throws UserAlreadyExistException;
	
	Object selectById(int id);
	
	boolean deleteById(int id);
	
	boolean updateItem(Object t) throws UpdateAlreadyExistException;

	List<Object> selectAll(Object obj);
	
	
	

}

