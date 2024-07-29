package com.noesis.domain.dto;

public class UpdateUserBlacklistNumberListForm {
	
	private String loggedInUserName;
	private String operation;
	private int id;
	private int userId;
	private String blackListNumber;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBlackListNumber() {
		return blackListNumber;
	}
	public void setBlackListNumber(String blackListNumber) {
		this.blackListNumber = blackListNumber;
	}
}
