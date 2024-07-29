package com.noesis.domain.dto;

public class ViewOrganisationForm {
	
	private String loggedInUserName;
	private int orgId;
	private String operation;
	
	
	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

}
