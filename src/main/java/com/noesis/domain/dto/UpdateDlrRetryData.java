package com.noesis.domain.dto;

import java.util.Date;

public class UpdateDlrRetryData {

	private String messageId;
	private Date retryTimeStamp;
	private char isDelivered;
	private char retryStatus;
	private int retryCount;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Date getRetryTimeStamp() {
		return retryTimeStamp;
	}

	public void setRetryTimeStamp(Date timestamp) {
		this.retryTimeStamp = timestamp;
	}

	public char getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(char isDelivered) {
		this.isDelivered = isDelivered;
	}

	public char getRetryStatus() {
		return retryStatus;
	}

	public void setRetryStatus(char retryStatus) {
		this.retryStatus = retryStatus;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

}
