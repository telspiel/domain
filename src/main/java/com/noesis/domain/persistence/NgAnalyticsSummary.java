package com.noesis.domain.persistence;
// Generated 18 Dec, 2018 8:18:51 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * NgKannelInfo generated by hbm2java
 */
@Entity
@Table(name = "ng_analytics_summary", catalog = "genesis")
public class NgAnalyticsSummary implements java.io.Serializable {
	
	private static final long serialVersionUID = 1676665425599676769L;
	private int id;
	private int userId;
	private String userName;
	private Date date;
	private Integer campaignId;
	private String campaignName;
	private Integer shortUrlId;
	private String shortUrl;
	private Integer totalClicks;
	private Integer paId;
	private Integer adId;
	private Integer saId;
	private Integer reId;
	private Integer seId;

	public NgAnalyticsSummary() {
	}

	public NgAnalyticsSummary(int id, int userId, String userName , Date date, Integer campaignId, String campaignName, Integer shortUrlId, 
			String shortUrl, Integer totalClicks, Integer paId, Integer adId, Integer saId, Integer reId, Integer seId) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.date = date;
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.shortUrlId = shortUrlId;
		this.shortUrl = shortUrl;
		this.totalClicks = totalClicks;
		this.paId = paId;
		this.adId = adId;
		this.saId = saId;
		this.reId = reId;
		this.seId = seId;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "userId", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_name", unique = true, nullable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "campaign_id", nullable = false, length = 100)
	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
	
	@Column(name = "campaign_name", nullable = false, length = 100)
	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	@Column(name = "short_url_id", nullable = false, length = 100)
	public Integer getShortUrlId() {
		return this.shortUrlId;
	}

	public void setShortUrlId(Integer shortUrlId) {
		this.shortUrlId = shortUrlId;
	}
	
	@Column(name = "short_url", nullable = false, length = 100)
	public String getShortUrl() {
		return this.shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	@Column(name = "total_clicks", nullable = false, length = 100)
	public Integer getTotalClicks() {
		return this.totalClicks;
	}

	public void setTotalClicks(Integer totalClicks) {
		this.totalClicks = totalClicks;
	}
	
	@Column(name = "pa_id", length = 11)
	public Integer getPaId() {
		return this.paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}
	
	@Column(name = "ad_id", length = 11)
	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	@Column(name = "sa_id", length = 11)
	public Integer getSaId() {
		return this.saId;
	}

	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	@Column(name = "re_id", length = 11)
	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	@Column(name = "se_id", length = 11)
	public Integer getSeId() {
		return this.seId;
	}

	public void setSeId(Integer seId) {
		this.seId = seId;
	}

}
