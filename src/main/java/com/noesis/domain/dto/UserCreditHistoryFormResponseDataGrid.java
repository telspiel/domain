package com.noesis.domain.dto;

import java.util.Date;

public class UserCreditHistoryFormResponseDataGrid {

	private String createdDate;
	private String credit;
	private String status;
	private String updatedCredit;
	private String updatedBy;
	private String comment;
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUpdatedCredit() {
		return updatedCredit;
	}
	public void setUpdatedCredit(String updatedCredit) {
		this.updatedCredit = updatedCredit;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
