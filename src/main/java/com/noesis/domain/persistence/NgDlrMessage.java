package com.noesis.domain.persistence;
// Generated 25 Sep, 2018 10:08:27 PM by Hibernate Tools 4.3.5.Final

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
 * NgDlrCurrDate generated by hbm2java
 */
@Entity
@Table(name = "ng_dlr_curr_date", catalog = "genesis")
public class NgDlrMessage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String messageId;
	private String ackId;
	private int userId;
	private String mobileNumber;
	private Date receivedTs;
	private Date deliveredTs;
	private String statusId;
	private String statusDesc;
	private String errorCode;
	private String errorDesc;
	private Integer carrierId;
	private String senderId;
	private Integer circleId;
	private Integer routeId;
	private String messageSource;
	private String originalStatus;
	private String customStatus;
	private String dlrType;
	private String dlrReceipt;
	private String expiry;
	private String smscId;
	private Integer failedRetryCount;
	private String operatorErrorCode;
	private String operatorErrorDesc;

	private Date retryTimeStamp;
	private char isDelivered;
	private char retryStatus;
	private int retryCount;
//	// start
//	@Column(name = "split_count")
//	private String splitCount;
//   // end
	public NgDlrMessage() {
	}

	public NgDlrMessage(String messageId, int userId, String mobileNumber, Date receivedTs, Date deliveredTs,
			String messageSource, String originalStatus, String customStatus, Integer failedRetryCount) {
		this.messageId = messageId;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.receivedTs = receivedTs;
		this.deliveredTs = deliveredTs;
		this.messageSource = messageSource;
		this.originalStatus = originalStatus;
		this.customStatus = customStatus;
		this.failedRetryCount = failedRetryCount;
	}

	public NgDlrMessage(String messageId, String ackId, int userId, String mobileNumber, Date receivedTs,
			Date deliveredTs, String statusId, String statusDesc, String errorCode, String errorDesc, Integer carrierId,
			String senderId, Integer circleId, Integer routeId, String messageSource, String originalStatus,
			String customStatus, String dlrType, String dlrReceipt, String expiry, String smscId,
			Integer failedRetryCount, String operatorErrorCode, String operatorErrorDesc) {
		this.messageId = messageId;
		this.ackId = ackId;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.receivedTs = receivedTs;
		this.deliveredTs = deliveredTs;
		this.statusId = statusId;
		this.statusDesc = statusDesc;
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
		this.carrierId = carrierId;
		this.senderId = senderId;
		this.circleId = circleId;
		this.routeId = routeId;
		this.messageSource = messageSource;
		this.originalStatus = originalStatus;
		this.customStatus = customStatus;
		this.dlrType = dlrType;
		this.dlrReceipt = dlrReceipt;
		this.expiry = expiry;
		this.smscId = smscId;
		this.failedRetryCount = failedRetryCount;
		this.operatorErrorCode = operatorErrorCode;
		this.operatorErrorDesc = operatorErrorDesc;
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

	@Column(name = "message_id", nullable = false, length = 50)
	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Column(name = "ack_id", length = 50)
	public String getAckId() {
		return this.ackId;
	}

	public void setAckId(String ackId) {
		this.ackId = ackId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "mobile_number", nullable = false, length = 50)
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "received_ts", nullable = false, length = 19)
	public Date getReceivedTs() {
		return this.receivedTs;
	}

	public void setReceivedTs(Date receivedTs) {
		this.receivedTs = receivedTs;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivered_ts", nullable = false, length = 19)
	public Date getDeliveredTs() {
		return this.deliveredTs;
	}

	public void setDeliveredTs(Date deliveredTs) {
		this.deliveredTs = deliveredTs;
	}

	@Column(name = "status_id", length = 50)
	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	@Column(name = "status_desc", length = 100)
	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	@Column(name = "error_code", length = 20)
	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Column(name = "error_desc", length = 50)
	public String getErrorDesc() {
		return this.errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	@Column(name = "carrier_id")
	public Integer getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(Integer carrierId) {
		this.carrierId = carrierId;
	}

	@Column(name = "sender_id")
	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@Column(name = "circle_id")
	public Integer getCircleId() {
		return this.circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	@Column(name = "route_id")
	public Integer getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	@Column(name = "message_source", nullable = false, length = 50)
	public String getMessageSource() {
		return this.messageSource;
	}

	public void setMessageSource(String messageSource) {
		this.messageSource = messageSource;
	}

	@Column(name = "original_status", nullable = false, length = 45)
	public String getOriginalStatus() {
		return this.originalStatus;
	}

	public void setOriginalStatus(String originalStatus) {
		this.originalStatus = originalStatus;
	}

	@Column(name = "custom_status", nullable = false, length = 45)
	public String getCustomStatus() {
		return this.customStatus;
	}

	public void setCustomStatus(String customStatus) {
		this.customStatus = customStatus;
	}

	@Column(name = "dlr_type", length = 45)
	public String getDlrType() {
		return this.dlrType;
	}

	public void setDlrType(String dlrType) {
		this.dlrType = dlrType;
	}

	@Column(name = "dlr_receipt", length = 1000)
	public String getDlrReceipt() {
		return this.dlrReceipt;
	}

	public void setDlrReceipt(String dlrReceipt) {
		this.dlrReceipt = dlrReceipt;
	}

	@Column(name = "expiry", length = 45)
	public String getExpiry() {
		return this.expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Column(name = "smsc_id")
	public String getSmscId() {
		return this.smscId;
	}

	public void setSmscId(String smscId) {
		this.smscId = smscId;
	}

	@Column(name = "failed_retry_count", nullable = false)
	public Integer getFailedRetryCount() {
		return this.failedRetryCount;
	}

	public void setFailedRetryCount(Integer failedRetryCount) {
		this.failedRetryCount = failedRetryCount;
	}

	@Column(name = "operator_error_code")
	public String getOperatorErrorCode() {
		return operatorErrorCode;
	}

	public void setOperatorErrorCode(String operatorErrorCode) {
		this.operatorErrorCode = operatorErrorCode;
	}

	@Column(name = "operator_error_desc")
	public String getOperatorErrorDesc() {
		return operatorErrorDesc;
	}

	public void setOperatorErrorDesc(String operatorErrorDesc) {
		this.operatorErrorDesc = operatorErrorDesc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "retry_timestamp", length = 19)
	public Date getRetryTimeStamp() {
		return retryTimeStamp;
	}

	public void setRetryTimeStamp(Date retryTimeStamp) {
		this.retryTimeStamp = retryTimeStamp;
	}

	@Column(name = "is_delivered", length = 1)
	public char getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(char isDelivered) {
		this.isDelivered = isDelivered;
	}

	@Column(name = "retry_status", length = 1)
	public char getRetryStatus() {
		return retryStatus;
	}

	public void setRetryStatus(char retryStatus) {
		this.retryStatus = retryStatus;
	}

	@Column(name = "retry_count")
	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
   
}
