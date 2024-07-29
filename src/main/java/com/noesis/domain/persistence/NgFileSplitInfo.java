package com.noesis.domain.persistence;
// Generated 10 Feb, 2019 3:25:34 PM by Hibernate Tools 5.0.6.Final

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
 * NgFileSplitInfo generated by hbm2java
 */
@Entity
@Table(name = "ng_file_split_info", catalog = "genesis")
public class NgFileSplitInfo implements java.io.Serializable {

	private Integer id;
	//private NgUser ngUser;
	private Integer userId;
	private String serverFileName;
	private String splitFileName;
	private Date createdDate;
	private Integer scheduleTimeHh;
	private Integer scheduleTimeMm;
	private String msgText;
	private String senderId;
	private String campaignName;
	private Integer characterCount;
	private String msgType;
	private char isProcessed;
	private Integer splitFromIndex;
	private Integer splitToIndex;
	private Date scheduleDate;
	private char isShortUrlSelected;
	private String shortUrlName;
	private String originalMsgText;
	private int campaignId;
	private String entityId;
	private String templateId;
	private String messageServiceType;
	private String messageServiceSubType;
	private Integer blockedCredit;
	private char isScheduled;
	private Integer perMessageCredit = 0;
	
	public NgFileSplitInfo() {
	}

	public NgFileSplitInfo(char isProcessed) {
		this.isProcessed = isProcessed;
	}

	public NgFileSplitInfo(Integer userId, String serverFileName, String splitFileName, Date createdDate,
			Integer scheduleTimeHh, Integer scheduleTimeMm, String msgText, String senderId, String campaignName, Integer characterCount,
			String msgType, char isProcessed, Integer splitFromIndex, Integer splitToIndex, char isShortUrlSelected, String shortUrlName, int campaignId,
			String entityId, String templateId, String messageServiceType, String messageServiceSubType,Integer blockedCredit, char isScheduled,Integer perMessageCredit ) {
		//this.ngUser = ngUser;
		this.userId = userId;
		this.serverFileName = serverFileName;
		this.splitFileName = splitFileName;
		this.createdDate = createdDate;
		this.scheduleTimeHh = scheduleTimeHh;
		this.scheduleTimeMm = scheduleTimeMm;
		this.msgText = msgText;
		this.senderId = senderId;
		this.campaignName = campaignName;
		this.characterCount = characterCount;
		this.msgType = msgType;
		this.isProcessed = isProcessed;
		this.splitFromIndex = splitFromIndex;
		this.splitToIndex = splitToIndex;
		this.isShortUrlSelected = isShortUrlSelected;
		this.shortUrlName = shortUrlName;
		this.campaignId = campaignId;
		this.entityId = entityId;
		this.templateId = templateId;
		this.messageServiceType = messageServiceType;
		this.messageServiceSubType = messageServiceSubType;
		this.blockedCredit = blockedCredit;
		this.isScheduled = isScheduled;
		this.perMessageCredit = perMessageCredit;
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

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")*/
/*	public NgUser getNgUser() {
		return this.ngUser;
	}

	public void setNgUser(NgUser ngUser) {
		this.ngUser = ngUser;
	}*/

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	@Column(name = "server_file_name", length = 250)
	public String getServerFileName() {
		return this.serverFileName;
	}

	public void setServerFileName(String serverFileName) {
		this.serverFileName = serverFileName;
	}

	@Column(name = "split_file_name", length = 250)
	public String getSplitFileName() {
		return this.splitFileName;
	}

	public void setSplitFileName(String splitFileName) {
		this.splitFileName = splitFileName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "schedule_time_hh")
	public Integer getScheduleTimeHh() {
		return this.scheduleTimeHh;
	}

	public void setScheduleTimeHh(Integer scheduleTimeHh) {
		this.scheduleTimeHh = scheduleTimeHh;
	}

	@Column(name = "schedule_time_mm")
	public Integer getScheduleTimeMm() {
		return this.scheduleTimeMm;
	}

	public void setScheduleTimeMm(Integer scheduleTimeMm) {
		this.scheduleTimeMm = scheduleTimeMm;
	}

	@Column(name = "msg_text", length = 1000)
	public String getMsgText() {
		return this.msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
	
	@Column(name = "sender_id", length = 10)
	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@Column(name = "campaign_name", length = 200)
	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	@Column(name = "character_count")
	public Integer getCharacterCount() {
		return this.characterCount;
	}

	public void setCharacterCount(Integer characterCount) {
		this.characterCount = characterCount;
	}

	@Column(name = "msg_type", length = 45)
	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@Column(name = "is_processed", nullable = false, length = 1)
	public char getIsProcessed() {
		return this.isProcessed;
	}

	public void setIsProcessed(char isProcessed) {
		this.isProcessed = isProcessed;
	}

	@Column(name = "split_from_index")
	public Integer getSplitFromIndex() {
		return this.splitFromIndex;
	}

	public void setSplitFromIndex(Integer splitFromIndex) {
		this.splitFromIndex = splitFromIndex;
	}

	@Column(name = "split_to_index")
	public Integer getSplitToIndex() {
		return this.splitToIndex;
	}

	public void setSplitToIndex(Integer splitToIndex) {
		this.splitToIndex = splitToIndex;
	}

	@Column(name = "scheduleDate")
	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@Column(name = "is_short_url_selected", nullable = false, length = 1)
	public char getIsShortUrlSelected() {
		return isShortUrlSelected;
	}

	public void setIsShortUrlSelected(char isShortUrlSelected) {
		this.isShortUrlSelected = isShortUrlSelected;
	}

	@Column(name = "short_url_name", length = 100)
	public String getShortUrlName() {
		return shortUrlName;
	}

	public void setShortUrlName(String shortUrlName) {
		this.shortUrlName = shortUrlName;
	}

	@Column(name = "original_msg_text", length = 5000)
	public String getOriginalMsgText() {
		return originalMsgText;
	}

	public void setOriginalMsgText(String originalMsgText) {
		this.originalMsgText = originalMsgText;
	}
	
	@Column(name = "campaign_id", length = 11)
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	@Column(name = "entity_id")
	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@Column(name = "template_id")
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}	
	
	@Column(name = "msg_service_type")
	public String getMessageServiceType() {
		return messageServiceType;
	}

	public void setMessageServiceType(String messageServiceType) {
		this.messageServiceType = messageServiceType;
	}
	
	@Column(name = "msg_service_sub_type")
	public String getMessageServiceSubType() {
		return messageServiceSubType;
	}

	public void setMessageServiceSubType(String messageServiceSubType) {
		this.messageServiceSubType = messageServiceSubType;
	}
	@Column(name = "blocked_credit")
	public Integer getBlockedCredit() {
		return blockedCredit;
	}

	public void setBlockedCredit(Integer blockedCredit) {
		this.blockedCredit = blockedCredit;
	}
	@Column(name = "is_scheduled")
	public char getIsScheduled() {
		return isScheduled;
	}

	public void setIsScheduled(char isScheduled) {
		this.isScheduled = isScheduled;
	}

	@Column(name = "per_message_credit")
	public Integer getPerMessageCredit() {
		return perMessageCredit;
	}

	public void setPerMessageCredit(Integer perMessageCredit) {
		this.perMessageCredit = perMessageCredit;
	}
	
	
}
