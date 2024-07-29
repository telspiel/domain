package com.noesis.domain.dto;

public class SaveSenderIdForm {
	
	private String loggedInUserName;
	private String operation;
	private int orgId;
	private int deptId;
	private int userId;
	private String senderId;
	private String status;
	private char isDefault;
	private char isActive;
	private char isNonDndNumberAllowed;
	
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
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public char getIsDefault() {
		return isDefault;
	}
	public void setDefault(char isDefault) {
		this.isDefault = isDefault;
	}
	public char getIsActive() {
		return isActive;
	}
	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}
	public void setIsDefault(char isDefault) {
		this.isDefault = isDefault;
	}
	public char getIsNonDndNumberAllowed() {
		return isNonDndNumberAllowed;
	}
	public void setIsNonDndNumberAllowed(char isNonDndNumberAllowed) {
		this.isNonDndNumberAllowed = isNonDndNumberAllowed;
	}
}
