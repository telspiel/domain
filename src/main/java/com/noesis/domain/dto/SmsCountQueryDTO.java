package com.noesis.domain.dto;

public interface SmsCountQueryDTO{
	
	int getTotalSmsToday();
	
	int getTotalSmsWeek();
	
	int getTotalSmsMonth();
	
	int getTotalSmsTwoMonths();
	
}
