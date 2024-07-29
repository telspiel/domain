package com.noesis.domain.dto;

public class UpdateUserBlackListSenderIdFormResponse {
	
	private int code;
	private String result;
	private String message;
	private UpdateUserBlackListSenderIdFormData data;
	
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
	public UpdateUserBlackListSenderIdFormData getData() {
		return data;
	}
	public void setData(UpdateUserBlackListSenderIdFormData data) {
		this.data = data;
	}
}
