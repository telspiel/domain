package com.noesis.domain.dto;

public interface ConnectSummaryQueryDto {

	Integer getId();
	
	java.util.Date getReceiveDate();
	
	String getConnectName();
	
	Integer getTotalSubmit();
	
	Integer getDelivered();
	
	Integer getFailed();
}