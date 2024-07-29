package com.noesis.domain.dto;

public class UpdateAbusingWordFormResponse {
	
	private int code;
	private String result;
	private String message;
	private UpdateAbusingWordFormData data;
	
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
	public UpdateAbusingWordFormData getData() {
		return data;
	}
	public void setData(UpdateAbusingWordFormData data) {
		this.data = data;
	}
}
