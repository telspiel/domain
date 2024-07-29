package com.noesis.domain.dto;

public class ViewSenderIdFormResponseList {
	
	private String senderId;
	private char status;
	private char isDefault;
	private char isNonDndNumberAllowed;
	
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public char getIsDefault() {
		return isDefault;
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
