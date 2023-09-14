package com.codefury.model;

import java.time.LocalDate;
import com.codefury.enums.Department;

public class User {
      private int id;
      private String fullName;
      private String userName;
      private String password;
      private LocalDate dateOfBirth;
      private Department department;
      private long mobile;
      private String email;
      private String location;
      private boolean status;
	public User(int id, String fullName, String userName, String password, LocalDate dateOfBirth, Department department,
			long mobile, String email, String location) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.mobile = mobile;
		this.email = email;
		this.location = location;
		this.status=false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		StringBuffer details=new StringBuffer();
		details.append(this.fullName).append(" ").append(this.department).append(" ");
		details.append(this.email).append(" ").append(this.location);
		return details.toString();
	}
	
      
}
