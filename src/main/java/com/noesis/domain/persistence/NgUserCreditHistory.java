package com.noesis.domain.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ng_user_credit_history", catalog = "genesis")
public class NgUserCreditHistory {

	private int id;
	private Integer userId;
	private Date createdDate;
	private Integer credit;
	private String status;
	private Integer updatedCredit;
	private String updatedBy;
	private String notes;

	public NgUserCreditHistory() {
	}

	public NgUserCreditHistory(int id, Integer userId, Date createdDate, Integer credit, String status,
			Integer updatedCredit, String updatedBy, String notes) {
		this.id = id;
		this.userId = userId;
		this.createdDate = createdDate;
		this.credit = credit;
		this.status = status;
		this.updatedCredit = updatedCredit;
		this.updatedBy = updatedBy;
		this.notes = notes;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}

	@Column(name = "credit")
	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "updated_credit")
	public Integer getUpdatedCredit() {
		return updatedCredit;
	}

	public void setUpdatedCredit(Integer updatedCredit) {
		this.updatedCredit = updatedCredit;
	}

	@Column(name = "updated_by")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
