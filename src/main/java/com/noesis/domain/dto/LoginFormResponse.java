package com.noesis.domain.dto;

public class LoginFormResponse {
	private int code;
	private String result;
	private String message;
	private LoginFormData data;
	private boolean otpRequired;
	private long otpExpiryTime;
	private String authJwtToken;
	
	public boolean isOtpRequired() {
		return otpRequired;
	}

	public void setOtpRequired(boolean otpRequired) {
		this.otpRequired = otpRequired;
	}

	public long getOtpExpiryTime() {
		return otpExpiryTime;
	}

	public void setOtpExpiryTime(long otpExpiryTime) {
		this.otpExpiryTime = otpExpiryTime;
	}

	public String getAuthJwtToken() {
		return authJwtToken;
	}

	public void setAuthJwtToken(String authJwtToken) {
		this.authJwtToken = authJwtToken;
	}

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

	public LoginFormData getData() {
		return data;
	}

	public void setData(LoginFormData data) {
		this.data = data;
	}
	
	
	
}

