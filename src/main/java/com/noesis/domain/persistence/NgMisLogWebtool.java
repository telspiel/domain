package com.noesis.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_mis_log_webtool", catalog = "genesis")
public class NgMisLogWebtool implements java.io.Serializable {
	
	private static final long serialVersionUID = -3962808326915235967L;
	private String messageId;
	private String userName;
	private String mobileNumber;
	private String senderId;
	private String subStatus;
	private String messageText;
	private Date receivedTs;
	private Date deliveredTs;
	private String deliveryStat;
	private String errorCode;
	private String errorDesc;

	public NgMisLogWebtool() {
	}

	public NgMisLogWebtool(String messageId, String mobileNumber, String messageText, Date receivedTs) {
		this.messageId = messageId;
		this.mobileNumber = mobileNumber;
		this.messageText = messageText;
		this.receivedTs = receivedTs;
	}

	public NgMisLogWebtool(String messageId, String userName, String mobileNumber, String senderId, String subStatus,
			String messageText, Date receivedTs, Date deliveredTs, String deliveryStat, String errorCode,
			String errorDesc) {
		this.messageId = messageId;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.senderId = senderId;
		this.subStatus = subStatus;
		this.messageText = messageText;
		this.receivedTs = receivedTs;
		this.deliveredTs = deliveredTs;
		this.deliveryStat = deliveryStat;
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	@Id
	@Column(name = "message_id", nullable = false, length = 50)
	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Column(name = "user_name", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "mobile_number", nullable = false, length = 20)
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "sender_id", length = 10)
	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@Column(name = "sub_status", length = 11)
	public String getSubStatus() {
		return this.subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	@Column(name = "message_text", nullable = false, length = 10000)
	public String getMessageText() {
		return this.messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	@Column(name = "received_ts", nullable = false, length = 19)
	public Date getReceivedTs() {
		return this.receivedTs;
	}

	public void setReceivedTs(Date receivedTs) {
		this.receivedTs = receivedTs;
	}

	@Column(name = "delivered_ts", length = 19)
	public Date getDeliveredTs() {
		return this.deliveredTs;
	}

	public void setDeliveredTs(Date deliveredTs) {
		this.deliveredTs = deliveredTs;
	}

	@Column(name = "delivery_stat", length = 9)
	public String getDeliveryStat() {
		return this.deliveryStat;
	}

	public void setDeliveryStat(String deliveryStat) {
		this.deliveryStat = deliveryStat;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NgMisLog))
			return false;
		NgMisLog castOther = (NgMisLog) other;

		return ((this.getMessageId() == castOther.getMessageId()) || (this.getMessageId() != null
				&& castOther.getMessageId() != null && this.getMessageId().equals(castOther.getMessageId())))
				&& ((this.getUserName() == castOther.getUserName()) || (this.getUserName() != null
						&& castOther.getUserName() != null && this.getUserName().equals(castOther.getUserName())))
				&& ((this.getMobileNumber() == castOther.getMobileNumber())
						|| (this.getMobileNumber() != null && castOther.getMobileNumber() != null
								&& this.getMobileNumber().equals(castOther.getMobileNumber())))
				&& ((this.getSenderId() == castOther.getSenderId()) || (this.getSenderId() != null
						&& castOther.getSenderId() != null && this.getSenderId().equals(castOther.getSenderId())))
				&& ((this.getSubStatus() == castOther.getSubStatus()) || (this.getSubStatus() != null
						&& castOther.getSubStatus() != null && this.getSubStatus().equals(castOther.getSubStatus())))
				&& ((this.getMessageText() == castOther.getMessageText())
						|| (this.getMessageText() != null && castOther.getMessageText() != null
								&& this.getMessageText().equals(castOther.getMessageText())))
				&& ((this.getReceivedTs() == castOther.getReceivedTs()) || (this.getReceivedTs() != null
						&& castOther.getReceivedTs() != null && this.getReceivedTs().equals(castOther.getReceivedTs())))
				&& ((this.getDeliveredTs() == castOther.getDeliveredTs())
						|| (this.getDeliveredTs() != null && castOther.getDeliveredTs() != null
								&& this.getDeliveredTs().equals(castOther.getDeliveredTs())))
				&& ((this.getDeliveryStat() == castOther.getDeliveryStat())
						|| (this.getDeliveryStat() != null && castOther.getDeliveryStat() != null
								&& this.getDeliveryStat().equals(castOther.getDeliveryStat())))
				&& ((this.getErrorCode() == castOther.getErrorCode()) || (this.getErrorCode() != null
						&& castOther.getErrorCode() != null && this.getErrorCode().equals(castOther.getErrorCode())))
				&& ((this.getErrorDesc() == castOther.getErrorDesc()) || (this.getErrorDesc() != null
						&& castOther.getErrorDesc() != null && this.getErrorDesc().equals(castOther.getErrorDesc())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMessageId() == null ? 0 : this.getMessageId().hashCode());
		result = 37 * result + (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37 * result + (getMobileNumber() == null ? 0 : this.getMobileNumber().hashCode());
		result = 37 * result + (getSenderId() == null ? 0 : this.getSenderId().hashCode());
		result = 37 * result + (getSubStatus() == null ? 0 : this.getSubStatus().hashCode());
		result = 37 * result + (getMessageText() == null ? 0 : this.getMessageText().hashCode());
		result = 37 * result + (getReceivedTs() == null ? 0 : this.getReceivedTs().hashCode());
		result = 37 * result + (getDeliveredTs() == null ? 0 : this.getDeliveredTs().hashCode());
		result = 37 * result + (getDeliveryStat() == null ? 0 : this.getDeliveryStat().hashCode());
		result = 37 * result + (getErrorCode() == null ? 0 : this.getErrorCode().hashCode());
		result = 37 * result + (getErrorDesc() == null ? 0 : this.getErrorDesc().hashCode());
		return result;
	}


}
