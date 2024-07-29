package com.noesis.domain.dto;

public class UpdateAvailableCreditFormResponse {
	
	private int code;
	private String result;
	private String message;
	private UpdateAvailableCreditFormData data;
	
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
	public UpdateAvailableCreditFormData getData() {
		return data;
	}
	public void setData(UpdateAvailableCreditFormData data) {
		this.data = data;
	}
	
	

}
