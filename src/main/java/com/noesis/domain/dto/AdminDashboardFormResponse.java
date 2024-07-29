package com.noesis.domain.dto;

public class AdminDashboardFormResponse {

	private int code;
	private String result;
	private String message;
	private AdminDashboardFormData data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AdminDashboardFormData getData() {
		return data;
	}
	public void setData(AdminDashboardFormData data) {
		this.data = data;
	}
	
	
}
