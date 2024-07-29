package com.noesis.domain.dto;

public interface AdminDataQueryDTO {
	
	String getUsername();
	
	int getTotalSubmit();
	
	int getTotalDelivered();
	
	int getTotalFailed();
	
	int getAvailableCredits();
	

}
