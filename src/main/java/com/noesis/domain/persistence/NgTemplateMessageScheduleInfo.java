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

@Entity
@Table(name = "ng_template_msg_schedule_info", catalog = "genesis")
public class NgTemplateMessageScheduleInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1602945849756248965L;
	private Integer id;
	// private NgUser ngUser;
	private Integer userId;
	private String serverFileName;
	private Date createdDate;
	private Integer scheduleTimeHh;
	private Integer scheduleTimeMm;
	private String senderId;
	private String campaignName;
	private Integer characterCount;
	private String msgType;
	private char isProcessed;
	private Date scheduleDate;
	private Integer tempMsgInfoId;
	private Integer campaignId;
	private String entityId;
	private String templateId;
	private String messageServiceType;
	private String messageServiceSubType;
	private String msgText;
	private Integer splitFromIndex;
	private Integer splitToIndex;
	public NgTemplateMessageScheduleInfo() {
	}

	public NgTemplateMessageScheduleInfo(char isProcessed) {
		this.isProcessed = isProcessed;
	}

	public NgTemplateMessageScheduleInfo(Integer userId, String serverFileName, Date createdDate,
			Integer scheduleTimeHh, Integer scheduleTimeMm, String senderId, String campaignName,
			Integer characterCount, String msgType, char isProcessed, String entityId, String templateId,
			String messageServiceType, String messageServiceSubType, String msgText,Integer splitFromIndex, Integer splitToIndex) {
		// this.ngUser = ngUser;
		this.userId = userId;
		this.serverFileName = serverFileName;
		this.createdDate = createdDate;
		this.scheduleTimeHh = scheduleTimeHh;
		this.scheduleTimeMm = scheduleTimeMm;
		this.senderId = senderId;
		this.campaignName = campaignName;
		this.characterCount = characterCount;
		this.msgType = msgType;
		this.isProcessed = isProcessed;
		this.entityId = entityId;
		this.templateId = templateId;
		this.messageServiceType = messageServiceType;
		this.messageServiceSubType = messageServiceSubType;
		this.msgText = msgText;
		this.splitFromIndex = splitFromIndex;
		this.splitToIndex = splitToIndex;
		
				
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

	@Column(name = "schedule_date")
	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@Column(name = "temp_msg_info_id")
	public Integer getTempMsgInfoId() {
		return tempMsgInfoId;
	}

	public void setTempMsgInfoId(Integer tempMsgInfoId) {
		this.tempMsgInfoId = tempMsgInfoId;
	}

	@Column(name = "campaign_id")
	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
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
	@Column(name = "msg_text", length = 1000)
	public String getMsgText() {
		return this.msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
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

}
