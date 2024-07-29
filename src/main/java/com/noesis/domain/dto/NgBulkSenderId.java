package com.noesis.domain.dto;

public class NgBulkSenderId {
	private String loggedInUserName;
	private String operation;
	private int userId;
	private String senderIdType;
	private String senderIdSubType;
	private String status;
	private String defaultSenderId;
	private String entityId;
	private String headerId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSenderIdType() {
		return senderIdType;
	}
	public void setSenderIdType(String senderIdType) {
		this.senderIdType = senderIdType;
	}
	public String getSenderIdSubType() {
		return senderIdSubType;
	}
	public void setSenderIdSubType(String senderIdSubType) {
		this.senderIdSubType = senderIdSubType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDefaultSenderId() {
		return defaultSenderId;
	}
	public void setDefaultSenderId(String defaultSenderId) {
		this.defaultSenderId = defaultSenderId;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getHeaderId() {
		return headerId;
	}
	public void setHeaderId(String headerId) {
		this.headerId = headerId;
	}
	public NgBulkSenderId(String loggedInUserName, String operation, int userId, String senderIdType,
			String senderIdSubType, String status, String defaultSenderId, String entityId, String headerId) {
		super();
		this.loggedInUserName = loggedInUserName;
		this.operation = operation;
		this.userId = userId;
		this.senderIdType = senderIdType;
		this.senderIdSubType = senderIdSubType;
		this.status = status;
		this.defaultSenderId = defaultSenderId;
		this.entityId = entityId;
		this.headerId = headerId;
	}
	public NgBulkSenderId() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NgBulkSenderId [loggedInUserName=" + loggedInUserName + ", operation=" + operation + ", userId="
				+ userId + ", senderIdType=" + senderIdType + ", senderIdSubType=" + senderIdSubType + ", status="
				+ status + ", defaultSenderId=" + defaultSenderId + ", entityId=" + entityId + ", headerId=" + headerId
				+ "]";
	}
	
	}
