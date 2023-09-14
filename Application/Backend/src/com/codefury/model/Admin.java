package com.codefury.model;

public class Admin {
      private String userName;
      private String fullName;
      private String password;
      private String email;
      private long mobile;
      
      private static Admin admin;
	private Admin(String userName,String password) {
		super();
		this.userName=userName;
		this.password=password;
		
		
	}
	//Makes sure that only one admin can exist 
	synchronized public static Admin getInstance() {
		if(admin==null) {
			admin= new Admin("admin","admin");
		}
		return admin;
	}
	public String getUserName() {
		return userName;
	}

	public String getFullName() {
		return fullName;
	}
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
		public long getMobile() {
		return mobile;
	}

	
      
}
