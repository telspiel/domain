package com.noesis.domain.dto;

import java.sql.Timestamp;

public interface DetailedMISQueryDTO {

	Timestamp getReceivedTs();
	
	String getMessageId();

	int getUserId();

	String getStatus();

	Timestamp getSentTs();

	String getMobileNumber();

	String getSenderId();

	String getErrorCode();
	
	String getStatusId();
	
	String getStatusDesc();
	
	String getDeliveredTs();
	
}
