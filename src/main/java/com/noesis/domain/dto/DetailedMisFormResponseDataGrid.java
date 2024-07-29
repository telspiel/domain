package com.noesis.domain.dto;

public class DetailedMisFormResponseDataGrid {
	private String receiveDate;
	private String messageId;
	private String mobileNumber; 
	//private String submitStatus;
	//private String submitErrorCode;
	private String sentDate;
	private String senderId;
	private String deliveryStatus;
	private String deliveryErrorCode;
	private String deliveryDateTime;
	private String messageText;
	private String messageCount;
	private String errorDesc;									//Changes for add ErrorDesc in Detailed Report(Aman)
	private String circleName;									//Changes for add Circle Name in Detailed Report(Aman)
	private String carrierName;									//Changes for add Carrier Name in Detailed Report(Aman)
	private String templateId;									//Changes for add TemplateId in Detailed Report(Aman)
	
	
	
	public String getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(String messageCount) {
		this.messageCount = messageCount;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/*public String getSubmitStatus() {
		return submitStatus;
	}
	public void setSubmitStatus(String submitStatus) {
		this.submitStatus = submitStatus;
	}
	public String getSubmitErrorCode() {
		return submitErrorCode;
	}
	public void setSubmitErrorCode(String submitErrorCode) {
		this.submitErrorCode = submitErrorCode;
	}
*/	public String getSentDate() {
		return sentDate;
	}
	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getDeliveryErrorCode() {
		return deliveryErrorCode;
	}
	public void setDeliveryErrorCode(String deliveryErrorCode) {
		this.deliveryErrorCode = deliveryErrorCode;
	}
	public String getDeliveryDateTime() {
		return deliveryDateTime;
	}
	public void setDeliveryDateTime(String deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	
}
