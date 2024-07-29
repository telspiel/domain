package com.noesis.domain.dto;

public class SenderIdReportFormResponse {
	
	private int code;
	private String result;
	private String message;
	private SenderIdReportFormData data;
	
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
	public SenderIdReportFormData getData() {
		return data;
	}
	public void setData(SenderIdReportFormData data) {
		this.data = data;
	}
}
