package com.noesis.domain.dto;

public class UserOptimizeDto {
	private String userName;
	private String id;
	private String userrole;
	public UserOptimizeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserOptimizeDto(String userName, String id, String userrole) {
		super();
		this.userName = userName;
		this.id = id;
		this.userrole = userrole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	@Override
	public String toString() {
		return "UserOptimizeDto [userName=" + userName + ", id=" + id + ", userrole=" + userrole + "]";
	}
	
		}
