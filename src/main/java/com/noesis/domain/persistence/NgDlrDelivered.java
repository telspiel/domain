package com.noesis.domain.persistence;
// Generated 26 Nov, 2018 9:56:21 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * NgDlrDelivered generated by hbm2java
 */
@Entity
@Table(name = "ng_dlr_delivered", catalog = "genesis")
public class NgDlrDelivered implements java.io.Serializable {

	private Integer id;
	private String messageId;
	private String ackId;
	private int userId;
	private String mobileNumber;
	private Date sentTs;

	public NgDlrDelivered() {
	}

	public NgDlrDelivered(String messageId, int userId, String mobileNumber, Date sentTs) {
		this.messageId = messageId;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.sentTs = sentTs;
	}

	public NgDlrDelivered(String messageId, String ackId, int userId, String mobileNumber, Date sentTs) {
		this.messageId = messageId;
		this.ackId = ackId;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.sentTs = sentTs;
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

	@Column(name = "message_id", nullable = false, length = 45)
	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Column(name = "ack_id", length = 45)
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

	@Column(name = "mobile_number", nullable = false, length = 45)
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sent_ts", nullable = false, length = 19)
	public Date getSentTs() {
		return this.sentTs;
	}

	public void setSentTs(Date sentTs) {
		this.sentTs = sentTs;
	}

}