package com.noesis.domain.dto;

public class SaveOrganisationForm {
	
	private String loggedInUserName;
	private String operation;
	private int orgId;
	private int userId;
	private String orgName;
	private String orgAddress;
	private String orgEmailId;
	private String orgGstNumber;
	private String orgContactNumber;
	private String orgStatus;
	private String orgBillingCycle;
	private String orgBillingType;
	private String orgPrimaryContact;
	
	
	public String getOrgPrimaryContact() {
		return orgPrimaryContact;
	}
	public void setOrgPrimaryContact(String orgPrimaryContact) {
		this.orgPrimaryContact = orgPrimaryContact;
	}
	public String getOrgBillingCycle() {
		return orgBillingCycle;
	}
	public void setOrgBillingCycle(String orgBillingCycle) {
		this.orgBillingCycle = orgBillingCycle;
	}
	public String getOrgBillingType() {
		return orgBillingType;
	}
	public void setOrgBillingType(String orgBillingType) {
		this.orgBillingType = orgBillingType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgAddress() {
		return orgAddress;
	}
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	public String getOrgEmailId() {
		return orgEmailId;
	}
	public void setOrgEmailId(String orgEmailId) {
		this.orgEmailId = orgEmailId;
	}
	public String getOrgGstNumber() {
		return orgGstNumber;
	}
	public void setOrgGstNumber(String orgGstNumber) {
		this.orgGstNumber = orgGstNumber;
	}
	public String getOrgContactNumber() {
		return orgContactNumber;
	}
	public void setOrgContactNumber(String orgContactNumber) {
		this.orgContactNumber = orgContactNumber;
	}
	public String getOrgStatus() {
		return orgStatus;
	}
	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}
	
	

}
