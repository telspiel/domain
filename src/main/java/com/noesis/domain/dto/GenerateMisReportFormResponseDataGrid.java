package com.noesis.domain.dto;

public class GenerateMisReportFormResponseDataGrid {
	//private String seqNo;
	private String fromDate;
	private String toDate; 
	private String status;
	private String downloadReportLink;
	private String campaignName;
	private int campaignId;
	/*public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}*/
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDownloadReportLink() {
		return downloadReportLink;
	}
	public void setDownloadReportLink(String downloadReportLink) {
		this.downloadReportLink = downloadReportLink;
	}
	/**
	 * @return the campaignName
	 */
	public String getCampaignName() {
		return campaignName;
	}
	/**
	 * @param campaignName the campaignName to set
	 */
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
		
	
	
}
