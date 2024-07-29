package com.noesis.domain.dto;

public class GroupIdAndName {
	private String groupName;
	private String id;
	public GroupIdAndName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupIdAndName(String groupName, String id) {
		super();
		this.groupName = groupName;
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "GroupIdAndName [groupName=" + groupName + ", id=" + id + "]";
	}
	
	

}
