package com.noesis.domain.dto;

public class SaveUserFormResponse {
	
	private int code;
	private String result;
	private String message;
	private SaveUserFormData data;
	
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
	public SaveUserFormData getData() {
		return data;
	}
	public void setData(SaveUserFormData data) {
		this.data = data;
	}
	
	

}
