package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_campaign_report", catalog = "genesis")
public class NgCampaignReport implements java.io.Serializable {
	
	private static final long serialVersionUID = -3962808326915235967L;
	private String sequenceId;
	private String userName;
	private Date date;
	private String campaignName;
	private String senderId;
	private int campaignId;
	private String totalRequest;
	private String submitted;
	private String rejected;
	private String delivered;
	private String failed;
	private String awaited;
	private int totalClicks;
	private Integer paId;
	private Integer adId;
	private Integer saId;
	private Integer reId;
	private Integer seId;
	private int userId;
	private String scheduleDate;
	private String scheduleTime;
	private String messageText;
	
	public NgCampaignReport() {
		
	}
	
	public NgCampaignReport(String sequenceId, String userName, Date date, String campaignName, String senderId,
			String totalRequest, String submitted, String rejected, String delivered, String failed, String awaited, int totalClicks,
			Integer paId, Integer saId, Integer adId, Integer reId, Integer seId, int campaignId, int userId, String scheduleTime,String scheduleDate) {
		
		this.sequenceId = sequenceId;
		this.userName = userName;
		this.date = date;
		this.campaignName = campaignName;
		this.senderId = senderId;
		this.totalRequest = totalRequest;
		this.submitted = submitted;
		this.rejected = rejected;
		this.delivered = delivered;
		this.failed = failed;
		this.awaited = awaited;
		this.totalClicks = totalClicks;
		this.paId = paId;
		this.saId = saId;
		this.adId = adId;
		this.reId = reId;
		this.seId = seId;
		this.campaignId = campaignId;
		this.userId = userId;
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sequence_id", unique = true, nullable = false, length = 11)
	public String getSequenceId() {
		return this.sequenceId;
	}
	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}
	
	@Column(name = "user_name", nullable = false, length = 11)
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "date", nullable = false, length = 50)
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "campaign_name", nullable = false, length = 250)
	public String getCampaignName() {
		return this.campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	@Column(name = "sender_id", nullable = false, length = 250)
	public String getSenderId() {
		return this.senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	@Column(name = "total_request", nullable = false, length = 20)
	public String getTotalRequest() {
		return this.totalRequest;
	}
	public void setTotalRequest(String totalRequest) {
		this.totalRequest = totalRequest;
	}
	
	@Column(name = "submitted", nullable = false, length = 20)
	public String getSubmitted() {
		return this.submitted;
	}
	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
	
	@Column(name = "rejected", nullable = false, length = 20)
	public String getRejected() {
		return this.rejected;
	}
	public void setRejected(String rejected) {
		this.rejected = rejected;
	}
	
	@Column(name = "delivered", nullable = false, length = 20)
	public String getDelivered() {
		return this.delivered;
	}
	public void setDelivered(String delivered) {
		this.delivered = delivered;
	}
	
	@Column(name = "failed", nullable = false, length = 20)
	public String getFailed() {
		return this.failed;
	}
	public void setFailed(String failed) {
		this.failed = failed;
	}
	
	@Column(name = "awaited", nullable = false, length = 20)
	public String getAwaited() {
		return this.awaited;
	}
	public void setAwaited(String awaited) {
		this.awaited = awaited;
	}
	
	@Column(name = "total_clicks", nullable = false, length = 2000)
	public int getTotalClicks() {
		return this.totalClicks;
	}
	public void setTotalClicks(int totalClicks) {
		this.totalClicks = totalClicks;
	}

	@Column(name = "pa_id", length = 11)
	public Integer getPaId() {
		return this.paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}
	
	@Column(name = "ad_id", length = 11)
	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	@Column(name = "sa_id", length = 11)
	public Integer getSaId() {
		return this.saId;
	}

	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	@Column(name = "re_id", length = 11)
	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	@Column(name = "se_id", length = 11)
	public Integer getSeId() {
		return this.seId;
	}

	public void setSeId(Integer seId) {
		this.seId = seId;
	}

	@Column(name = "campaign_id", length = 11)
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	@Column(name = "user_id", length = 11)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name = "schedule_date")
	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	@Column(name = "schedule_time")
	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	@Column(name = "message_text", nullable = false, length = 10000)
	public String getMessageText() {
		return this.messageText;
	}
}
