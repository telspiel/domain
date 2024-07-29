package com.noesis.domain.dto;

public interface ConnectSenderIdSummaryQueryDto {

	Integer getId();
	
	java.util.Date getReceiveDate();
	
	String getUserName();
	
	String getConnectName();
	
	String getSenderId();
	
	Integer getTotalSubmit();
	
	Integer getDelivered();
	
	Integer getFailed();
}