package com.codefury.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	
	private static Connection con;
	
	
public static Connection getMySqlConnection() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codefury", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection() {
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
