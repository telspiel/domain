package com.noesis.domain.dto;

public class UpdateUserPremiumFormResponse {
	
	private int code;
	private String result;
	private String message;
	private UpdateUserPremiumFormData data;
	
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
	public UpdateUserPremiumFormData getData() {
		return data;
	}
	public void setData(UpdateUserPremiumFormData data) {
		this.data = data;
	}
}
