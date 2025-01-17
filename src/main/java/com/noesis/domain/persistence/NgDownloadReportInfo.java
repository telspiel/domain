package com.noesis.domain.persistence;
// Generated 10 Feb, 2019 3:25:34 PM by Hibernate Tools 5.0.6.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * NgDownloadReportInfo generated by hbm2java
 */
@Entity
@Table(name = "ng_download_report_info", catalog = "genesis")
public class NgDownloadReportInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer userId;
	
	private Date createdDate;
	
	private String fromDate;
	
	private String toDate;
	
	private char status;
	
	private String serverFileName;
	
	private Integer campaignId = 0;
	
	private String campaignName;
	private String fileType;
	


	public NgDownloadReportInfo() {
	}

	public NgDownloadReportInfo(char status) {
		this.status = status;
	}

	public NgDownloadReportInfo(Integer userId, Date createdDate, String fromDate, String toDate, char status,
			String serverFileName, String fileType) {
		super();
		this.userId = userId;
		this.createdDate = createdDate;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.serverFileName = serverFileName;
		this.fileType = fileType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	@Column(name = "server_file_name", length = 250)
	public String getServerFileName() {
		return this.serverFileName;
	}

	public void setServerFileName(String serverFileName) {
		this.serverFileName = serverFileName;
	}

	@Column(name = "from_date", length = 250)
	public String getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "to_date")
	public String getToDate() {
		return this.toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	@Column(name = "campaign_id")
	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * @return the campaignName
	 */
	@Column(name = "campaign_name")
	public String getCampaignName() {
		return campaignName;
	}

	/**
	 * @param campaignName the campaignName to set
	 */
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	@Column(name = "file_type")
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}
