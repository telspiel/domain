package com.noesis.domain.dto;

public class SaveDepartmentForm {
	
	private String loggedInUserName;
	private String operation;
	private int deptId;
	private int orgId;
	private String deptName;
	private String deptEmailId;
	private String deptContactNumber;
	private String deptStatus;

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
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptEmailId() {
		return deptEmailId;
	}
	public void setDeptEmailId(String deptEmailId) {
		this.deptEmailId = deptEmailId;
	}
	public String getDeptContactNumber() {
		return deptContactNumber;
	}
	public void setDeptContactNumber(String deptContactNumber) {
		this.deptContactNumber = deptContactNumber;
	}
	public String getDeptStatus() {
		return deptStatus;
	}
	public void setDeptStatus(String deptStatus) {
		this.deptStatus = deptStatus;
	}
	
	

}
