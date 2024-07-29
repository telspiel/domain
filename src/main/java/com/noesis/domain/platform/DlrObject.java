package com.noesis.domain.platform;

import java.sql.Timestamp;

public class DlrObject {
	String dr;
	String smscid;
	String dlrStatusCode;
	String messageId;
	String userName;
	Timestamp receiveTime;
	String dlrType;
	String destNumber;
	Timestamp submitTime;
	String expiry;
	String senderId;
	String carrierId;
	String circleId;
	String routeId;
	String systemId;
	String sentStatus;
	String errorCode;
	String errorDesc;
	String messageText;
	String currKannelId;
	String reqId;
	String retryCount;
	String usedKannelId;
	String isMultiPart;
	char sendDlrToUser;
	String msgType;
	String splitCount;
	String pushUrl;
	String custRef;
	String entityId;
	String templateId;
	
	
	public String getSentStatus() {
		return sentStatus;
	}
	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	public String getDr() {
		return dr;
	}
	public void setDr(String dr) {
		this.dr = dr;
	}
	public String getSmscid() {
		return smscid;
	}
	public void setSmscid(String smscid) {
		this.smscid = smscid;
	}
	public String getDlrStatusCode() {
		return dlrStatusCode;
	}
	public void setDlrStatusCode(String dlrStatusCode) {
		this.dlrStatusCode = dlrStatusCode;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDlrType() {
		return dlrType;
	}
	public void setDlrType(String dlrType) {
		this.dlrType = dlrType;
	}
	public String getDestNumber() {
		return destNumber;
	}
	public void setDestNumber(String destNumber) {
		this.destNumber = destNumber;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public Timestamp getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Timestamp getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getCurrKannelId() {
		return currKannelId;
	}
	public void setCurrKannelId(String currKannelId) {
		this.currKannelId = currKannelId;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getRetryCount() {
		return retryCount;
	}
	public void setRetryCount(String retryCount) {
		this.retryCount = retryCount;
	}
	public String getUsedKannelId() {
		return usedKannelId;
	}
	public void setUsedKannelId(String usedKannelId) {
		this.usedKannelId = usedKannelId;
	}
	public String getIsMultiPart() {
		return isMultiPart;
	}
	public void setIsMultiPart(String isMultiPart) {
		this.isMultiPart = isMultiPart;
	}
	public char getSendDlrToUser() {
		return sendDlrToUser;
	}
	public void setSendDlrToUser(char sendDlrToUser) {
		this.sendDlrToUser = sendDlrToUser;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getSplitCount() {
		return splitCount;
	}
	public void setSplitCount(String splitCount) {
		this.splitCount = splitCount;
	}
	public String getPushUrl() {
		return pushUrl;
	}
	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}
	public String getCustRef() {
		return custRef;
	}
	public void setCustRef(String custRef) {
		this.custRef = custRef;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
}
