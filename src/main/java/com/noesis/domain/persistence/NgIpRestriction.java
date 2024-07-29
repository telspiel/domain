package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ng_user_host_restriction", catalog = "genesis")
public class NgIpRestriction implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "user_name",nullable = false,length = 45)
	private String userName;
	
	@Column(name = "user_id",nullable = false,length = 11)
	private Integer userId;
	
	@Column(name = "IP",nullable = false,length = 55)
	private String iP;
	
	
	//  Noargs constructor .
	public NgIpRestriction() {
		super();
		// TODO Auto-generated constructor stub
	}

	// args constructor
	
	public NgIpRestriction(Integer id, String userName, Integer userId, String iP) {
		super();
		this.id = id;
		this.userName = userName;
		this.userId = userId;
		this.iP = iP;
	}

	// getter setter
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getiP() {
		return iP;
	}

	public void setiP(String iP) {
		this.iP = iP;
	}

	@Override
	public String toString() {
		return "NgIpRestriction [id=" + id + ", userName=" + userName + ", userId=" + userId + ", iP=" + iP + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
