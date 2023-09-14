package com.codefury.model;

import java.time.LocalDate;
import com.codefury.enums.Service;
import java.util.*;

public class PlanRequest {
        private int requestId;
        private LocalDate fromDate;
        private LocalDate toDate;
        private int noOfVegPersonsAttend;
        private int noOfNonVegPersonsAttend;
        private List<Service> services;
        private List<String> otherServices;
        private int userId;
        public PlanRequest() {
        	super();
        }
		public PlanRequest(int requestId, LocalDate fromDate, LocalDate toDate, int noOfVegPersonsAttend,
				int  noOfNonVegPersonsAttend,List<Service> services, List<String> otherServices,User user) {
			super();
			this.requestId = requestId;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.noOfVegPersonsAttend = noOfVegPersonsAttend;
			this. noOfNonVegPersonsAttend= noOfNonVegPersonsAttend;
			this.services = services;
			this.otherServices = otherServices;
			this.userId=user.getId();
		}
		public int getRequestId() {
			return requestId;
		}
		public void setRequestId(int requestId) {
			this.requestId = requestId;
		}
		public LocalDate getFromDate() {
			return fromDate;
		}
		public void setFromDate(LocalDate fromDate) {
			this.fromDate = fromDate;
		}
		public LocalDate getToDate() {
			return toDate;
		}
		public void setToDate(LocalDate toDate) {
			this.toDate = toDate;
		}
		public int getNoOfVegPersonsAttend() {
			return noOfVegPersonsAttend;
		}
		public void setNoOfVegPersonsAttend(int noOfVegPersonsAttend) {
			this.noOfVegPersonsAttend = noOfVegPersonsAttend;
		}
		 
		public int getNoOfNonVegPersonsAttend() {
			return noOfNonVegPersonsAttend;
		}
		public void setNoOfNonVegPersonsAttend(int noOfNonVegPersonsAttend) {
			this.noOfNonVegPersonsAttend = noOfNonVegPersonsAttend;
		}
		public List<Service> getServices() {
			return services;
		}
		public void setServices(List<Service> services) {
			this.services = services;
		}
		public List<String> getOtherServices() {
			return otherServices;
		}
		public void setOtherServices(List<String> otherServices) {
			this.otherServices = otherServices;
		}
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		@Override
		public String toString() {
			StringBuffer details=new StringBuffer();
			details.append(this.requestId).append(" ").append(this.fromDate).append(" ");
			details.append(this.toDate).append(" ").append(this.services).append(" ");
			details.append(this.noOfVegPersonsAttend).append(" ");
			details.append(this.noOfNonVegPersonsAttend).append(" ").append(this.otherServices);
			details.append(" ").append(this.userId);
			return details.toString();
		}
        
        
}
