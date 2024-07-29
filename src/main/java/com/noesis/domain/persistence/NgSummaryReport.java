package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_summary_report", catalog = "genesis")
public class NgSummaryReport implements java.io.Serializable {
	
	private static final long serialVersionUID = -3962808326915235967L;
	private String userName;
	private String sequenceId;
	private Date date;
	private String totalRequest;
	private String submitted;
	private String rejected;
	private String delivered;
	private String failed;
	private String awaited;
	private String senderId;
	private Integer userId;
	private Integer paId;
	private Integer adId;
	private Integer saId;
	private Integer reId;
	private Integer seId;
	private Integer amId;
	
	public NgSummaryReport() {
		
	}
	
	public NgSummaryReport(String userName, String sequenceId, Date date, String totalRequest, 
			String submitted, String rejected, String delivered, String failed, String awaited, String senderId, Integer userId, Integer paId, Integer adId, Integer saId, Integer reId, int seId, Integer amId) {
		
		this.userName = userName;
		this.sequenceId = sequenceId;
		this.date = date;
		this.totalRequest = totalRequest;
		this.submitted = submitted;
		this.rejected = rejected;
		this.delivered = delivered;
		this.failed = failed;
		this.awaited = awaited;
		this.senderId = senderId;
		this.userId = userId;
		this.paId = paId;
		this.saId = saId;
		this.reId = reId;
		this.seId = seId;
		this.amId = amId;
	}
	
	@Column(name = "user_name", nullable = false, length = 50)
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sequence_id", nullable = false, length = 50)
	public String getSequenceId() {
		return this.sequenceId;
	}
	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}
	
	@Column(name = "date", nullable = false, length = 50)
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "total_request", nullable = false, length = 50)
	public String getTotalRequest() {
		return this.totalRequest;
	}
	public void setTotalRequest(String totalRequest) {
		this.totalRequest = totalRequest;
	}
	
	@Column(name = "submitted", nullable = false, length = 50)
	public String getSubmitted() {
		return this.submitted;
	}
	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
	
	@Column(name = "rejected", nullable = false, length = 50)
	public String getRejected() {
		return this.rejected;
	}
	public void setRejected(String rejected) {
		this.rejected = rejected;
	}
	
	@Column(name = "delivered", nullable = false, length = 50)
	public String getDelivered() {
		return this.delivered;
	}
	public void setDelivered(String delivered) {
		this.delivered = delivered;
	}
	
	@Column(name = "failed", nullable = false, length = 50)
	public String getFailed() {
		return this.failed;
	}
	public void setFailed(String failed) {
		this.failed = failed;
	}
	

	@Column(name = "awaited", nullable = false, length = 50)
	public String getAwaited() {
		return this.awaited;
	}
	public void setAwaited(String awaited) {
		this.awaited = awaited;
	}

	@Column(name = "sender_id", nullable = false, length = 50)
	public String getSenderId() {
		return this.senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	@Column(name = "user_id", nullable = false, length = 11)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "pa_id", nullable = false, length = 11)
	public Integer getPaId() {
		return this.paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}
	
	@Column(name = "ad_id", nullable = false, length = 11)
	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	
	@Column(name = "sa_id", nullable = false, length = 11)
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
	
	@Column(name = "am_id", length = 11)
	public Integer getAmId() {
		return this.amId;
	}

	public void setAmId(Integer amId) {
		this.amId = amId;
	}
}
