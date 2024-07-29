package com.noesis.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NgGroup generated by hbm2java
 */
@Entity
@Table(name = "ng_service_type", catalog = "genesis")
public class NgServiceType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String serviceType;
	private String displayCode;

	public NgServiceType() {
	}

	public NgServiceType(Integer id, String serviceType, String displayCode) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.displayCode = displayCode;
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

	@Column(name = "service_type", length = 100)
	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name = "display_code", length = 45)
	public String getDisplayCode() {
		return this.displayCode;
	}

	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}
}