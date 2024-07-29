package com.noesis.domain.dto;


public class SaveUserForm {

	private String loggedInUserName;
	private int userId;
	private String operation;
	private int orgId;
	private int deptId;
	private String userName;
	private String userPassword ;
	private String name;
	private String email;
	private String mobile;
	private String role;
	private String customerType ;
	private String accountType;
	private String status;
	private String billingType;
	private String billingCycle;
	private String userExpiryDate;
	private char isExpressAllowed;
	private char isDndCheck;
	private char isGuiAccess;
	private char isHttpAllowed;
	private char isHttpsAllowed;
	private char isBlockout;
	private char isDlrAllowed;
	private char isMessageFilter;
	private String isguiAccess;
	private char isDuplicateAllowed;
	private char isBlacklistAllowed;
	private String messageType;
	private char isTimeAdjust;
	private char isOtpAllowed;
	private String dlrMediumType;
	private String senderIdType;
	private String priority;
	private char isBulkUploadAllowed;
	private char isSmppAllowed;
	private char isInternationalAllowed;
	private int abusingWordsCount;
	private String createdDate;
	private String updatedDate;
	private String updatedBy;
	private int maxDlrRetryCount;
	private String dlrPushUrl;
	
	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}
	public String getOperation() {
		return operation;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getBillingCycle() {
		return billingCycle;
	}
	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}
	public String getUserExpiryDate() {
		return userExpiryDate;
	}
	public void setUserExpiryDate(String userExpiryDate) {
		this.userExpiryDate = userExpiryDate;
	}
	public char getIsExpressAllowed() {
		return isExpressAllowed;
	}
	public void setIsExpressAllowed(char isExpressAllowed) {
		this.isExpressAllowed = isExpressAllowed;
	}
	public char getIsDndCheck() {
		return isDndCheck;
	}
	public void setIsDndCheck(char isDndCheck) {
		this.isDndCheck = isDndCheck;
	}
	public char getIsGuiAccess() {
		return isGuiAccess;
	}
	public void setIsGuiAccess(char isGuiAccess) {
		this.isGuiAccess = isGuiAccess;
	}
	public char getIsHttpAllowed() {
		return isHttpAllowed;
	}
	public void setIsHttpAllowed(char isHttpAllowed) {
		this.isHttpAllowed = isHttpAllowed;
	}
	public char getIsHttpsAllowed() {
		return isHttpsAllowed;
	}
	public void setIsHttpsAllowed(char isHttpsAllowed) {
		this.isHttpsAllowed = isHttpsAllowed;
	}
	public char getIsBlockout() {
		return isBlockout;
	}
	public void setIsBlockout(char isBlockout) {
		this.isBlockout = isBlockout;
	}
	public char getIsDlrAllowed() {
		return isDlrAllowed;
	}
	public void setIsDlrAllowed(char isDlrAllowed) {
		this.isDlrAllowed = isDlrAllowed;
	}
	public char getIsMessageFilter() {
		return isMessageFilter;
	}
	public void setIsMessageFilter(char isMessageFilter) {
		this.isMessageFilter = isMessageFilter;
	}
	public String getIsguiAccess() {
		return isguiAccess;
	}
	public void setIsguiAccess(String isguiAccess) {
		this.isguiAccess = isguiAccess;
	}
	public char getIsDuplicateAllowed() {
		return isDuplicateAllowed;
	}
	public void setIsDuplicateAllowed(char isDuplicateAllowed) {
		this.isDuplicateAllowed = isDuplicateAllowed;
	}
	public char getIsBlacklistAllowed() {
		return isBlacklistAllowed;
	}
	public void setIsBlacklistAllowed(char isBlacklistAllowed) {
		this.isBlacklistAllowed = isBlacklistAllowed;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public char getIsTimeAdjust() {
		return isTimeAdjust;
	}
	public void setIsTimeAdjust(char isTimeAdjust) {
		this.isTimeAdjust = isTimeAdjust;
	}
	public char getIsOtpAllowed() {
		return isOtpAllowed;
	}
	public void setIsOtpAllowed(char isOtpAllowed) {
		this.isOtpAllowed = isOtpAllowed;
	}
	public String getDlrMediumType() {
		return dlrMediumType;
	}
	public void setDlrMediumType(String dlrMediumType) {
		this.dlrMediumType = dlrMediumType;
	}
	public String getSenderIdType() {
		return senderIdType;
	}
	public void setSenderIdType(String senderIdType) {
		this.senderIdType = senderIdType;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public char getIsBulkUploadAllowed() {
		return isBulkUploadAllowed;
	}
	public void setIsBulkUploadAllowed(char isBulkUploadAllowed) {
		this.isBulkUploadAllowed = isBulkUploadAllowed;
	}
	public char getIsSmppAllowed() {
		return isSmppAllowed;
	}
	public void setIsSmppAllowed(char isSmppAllowed) {
		this.isSmppAllowed = isSmppAllowed;
	}
	public char getIsInternationalAllowed() {
		return isInternationalAllowed;
	}
	public void setIsInternationalAllowed(char isInternationalAllowed) {
		this.isInternationalAllowed = isInternationalAllowed;
	}
	public int getAbusingWordsCount() {
		return abusingWordsCount;
	}
	public void setAbusingWordsCount(int abusingWordsCount) {
		this.abusingWordsCount = abusingWordsCount;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public int getMaxDlrRetryCount() {
		return maxDlrRetryCount;
	}
	public void setMaxDlrRetryCount(int maxDlrRetryCount) {
		this.maxDlrRetryCount = maxDlrRetryCount;
	}
	public String getDlrPushUrl() {
		return dlrPushUrl;
	}
	public void setDlrPushUrl(String dlrPushUrl) {
		this.dlrPushUrl = dlrPushUrl;
	}
}
