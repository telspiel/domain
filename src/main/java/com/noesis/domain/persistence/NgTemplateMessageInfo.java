package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * NgTemplate generated by hbm2java
 */
@Entity
@Table(name = "ng_template_message_info", catalog = "genesis")
public class NgTemplateMessageInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String campaignName;
	private String msgType;
	private Integer msgPart;
	private String senderId;
	private String orgFileName;
	private String serverFileName;
	private char isScheduled;
	//private Integer templateId;
	private NgUser ngUser;
	private Date createdDate;
	private Set<NgTemplateMessageFieldsMapping> ngTemplateMessageFieldsMapping = new HashSet<NgTemplateMessageFieldsMapping>(0);
	private NgTemplate ngTemplate;
	
	public NgTemplateMessageInfo() {
	}
	
	public NgTemplateMessageInfo (String campaignName, String msgType, Integer msgPart, String senderId, String orgFileName, 
			String serverFileName, char isScheduled, // Integer templateId,
			NgUser ngUser, Date createdDate) {
		this.campaignName = campaignName;
		this.msgType = msgType;
		this.msgPart = msgPart;
		this.senderId = senderId;
		this.orgFileName = orgFileName;
		this.serverFileName = serverFileName;
		this.isScheduled = isScheduled;
		//this.templateId = templateId;
		this.ngUser = ngUser;
		this.createdDate = createdDate;
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
	
	@Column(name = "campaign_name", length = 200)
	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	@Column(name = "msg_type", length = 10)
	public String getMsgtype() {
		return this.msgType;
	}

	public void setMsgtype(String msgType) {
		this.msgType = msgType;
	}
	
	@Column(name = "msg_part", length = 10)
	public Integer getMsgPart() {
		return this.msgPart;
	}

	public void setMsgPart(Integer msgPart) {
		this.msgPart = msgPart;
	}
	
	@Column(name = "sender_id", length = 20)
	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	@Column(name = "org_file_name", length = 100)
	public String getOrgFileName() {
		return this.orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	
	@Column(name = "server_file_name", length = 100)
	public String getServerFileName() {
		return this.serverFileName;
	}

	public void setServerFileName(String serverFileName) {
		this.serverFileName = serverFileName;
	}
	
	@Column(name = "is_scheduled", length = 1)
	public char getIsScheduled() {
		return this.isScheduled;
	}

	public void setIsScheduled(char isScheduled) {
		this.isScheduled = isScheduled;
	}
	
	/*@Column(name = "template_id", length = 10)
	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = true)
	@JsonBackReference
	public NgUser getNgUser() {
		return this.ngUser;
	}

	public void setNgUser(NgUser ngUser) {
		this.ngUser = ngUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ngTemplateMessageInfo")
	@JsonIgnore
	public Set<NgTemplateMessageFieldsMapping> getNgTemplateMessageFieldsMapping() {
		return this.ngTemplateMessageFieldsMapping;
	}

	public void setNgTemplateMessageFieldsMapping(Set<NgTemplateMessageFieldsMapping> ngTemplateMessageFieldsMapping) {
		this.ngTemplateMessageFieldsMapping = ngTemplateMessageFieldsMapping;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "template_id", nullable = false, updatable = false, insertable = true)
	@JsonBackReference
	public NgTemplate getNgTemplate() {
		return this.ngTemplate;
	}

	public void setNgTemplate(NgTemplate ngTemplate) {
		this.ngTemplate = ngTemplate;
	}

}