package com.noesis.domain.dto;

public class DashboardFormData {

	private Long totalSmsToday;
	private Long totalSmsWeek;
	private Long totalSmsMonth;
	private Long totalSmsTwoMonths;
	private Integer availableCredits;
	private Integer effectiveCredits;
	
	public Long getTotalSmsToday() {
		return totalSmsToday;
	}
	public void setTotalSmsToday(Long totalSmsToday) {
		this.totalSmsToday = totalSmsToday;
	}
	public Long getTotalSmsWeek() {
		return totalSmsWeek;
	}
	public void setTotalSmsWeek(Long totalSmsWeek) {
		this.totalSmsWeek = totalSmsWeek;
	}
	public Long getTotalSmsMonth() {
		return totalSmsMonth;
	}
	public void setTotalSmsMonth(Long totalSmsMonth) {
		this.totalSmsMonth = totalSmsMonth;
	}
	public Long getTotalSmsTwoMonths() {
		return totalSmsTwoMonths;
	}
	public void setTotalSmsTwoMonths(Long totalSmsTwoMonths) {
		this.totalSmsTwoMonths = totalSmsTwoMonths;
	}
	public Integer getAvailableCredits() {
		return availableCredits;
	}
	public void setAvailableCredits(Integer availableCredits) {
		this.availableCredits = availableCredits;
	}
	public Integer getEffectiveCredits() {
		return effectiveCredits;
	}
	public void setEffectiveCredits(Integer effectiveCredits) {
		this.effectiveCredits = effectiveCredits;
	}
	
		
}
