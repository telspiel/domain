package com.noesis.domain.persistence;
// Generated 31 Jul, 2018 12:08:37 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NgAppDetails generated by hbm2java
 */
@Entity
@Table(name = "ng_app_details", catalog = "genesis")
public class NgAppDetails implements java.io.Serializable {

	private static final long serialVersionUID = -5217379764685740180L;
	private int id;
	private String appId;
	private String appName;
	private String appType;
	private String appIp;
	private String appPort;

	public NgAppDetails() {
	}

	public NgAppDetails(int id) {
		this.id = id;
	}

	public NgAppDetails(int id, String appId, String appName, String appType, String appIp, String appPort) {
		this.id = id;
		this.appId = appId;
		this.appName = appName;
		this.appType = appType;
		this.appIp = appIp;
		this.appPort = appPort;
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

	@Column(name = "app_id", length = 45)
	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Column(name = "app_name", length = 45)
	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Column(name = "app_type", length = 45)
	public String getAppType() {
		return this.appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	@Column(name = "app_ip", length = 45)
	public String getAppIp() {
		return this.appIp;
	}

	public void setAppIp(String appIp) {
		this.appIp = appIp;
	}

	@Column(name = "app_port", length = 45)
	public String getAppPort() {
		return this.appPort;
	}

	public void setAppPort(String appPort) {
		this.appPort = appPort;
	}

}
