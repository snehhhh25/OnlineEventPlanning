package com.codefury.model;

import java.util.*;
import com.codefury.enums.*;

public class Package{
	private int packageId;
	private PackageType type;
	private Map<Service,Integer> services;
	private double amount;
	private int vendorId;
	private Map<String,Integer> otherServices;
	public Package(int packageId, PackageType type,Map<Service,Integer> services,Map<String,Integer> otherServices,Vendor vendor) {
		super();
		this.packageId = packageId;
		this.type = type;
		this.services=services;
		this.otherServices=otherServices;
		this.amount=calculate();
		this.vendorId=vendor.getId();
	
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public PackageType getType() {
		return type;
	}
	public void setType(PackageType type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Map<Service, Integer> getServices() {
		return services;
	}
	public void setServices(Map<Service, Integer> services) {
		this.services = services;
	}
	public Map<String, Integer> getOtherServices() {
		return otherServices;
	}
	public void setOtherServices(Map<String, Integer> otherServices) {
		this.otherServices = otherServices;
	}
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	private double calculate() {
		for(Service keys:services.keySet()) {
			amount+=services.get(keys);
		}
		for(String keys:otherServices.keySet()) {
			amount+=otherServices.get(keys);
		}
		return amount;
	}
	
	@Override
	public String toString() {
		StringBuffer details=new StringBuffer();
		details.append(this.packageId).append(" ").append(this.type).append(" ");
		details.append(this.amount).append(" ").append(this.otherServices).append(" ");
		details.append(this.vendorId);
		return details.toString();
	}
	
	
	
	
}
