package com.noesis.domain.platform;

import java.sql.Timestamp;

public class MessageObject {

	private String requestId;
	private String messageId;
	private String username;
	private int userId;
	private String destNumber;
	private String senderId;
	private String message;
	private String instanceId;
	private String coding;
	private Timestamp receiveTime;
	private String messageType;
	//private String accountType;
	private String messageServiceType;
	private String messageServiceSubType;
	boolean isConcatMessageIndicator;
	private String scheduleTime;
	private String expiryTime;
	private String status;
	private String errorCode;
	private String errorDesc;
	private Timestamp sentTime;
	private String udh;
	private Integer kannelId;
	private Integer carrierId;
	private Integer circleId;
	private Integer routeId;
	private Integer groupId;
	private Integer messageClass;
	private Integer originalMessageId;      
	private Integer priority;
	private String fullMsg;
	private Integer splitCount;
	private Integer idOfSenderId;
	private String originalSenderId;
	private boolean isPremiumNumber; 
	private boolean isDndNumber;
	private boolean isDndAllowed;
	private String orgMessage;
	private Integer retryCount;
	private String usedKannelIds;
	private String isMultiPart;
	private String custRef;
	private char isContainsShortUrl;
	private String shortUrl;
	private String longUrl;
	private String uniqueId;
	private String entityId;
	private String templateId;
	private String campaignName;
	private String campaignTime;
	private Integer campaignId;
	private String kannelName;
//	private char isCuttingApplicable = 'Y';
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDestNumber() {
		return destNumber;
	}
	public void setDestNumber(String destNumber) {
		this.destNumber = destNumber;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getCoding() {
		return coding;
	}
	public void setCoding(String coding) {
		this.coding = coding;
	}
	public Timestamp getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageServiceType() {
		return messageServiceType;
	}
	public void setMessageServiceType(String messageServiceType) {
		this.messageServiceType = messageServiceType;
	}
	public String getMessageServiceSubType() {
		return messageServiceSubType;
	}
	public void setMessageServiceSubType(String messageServiceSubType) {
		this.messageServiceSubType = messageServiceSubType;
	}
	public boolean getIsConcatMessageIndicator() {
		return isConcatMessageIndicator;
	}
	public void setIsConcatMessageIndicator(boolean isConcatMessageIndicator) {
		this.isConcatMessageIndicator = isConcatMessageIndicator;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Timestamp getSentTime() {
		return sentTime;
	}
	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}
	public String getUdh() {
		return udh;
	}
	public void setUdh(String udh) {
		this.udh = udh;
	}
	public Integer getKannelId() {
		return kannelId;
	}
	public void setKannelId(Integer kannelId) {
		this.kannelId = kannelId;
	}
	public Integer getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(Integer carrierId) {
		this.carrierId = carrierId;
	}
	public Integer getCircleId() {
		return circleId;
	}
	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getMessageClass() {
		return messageClass;
	}
	public void setMessageClass(Integer messageClass) {
		this.messageClass = messageClass;
	}
	public Integer getOriginalMessageId() {
		return originalMessageId;
	}
	public void setOriginalMessageId(Integer originalMessageId) {
		this.originalMessageId = originalMessageId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getFullMsg() {
		return fullMsg;
	}
	public void setFullMsg(String fullMsg) {
		this.fullMsg = fullMsg;
	}
	public Integer getSplitCount() {
		return splitCount;
	}
	public void setSplitCount(Integer splitCount) {
		this.splitCount = splitCount;
	}
	public void setConcatMessageIndicator(boolean isConcatMessageIndicator) {
		this.isConcatMessageIndicator = isConcatMessageIndicator;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public Integer getIdOfSenderId() {
		return idOfSenderId;
	}
	public void setIdOfSenderId(Integer idOfSenderId) {
		this.idOfSenderId = idOfSenderId;
	}
	public String getOriginalSenderId() {
		return originalSenderId;
	}
	public void setOriginalSenderId(String originalSenderId) {
		this.originalSenderId = originalSenderId;
	}
	public boolean isPremiumNumber() {
		return isPremiumNumber;
	}
	public void setPremiumNumber(boolean isPremiumNumber) {
		this.isPremiumNumber = isPremiumNumber;
	}
	public boolean isDndNumber() {
		return isDndNumber;
	}
	public void setDndNumber(boolean isDndNumber) {
		this.isDndNumber = isDndNumber;
	}
	public boolean isDndAllowed() {
		return isDndAllowed;
	}
	public void setDndAllowed(boolean isDndAllowed) {
		this.isDndAllowed = isDndAllowed;
	}
	public String getOrgMessage() {
		return orgMessage;
	}
	public void setOrgMessage(String orgMessage) {
		this.orgMessage = orgMessage;
	}
	public Integer getRetryCount() {
		return retryCount;
	}
	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
	public String getUsedKannelIds() {
		return usedKannelIds;
	}
	public void setUsedKannelIds(String usedKannelIds) {
		this.usedKannelIds = usedKannelIds;
	}
	public String getIsMultiPart() {
		return isMultiPart;
	}
	public void setIsMultiPart(String isMultiPart) {
		this.isMultiPart = isMultiPart;
	}
	public String getCustRef() {
		return custRef;
	}
	public void setCustRef(String custRef) {
		this.custRef = custRef;
	}
	
	public char getIsContainsShortUrl() {
		return isContainsShortUrl;
	}
	public void setIsContainsShortUrl(char isContainsShortUrl) {
		this.isContainsShortUrl = isContainsShortUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	private static int generateRandomNumber() {
		int low = 100;
		int high = 999;
		int result = (int)(Math.random()*((high-low)+1))+low;
		return result;
	}
	
	public static String generateMessageId(String mNumber, String instanceId) {
		return mNumber.substring(5,mNumber.length()) + instanceId + System.currentTimeMillis()+""+generateRandomNumber();
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getCampaignTime() {
		return campaignTime;
	}
	public void setCampaignTime(String campaignTime) {
		this.campaignTime = campaignTime;
	}
	public Integer getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
	public String getKannelName() {
		return kannelName;
	}
	public void setKannelName(String kannelName) {
		this.kannelName = kannelName;
	}
/*	public char getIsCuttingApplicable() {
		return isCuttingApplicable;
	}
	public void setIsCuttingApplicable(char isCuttingApplicable) {
		this.isCuttingApplicable = isCuttingApplicable;
	}
*/	
}
