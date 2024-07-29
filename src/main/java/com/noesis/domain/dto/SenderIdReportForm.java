package com.noesis.domain.dto;

public class SenderIdReportForm {
	
	private String loggedInUserName;
	private String fromDate;
	private String toDate;
	private String selectSenderId;
	private String pageNumber;
	
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
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
	public String getSelectSenderId() {
		return selectSenderId;
	}
	public void setSelectSenderId(String selectSenderId) {
		this.selectSenderId = selectSenderId;
	}
}
