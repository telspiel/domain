package com.noesis.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ng_user_credit_status", catalog = "genesis")
public class NgUserCreditStatus {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "user_name",nullable = false,length = 45)
	private String userName;
	@Column(name = "status",nullable = false,length = 55)
	private String status;
	@Column(name = "count",nullable = false)
	private Integer count;
	public NgUserCreditStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgUserCreditStatus(Integer id, String username, String status, Integer count) {
		super();
		this.id = id;
		this.userName = username;
		this.status = status;
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "NgUserCreditStatus [id=" + id + ", username=" + userName + ", status=" + status + ", count=" + count
				+ "]";
	}

}
