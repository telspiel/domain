package com.noesis.domain.persistence;
// Generated 31 Jul, 2018 12:08:37 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * NgUser generated by hbm2java
 */
@Entity
@Table(name = "ng_internal_user", catalog = "genesis")
public class NgInternalUser implements java.io.Serializable {

	private static final long serialVersionUID = 1676665425599676769L;
	private int id;
	private int version;
	private String userName;
	private String password;
	private NgUserRole ngUserRole;
	private NgCustomerType ngCustomerType;
	private String email;
	private String mobile;
	private Date createdDate;
	private Date updatedDate;
	private String updatedBy;
	private Date expiry;
	private NgStatus ngStatus;
	private Integer parentId;
	private Integer adId;
	
	public NgInternalUser() {
	}

	public NgInternalUser(int id,String userName, String password, NgUserRole ngUserRole, String email, String mobile, Date createdDate, 
			Date updatedDate, String updatedBy, Date expiry, NgStatus ngStatus, Integer parentId, Integer adId) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.ngUserRole = ngUserRole;
		this.email = email;
		this.mobile = mobile;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.expiry = expiry;
		this.ngStatus = ngStatus;
		this.parentId = parentId;
		this.adId = adId;
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

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "user_name", nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_role", nullable = false)
	@JsonBackReference
	public NgUserRole getNgUserRole() {
		return this.ngUserRole;
	}

	public void setNgUserRole(NgUserRole ngUserRole) {
		this.ngUserRole = ngUserRole;
	}
	
	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobile", length = 45)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "updated_by", nullable = false, length = 45)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiry", length = 19)
	public Date getExpiry() {
		return this.expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status", nullable = false)
	@JsonBackReference
	public NgStatus getNgStatus() {
		return this.ngStatus;
	}

	public void setNgStatus(NgStatus ngStatus) {
		this.ngStatus = ngStatus;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	@Column(name = "ad_id", length = 11)
	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_type", nullable = false)
	@JsonBackReference
	public NgCustomerType getNgCustomerType() {
		return ngCustomerType;
	}

	public void setNgCustomerType(NgCustomerType ngCustomerType) {
		this.ngCustomerType = ngCustomerType;
	}

	
}
