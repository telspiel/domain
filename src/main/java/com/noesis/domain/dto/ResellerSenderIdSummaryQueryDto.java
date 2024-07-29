package com.noesis.domain.dto;

public interface ResellerSenderIdSummaryQueryDto {

	Integer getId();
	
	String getSummaryDate();
	
	Integer getTotalRequest();
	
	Integer getTotalSubmitted();
	
	Integer getTotalRejected();
	
	Integer getTotalDelivered();
	
	Integer getTotalFailed();
	
	Integer getTotalAwaited();
	
	String getSenderId();
	
	String getUserName();
}