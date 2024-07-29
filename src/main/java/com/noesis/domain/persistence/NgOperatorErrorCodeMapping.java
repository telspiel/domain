package com.noesis.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_operator_error_code_mapping", catalog = "genesis")
public class NgOperatorErrorCodeMapping implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String errorCode;
	private String errorDesc;
	private int kannelId;
	private char isRetryEnabled;
	private int platformErrorCodeId;
	private String platformErrorCode;
	private char isCarrierRetryEnabled;
	private String platformErrorCodeDesc;
	
	public NgOperatorErrorCodeMapping() {
		
	}
	
	public NgOperatorErrorCodeMapping(int id, String errorCode, String errorDesc, int kannelId, char isRetryEnabled ,int platformErrorCodeId, String platformErrorCode,
			char isCarrierRetryEnabled,String platformErrorCodeDesc) {
		
		this.id = id;
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
		this.kannelId = kannelId;
		this.isRetryEnabled = isRetryEnabled;
		this.platformErrorCodeId = platformErrorCodeId;
		this.platformErrorCode = platformErrorCode;
		this.isCarrierRetryEnabled = isCarrierRetryEnabled;
		this.platformErrorCodeDesc = platformErrorCodeDesc;
		}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "error_code", nullable = false)
	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	@Column(name = "error_desc", nullable = false, length = 100)
	public String getErrorDesc() {
		return this.errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	@Column(name = "kannel_id", nullable = false)
	public int getKannelId() {
		return this.kannelId;
	}

	public void setKannelId(int kannelId) {
		this.kannelId = kannelId;
	}

	@Column(name = "is_retry_enabled", nullable = false)
	public char getIsRetryEnabled() {
		return isRetryEnabled;
	}

	public void setIsRetryEnabled(char isRetryEnabled) {
		this.isRetryEnabled = isRetryEnabled;
	}

	@Column(name = "platform_error_code_id", nullable = false)
	public int getPlatformErrorCodeId() {
		return platformErrorCodeId;
	}

	public void setPlatformErrorCodeId(int platformErrorCodeId) {
		this.platformErrorCodeId = platformErrorCodeId;
	}

	@Column(name = "platform_error_code")
	public String getPlatformErrorCode() {
		return platformErrorCode;
	}

	public void setPlatformErrorCode(String platformErrorCode) {
		this.platformErrorCode = platformErrorCode;
	}

	@Column(name = "is_carrier_retry_enabled", nullable = false)
	public char getIsCarrierRetryEnabled() {
		return isCarrierRetryEnabled;
	}

	public void setIsCarrierRetryEnabled(char isCarrierRetryEnabled) {
		this.isCarrierRetryEnabled = isCarrierRetryEnabled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "platform_error_desc", length = 300)
	public String getPlatformErrorCodeDesc() {
		return platformErrorCodeDesc;
	}

	public void setPlatformErrorCodeDesc(String platformErrorCodeDesc) {
		this.platformErrorCodeDesc = platformErrorCodeDesc;
	}
	

	
}
