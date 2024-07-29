package com.noesis.domain.dto;

public class SaveSenderIdFormResponseData {
	
	private String senderId;
	private String status;
	private String isDefault;
	private String isActive;
	private String isNonDndNumberAllowed;
	
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
	
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsNonDndNumberAllowed() {
		return isNonDndNumberAllowed;
	}
	public void setIsNonDndNumberAllowed(String isNonDndNumberAllowed) {
		this.isNonDndNumberAllowed = isNonDndNumberAllowed;
	}
}
