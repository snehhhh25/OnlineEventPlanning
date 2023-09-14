package com.codefury.model;

import java.util.*;

public class Vendor {
      private String name;
      private int id;
      private String address;
      private String email;
      private List<Long> contactNumbers;
      private List<Integer> packageIds;
      private String userName;
      private String password;

	public Vendor(String name, int id, String address,String email, List<Long> contactNumbers,String userName,String password) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.email=email;
		this.contactNumbers = contactNumbers;
		this.packageIds=new ArrayList<>();
		this.userName=userName;
		this.password=password;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Long> getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(List<Long> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	public List<Integer> getPackageIds() {
		return packageIds;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPackageIds(List<Integer> packageIds) {
		this.packageIds = packageIds;
	}

	@Override
	public String toString() {
		StringBuffer details=new StringBuffer();
		details.append(this.name).append(" ").append(this.id).append(" ");
		details.append(this.address).append(" ").append(this.email).append(" ");
		details.append(this.contactNumbers).append(" ").append(this.packageIds);
		return details.toString();
	}
	
      
      
}
