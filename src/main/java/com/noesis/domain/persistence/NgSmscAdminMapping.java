package com.noesis.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ng_smsc_admin_mapping", catalog = "genesis")
public class NgSmscAdminMapping implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int adId;
	private int saId;
	private int kannelId;
	private int smscStatusId;
	private String actionType;
	private String actionResult;
	private String errorDesc;
	private String connStat;
	private String smscType;
	private String smscName;
	private String smscIp;
	private String smscPort;
	private String bindMode;
	private String smscUserName;
	private String smscPassword;
	private int sourceAddrTon;
	private int sourceAddrNpi;
	private int destAddrTon;
	private int destAddrNpi;
	private int smscThroughput;
	private int smscSessions;
	private String isTesting;
	private String testMobileNumber;
	private String testSenderId;
	private String testMessageText;
	private String testSentStatus;
	private String testDlrStatus;
	private Date testDate;
	private Date createdDate;
	private Date updatedDate;
	
	public NgSmscAdminMapping() {
		
	}
	
	public NgSmscAdminMapping(int id, int adId, int saId, int kannelId, int smscStatusId, String actionType, String actionResult,	String errorDesc, 
			String connStat, String smscType, String smscName, String smscIp, String smscPort, String bindMode, String smscUserName,
			String smscPassword, int sourceAddrTon, int sourceAddrNpi, int destAddrTon, int destAddrNpi, int smscThroughput, 
			int smscSessions, String isTesting, String testMobileNumber, String testSenderId, String testMessageText, 
			String testSentStatus, String testDlrStatus, Date testDate, Date createdDate, Date updatedDate) {
		
		this.id = id;
		this.adId = adId;
		this.saId = saId;
		this.kannelId = kannelId;
		this.smscStatusId = smscStatusId;
		this.actionType = actionType;
		this.actionResult = actionResult;
		this.errorDesc = errorDesc;
		this.connStat = connStat;
		this.smscType = smscType;
		this.smscName = smscName;
		this.smscIp = smscIp;
		this.smscPort = smscPort;
		this.bindMode = bindMode;
		this.smscUserName = smscUserName;
		this.smscPassword = smscPassword;
		this.sourceAddrTon = sourceAddrTon;
		this.sourceAddrNpi = sourceAddrNpi;
		this.destAddrTon = destAddrTon;
		this.destAddrNpi = destAddrNpi;
		this.smscThroughput = smscThroughput;
		this.smscSessions = smscSessions;
		this.isTesting = isTesting;
		this.testMobileNumber = testMobileNumber;
		this.testSenderId = testSenderId;
		this.testMessageText = testMessageText;
		this.testSentStatus = testSentStatus;
		this.testDlrStatus = testDlrStatus;
		this.testDate = testDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ad_id", nullable = false, length = 11)
	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}
	
	@Column(name = "sa_id", nullable = false, length = 11)
	public int getSaId() {
		return saId;
	}

	public void setSaId(int saId) {
		this.saId = saId;
	}

	@Column(name = "kannel_id", nullable = false, length = 11)
	public int getKannelId() {
		return kannelId;
	}

	public void setKannelId(int kannelId) {
		this.kannelId = kannelId;
	}

	@Column(name = "smsc_status_id", nullable = false, length = 11)
	public int getSmscStatusId() {
		return smscStatusId;
	}

	public void setSmscStatusId(int smscStatusId) {
		this.smscStatusId = smscStatusId;
	}

	@Column(name = "action_type", nullable = false, length = 20)
	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@Column(name = "action_result", nullable = false, length = 20)
	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

	@Column(name = "error_desc", nullable = false, length = 1000)
	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	@Column(name = "conn_stat", nullable = false, length = 200)
	public String getConnStat() {
		return connStat;
	}

	public void setConnStat(String connStat) {
		this.connStat = connStat;
	}

	@Column(name = "smsc_type", nullable = false, length = 20)
	public String getSmscType() {
		return smscType;
	}

	public void setSmscType(String smscType) {
		this.smscType = smscType;
	}

	@Column(name = "smsc_name", nullable = false, length = 50)
	public String getSmscName() {
		return smscName;
	}

	public void setSmscName(String smscName) {
		this.smscName = smscName;
	}

	@Column(name = "smsc_ip", nullable = false, length = 50)
	public String getSmscIp() {
		return smscIp;
	}

	public void setSmscIp(String smscIp) {
		this.smscIp = smscIp;
	}

	@Column(name = "smsc_port", nullable = false, length = 5)
	public String getSmscPort() {
		return smscPort;
	}

	public void setSmscPort(String smscPort) {
		this.smscPort = smscPort;
	}

	@Column(name = "bind_mode", nullable = false, length = 5)
	public String getBindMode() {
		return bindMode;
	}

	public void setBindMode(String bindMode) {
		this.bindMode = bindMode;
	}

	@Column(name = "smsc_user_name", nullable = false, length = 15)
	public String getSmscUserName() {
		return smscUserName;
	}

	public void setSmscUserName(String smscUserName) {
		this.smscUserName = smscUserName;
	}

	@Column(name = "smsc_password", nullable = false, length = 15)
	public String getSmscPassword() {
		return smscPassword;
	}

	public void setSmscPassword(String smscPassword) {
		this.smscPassword = smscPassword;
	}

	@Column(name = "source_addr_ton", nullable = false, length = 1)
	public int getSourceAddrTon() {
		return sourceAddrTon;
	}

	public void setSourceAddrTon(int sourceAddrTon) {
		this.sourceAddrTon = sourceAddrTon;
	}

	@Column(name = "source_addr_npi", nullable = false, length = 1)
	public int getSourceAddrNpi() {
		return sourceAddrNpi;
	}

	public void setSourceAddrNpi(int sourceAddrNpi) {
		this.sourceAddrNpi = sourceAddrNpi;
	}

	@Column(name = "dest_addr_ton", nullable = false, length = 1)
	public int getDestAddrTon() {
		return destAddrTon;
	}

	public void setDestAddrTon(int destAddrTon) {
		this.destAddrTon = destAddrTon;
	}

	@Column(name = "dest_addr_npi", nullable = false, length = 1)
	public int getDestAddrNpi() {
		return destAddrNpi;
	}

	public void setDestAddrNpi(int destAddrNpi) {
		this.destAddrNpi = destAddrNpi;
	}

	@Column(name = "smsc_throughput", nullable = false, length = 4)
	public int getSmscThroughput() {
		return smscThroughput;
	}

	public void setSmscThroughput(int smscThroughput) {
		this.smscThroughput = smscThroughput;
	}

	@Column(name = "smsc_sessions", nullable = false, length = 4)
	public int getSmscSessions() {
		return smscSessions;
	}

	public void setSmscSessions(int smscSessions) {
		this.smscSessions = smscSessions;
	}

	@Column(name = "is_testing", nullable = false, length = 1)
	public String getIsTesting() {
		return isTesting;
	}

	public void setIsTesting(String isTesting) {
		this.isTesting = isTesting;
	}

	@Column(name = "test_mobile_number", nullable = false, length = 15)
	public String getTestMobileNumber() {
		return testMobileNumber;
	}

	public void setTestMobileNumber(String testMobileNumber) {
		this.testMobileNumber = testMobileNumber;
	}

	@Column(name = "test_sender_id", nullable = false, length = 10)
	public String getTestSenderId() {
		return testSenderId;
	}

	public void setTestSenderId(String testSenderId) {
		this.testSenderId = testSenderId;
	}

	@Column(name = "test_message_text", nullable = false, length = 300)
	public String getTestMessageText() {
		return testMessageText;
	}

	public void setTestMessageText(String testMessageText) {
		this.testMessageText = testMessageText;
	}

	@Column(name = "test_sent_status", nullable = false, length = 300)
	public String getTestSentStatus() {
		return testSentStatus;
	}

	public void setTestSentStatus(String testSentStatus) {
		this.testSentStatus = testSentStatus;
	}

	@Column(name = "test_dlr_status", nullable = false, length = 300)
	public String getTestDlrStatus() {
		return testDlrStatus;
	}

	public void setTestDlrStatus(String testDlrStatus) {
		this.testDlrStatus = testDlrStatus;
	}

	@Column(name = "test_date", nullable = false, length = 100)
	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 100)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 100)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
