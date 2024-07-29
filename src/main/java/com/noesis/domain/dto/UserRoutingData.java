package com.noesis.domain.dto;

public class UserRoutingData {
	//private Map<String, Integer> circleMap;
	//private Map<String, Integer> operatoreMap;
	//private Map<String, Integer> senderIdMap;
	//private Map<String, Integer> groupMap;
	//private String routingType;
	private String circle;
	private String operator;
	private String senderId;
	private String groupName;
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/*public String getRoutingType() {
		return routingType;
	}
	public void setRoutingType(String routingType) {
		this.routingType = routingType;
	}*/
	
	
	
		

}
