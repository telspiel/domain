package com.noesis.domain.dto;

public class SenderIdMisFormResponseDataGrid {
	
	private String summaryDate;
	private String senderId;
	private String totalRequest;
	private String totalRejected;
	private String totalSubmit;
	private String totalDelivered;
	private String totalFailed;
	private String totalAwaited;
	
	public String getSummaryDate() {
		return summaryDate;
	}
	public void setSummaryDate(String summaryDate) {
		this.summaryDate = summaryDate;
	}
	public String getTotalRequest() {
		return totalRequest;
	}
	public void setTotalRequest(String totalRequest) {
		this.totalRequest = totalRequest;
	}
	public String getTotalRejected() {
		return totalRejected;
	}
	public void setTotalRejected(String totalRejected) {
		this.totalRejected = totalRejected;
	}
	public String getTotalSubmit() {
		return totalSubmit;
	}
	public void setTotalSubmit(String totalSubmit) {
		this.totalSubmit = totalSubmit;
	}
	public String getTotalDelivered() {
		return totalDelivered;
	}
	public void setTotalDelivered(String totalDelivered) {
		this.totalDelivered = totalDelivered;
	}
	public String getTotalFailed() {
		return totalFailed;
	}
	public void setTotalFailed(String totalFailed) {
		this.totalFailed = totalFailed;
	}
	public String getTotalAwaited() {
		return totalAwaited;
	}
	public void setTotalAwaited(String totalAwaited) {
		this.totalAwaited = totalAwaited;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	

}
