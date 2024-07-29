package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_mis_summery_hour", catalog = "genesis")
public class NgMisHourlySummaryReport implements java.io.Serializable {
	
	private static final long serialVersionUID = -3962808326915235967L;
	private int id;
	private String userName;
	private Integer hour;
	private String totalRequest;
	private String totalSubmit;
	private String totalRejected;
	private String totalDelivered;
	private String totalFailed;
	private String totalAwaited;
	private int paId;
	private int saId;
	private int adId;
	private int reId;
	private int seId;
	private int amId;
	
	public NgMisHourlySummaryReport() {
		
	}
	
	public NgMisHourlySummaryReport(int id, String userName, String sequenceId, Date date, String totalRequest, 
			String submitted, String rejected, String delivered, String failed, String awaited, Integer hour, int paId, int saId, 
			int adId, int reId, int seId, int amId) {
		this.id = id;
		this.userName = userName;
		this.hour = hour;
		this.totalRequest = totalRequest;
		this.totalSubmit = submitted;
		this.totalRejected = rejected;
		this.totalDelivered = delivered;
		this.totalFailed = failed;
		this.totalAwaited = awaited;
		this.paId = paId;
		this.saId = saId;
		this.adId = adId;
		this.reId = reId;
		this.seId = seId;
		this.amId = amId;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "user_name", nullable = false, length = 50)
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "hour", nullable = false, length = 50)
	public Integer getHour() {
		return this.hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	
	@Column(name = "total_request", nullable = false, length = 50)
	public String getTotalRequest() {
		return this.totalRequest;
	}
	public void setTotalRequest(String totalRequest) {
		this.totalRequest = totalRequest;
	}
	
	@Column(name = "total_submit", nullable = false, length = 50)
	public String getTotalSubmit() {
		return this.totalSubmit;
	}
	public void setTotalSubmit(String totalSubmit) {
		this.totalSubmit = totalSubmit;
	}

	@Column(name = "total_rejected", nullable = false, length = 50)
	public String getTotalRejected() {
		return totalRejected;
	}

	public void setTotalRejected(String totalRejected) {
		this.totalRejected = totalRejected;
	}

	@Column(name = "total_delivered", nullable = false, length = 50)
	public String getTotalDelivered() {
		return totalDelivered;
	}

	public void setTotalDelivered(String totalDelivered) {
		this.totalDelivered = totalDelivered;
	}

	@Column(name = "total_failed", nullable = false, length = 50)
	public String getTotalFailed() {
		return totalFailed;
	}

	public void setTotalFailed(String totalFailed) {
		this.totalFailed = totalFailed;
	}

	@Column(name = "total_awaited", nullable = false, length = 50)
	public String getTotalAwaited() {
		return totalAwaited;
	}

	public void setTotalAwaited(String totalAwaited) {
		this.totalAwaited = totalAwaited;
	}
	
	@Column(name = "pa_id", nullable = false, length = 11)
	public int getPaId() {
		return paId;
	}

	public void setPaId(int paId) {
		this.paId = paId;
	}
	
	@Column(name = "sa_id", nullable = false, length = 11)
	public int getSaId() {
		return saId;
	}

	public void setSaId(int saId) {
		this.saId = saId;
	}
	
	@Column(name = "ad_id", nullable = false, length = 11)
	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}
	
	@Column(name = "re_id", nullable = false, length = 11)
	public int getReId() {
		return reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}
	
	@Column(name = "se_id", nullable = false, length = 11)
	public int getSeId() {
		return seId;
	}

	public void setSeId(int seId) {
		this.seId = seId;
	}
	
	@Column(name = "am_id", nullable = false, length = 11)
	public int getAmId() {
		return amId;
	}

	public void setAmId(int amId) {
		this.amId = amId;
	}
}
