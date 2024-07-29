package com.noesis.domain.persistence;
// Generated 31 Jul, 2018 12:08:37 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * NgUserDlrConfig generated by hbm2java
 */
@Entity
@Table(name = "ng_user_setting", catalog = "genesis")
public class NgUserSettings implements java.io.Serializable {

	private static final long serialVersionUID = -8779689925611795310L;
	private int id;
	private int userId;
	private NgMessageCharset ngMessageCharset;
	
	public NgUserSettings() {
	}

	public NgUserSettings(int id, int userId, NgMessageCharset ngMessageCharset)  {
		this.id = id;
		this.userId = userId;
		this.ngMessageCharset = ngMessageCharset;
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

	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "smpp_charset")
	public NgMessageCharset getNgMessageCharset() {
		return ngMessageCharset;
	}

	public void setNgMessageCharset(NgMessageCharset ngMessageCharset) {
		this.ngMessageCharset = ngMessageCharset;
	}

	}