package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_connect_summery_all", catalog = "genesis")
public class NgConnectSummeryAll implements java.io.Serializable {
	
	private static final long serialVersionUID = -3962808326915235967L;
	
	private int id;
	private Date receiveDate;
	private String userName;
	private int userId;
	private int kannelId;
	private String smscId;
	private String senderId;
	private int carrierId;
	private int circleId;
	private BigInteger submitCnt;
	private Double dlvrdCnt;
	private Double failCnt;
	private Integer paId;
	private Integer adId;
	private Integer saId;
	private Integer reId;
	private Integer seId;
		
	public NgConnectSummeryAll() {
		
	}
	
	public NgConnectSummeryAll(int id, Date receiveDate, String userName, int userId, int kannelId, String smscId, String senderId,
			int carrierId, int circleId, BigInteger submitCnt, Double dlvrdCnt, Double failCnt, Integer paId, Integer saId, 
			Integer adId, Integer reId, Integer seId) {
		
		this.id = id;
		this.receiveDate = receiveDate;
		this.userName = userName;
		this.userId = userId;
		this.kannelId = kannelId;
		this.smscId = smscId;
		this.senderId = senderId;
		this.carrierId = carrierId;
		this.circleId = circleId;
		this.submitCnt = submitCnt;
		this.dlvrdCnt = dlvrdCnt;
		this.failCnt = failCnt;
		this.paId = paId;
		this.saId = saId;
		this.adId = adId;
		this.reId = reId;
		this.seId = seId;
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
	
	@Column(name = "receive_date", nullable = false, length = 50)
	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	
	@Column(name = "user_name", nullable = false, length = 50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "user_id", nullable = false, length = 11)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "kannel_id", nullable = false, length = 11)
	public int getKannelId() {
		return kannelId;
	}

	public void setKannelId(int kannelId) {
		this.kannelId = kannelId;
	}
	
	@Column(name = "smsc_id", nullable = false, length = 250)
	public String getSmscId() {
		return smscId;
	}

	public void setSmscId(String smscId) {
		this.smscId = smscId;
	}
	
	@Column(name = "sender_id", nullable = false, length = 20)
	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	@Column(name = "carrier_id", nullable = false, length = 11)
	public int getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}	
	
	@Column(name = "circle_id", nullable = false, length = 11)
	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	
	@Column(name = "submit_cnt", nullable = false, length = 20)
	public BigInteger getSubmitCnt() {
		return submitCnt;
	}

	public void setSubmitCnt(BigInteger submitCnt) {
		this.submitCnt = submitCnt;
	}
	
	@Column(name = "dlvrd_cnt", nullable = false, length = 20)
	public Double getDlvrdCnt() {
		return dlvrdCnt;
	}

	public void setDlvrdCnt(Double dlvrdCnt) {
		this.dlvrdCnt = dlvrdCnt;
	}
	
	@Column(name = "fail_cnt", nullable = false, length = 20)
	public Double getFailCnt() {
		return failCnt;
	}

	public void setFailCnt(Double failCnt) {
		this.failCnt = failCnt;
	}

	@Column(name = "pa_id", length = 11)
	public Integer getPaId() {
		return paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}
	
	@Column(name = "ad_id", length = 11)
	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}


	@Column(name = "sa_id", length = 11)
	public Integer getSaId() {
		return saId;
	}

	public void setSaId(Integer saId) {
		this.saId = saId;
	}
	
	@Column(name = "re_id", length = 11)
	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	@Column(name = "se_id", length = 11)
	public Integer getSeId() {
		return seId;
	}

	public void setSeId(Integer seId) {
		this.seId = seId;
	}
	
}
