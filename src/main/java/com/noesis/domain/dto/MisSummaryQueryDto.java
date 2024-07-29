package com.noesis.domain.dto;

public interface MisSummaryQueryDto {

	String getUserName();
	
	String getSummaryDate();
	
	String getSenderId();
	
	Integer getTotalRequest();
	
	Integer getTotalSubmitted();
	
	Integer getTotalRejected();
	
	Integer getTotalDelivered();
	
	Integer getTotalFailed();
	
	Integer getTotalAwaited();
}