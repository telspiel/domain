package com.noesis.domain.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ftp_campaign", catalog = "genesis")
public class FTPCampaign implements Serializable {

	private static final long serialVersionUID = -5622816692621798082L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "username", nullable = false, length = 100)
	private String userName;

	@Column(name = "event_execution_id", nullable = false, length = 100)
	private String eventExecutionId;

	@Column(name = "event_name", nullable = false, length = 100)
	private String eventName;

	@Column(name = "communication_template_name", nullable = false, length = 100)
	private String communicationTemplateName;

	@Column(name = "mobile_number", nullable = false)
	private String mobileNumber;

	@Column(name = "message", nullable = false, length = 10000)
	private String message;

	public FTPCampaign() {
		super();
	}

	public FTPCampaign(int id) {
		super();
		this.id = id;
	}

	public FTPCampaign(int id, String userName, String eventExecutionId, String eventName,
			String communicationTemplateName, String mobileNumber, String message) {
		super();
		this.id = id;
		this.userName = userName;
		this.eventExecutionId = eventExecutionId;
		this.eventName = eventName;
		this.communicationTemplateName = communicationTemplateName;
		this.mobileNumber = mobileNumber;
		this.message = message;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEventExecutionId() {
		return eventExecutionId;
	}

	public void setEventExecutionId(String eventExecutionId) {
		this.eventExecutionId = eventExecutionId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCommunicationTemplateName() {
		return communicationTemplateName;
	}

	public void setCommunicationTemplateName(String communicationTemplateName) {
		this.communicationTemplateName = communicationTemplateName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FTPCampaign [id=" + id + ", userName=" + userName + ", eventExecutionId=" + eventExecutionId
				+ ", eventName=" + eventName + ", communicationTemplateName=" + communicationTemplateName
				+ ", mobileNumber=" + mobileNumber + ", message=" + message + "]";
	}
	
}
