package com.noesis.domain.dto;

public class UpdateAvailableCreditForm {
	
	private String loggedInUserName;
	private String operation;
	private int orgId;
	private int deptId;
	private int userId;
	private int creditToBeAdded;
	
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
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCreditToBeAdded() {
		return creditToBeAdded;
	}
	public void setCreditToBeAdded(int creditToBeAdded) {
		this.creditToBeAdded = creditToBeAdded;
	}
	
	

}