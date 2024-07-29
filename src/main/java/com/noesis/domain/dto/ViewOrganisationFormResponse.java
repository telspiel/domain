package com.noesis.domain.dto;

public class ViewOrganisationFormResponse {
	
	private int code;
	private String result;
	private String message;
	private ViewOrganisationFormData data;
	
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
	public ViewOrganisationFormData getData() {
		return data;
	}
	public void setData(ViewOrganisationFormData data) {
		this.data = data;
	}
	
	

}
