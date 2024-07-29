package com.noesis.domain.dto;

import java.util.Date;

public class UserCreditHistoryForm {
	private String loggedInUserName;
	private String resellerName;
	private String sellerName;
	private String clientName;
	private String adminName;
	private String fromDate;
	private String toDate;
	private String pageNumber;
	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getResellerName() {
		return resellerName;
	}
	public void setResellerName(String resellerName) {
		this.resellerName = resellerName;
	}

	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	
}
