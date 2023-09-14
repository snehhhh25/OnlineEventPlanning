package com.codefury.model;

import com.codefury.enums.*;
import java.util.*;

public class Quotation {
       private int id;
       private int packageId;
       private PackageType type;
       private double estimatedAmount;
       private int vendorId; 
       private int requestId;
       private Status status;
       private Package packageObj;
       private PlanRequest request;
       private int userId;
       public Quotation() {
    	   super();
       }
	public Quotation(int id,com.codefury.model.Package packageObj,PlanRequest request) {
		super();
		this.id = id;
		this.packageId = packageObj.getPackageId();
		this.status=Status.PENDING;
		this.packageObj=packageObj;
		this.packageId=packageObj.getPackageId();
		this.request=request;
		this.requestId=request.getRequestId();
		this.type=packageObj.getType();
		this.userId=request.getUserId();
		this.vendorId=packageObj.getVendorId();
		this.estimatedAmount=calculateEstimatedAmount();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public double getEstimatedAmount() {
		return estimatedAmount;
	}
	public void setEstimatedAmount(double estimatedAmount) {
		this.estimatedAmount =estimatedAmount;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public Status getStatus() {
		return this.status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public PackageType getType() {
		return type;
	}
	public void setType(PackageType type) {
		this.type = type;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double calculateEstimatedAmount() {
		double amount =0;
		List<Service> requestServices=request.getServices();
		Map<Service,Integer> vendorServices=packageObj.getServices();
		Map<String,Integer> otherServices=packageObj.getOtherServices();
		List<String> requestOtherServices=request.getOtherServices();
		for(Service service:requestServices) {
			amount+=vendorServices.get(service);
		}
		for(String otherService:requestOtherServices) {
			if(otherServices.containsKey(otherService)) {
				amount+=otherServices.get(otherService);
			}
		}
		return amount;
		
	}
	@Override
	public String toString() {
		StringBuffer details=new StringBuffer();
		details.append(this.id).append(" ").append(this.packageId).append(" ");
	    details.append(this.estimatedAmount).append("Request id is ").append(this.requestId);
	    details.append(" ").append("Vendor id is ").append(this.vendorId).append(" ").append(status);
		return details.toString();
	}
       
	
       
       
}
