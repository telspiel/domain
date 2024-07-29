package com.noesis.domain.dto;

import java.math.BigDecimal;

public class AdminDashboardFormResponseDataGrid {
	
	private String username;
	private BigDecimal totalSubmit;
	private BigDecimal totalDelivered;
	private BigDecimal totalFailed;
	private BigDecimal totalRejected;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BigDecimal getTotalSubmit() {
		return totalSubmit;
	}
	public void setTotalSubmit(BigDecimal totalSubmit) {
		this.totalSubmit = totalSubmit;
	}
	public BigDecimal getTotalDelivered() {
		return totalDelivered;
	}
	public void setTotalDelivered(BigDecimal totalDelivered) {
		this.totalDelivered = totalDelivered;
	}
	public BigDecimal getTotalFailed() {
		return totalFailed;
	}
	public void setTotalFailed(BigDecimal totalFailed) {
		this.totalFailed = totalFailed;
	}
	public BigDecimal gettotalRejected() {
		return totalRejected;
	}
	public void settotalRejected(BigDecimal totalRejected) {
		this.totalRejected = totalRejected;
	}
	
}
