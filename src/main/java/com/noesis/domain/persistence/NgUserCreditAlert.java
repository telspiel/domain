package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_user_credit_alert", catalog = "genesis")
public class NgUserCreditAlert implements java.io.Serializable {
	
	private static final long serialVersionUID = -3316939858121588490L;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "status",  nullable = false)
	private String status;
	
	@Column(name = "alert_url",  nullable = false)
	private String alerturl;

	public NgUserCreditAlert() {
		super();
	}

	public NgUserCreditAlert(int id, String username, String status, String alerturl) {
		super();
		this.id = id;
		this.userName = username;
		this.status = status;
		this.alerturl = alerturl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAlerturl() {
		return alerturl;
	}

	public void setAlerturl(String alerturl) {
		this.alerturl = alerturl;
	}

	@Override
	public String toString() {
		return "NgUserCreditAlert [id=" + id + ", username=" + userName + ", status=" + status + ", alerturl="
				+ alerturl + "]";
	}

	
	
	
	
	
	

}
