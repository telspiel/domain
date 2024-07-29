package com.noesis.domain.response;

public class NgBulkSenderIdResponse {
	
	private int code;
	private Integer totalCount;
	private Integer duplicateCount;
	private Integer countSaved;
	private String result;
	private String message;
	public NgBulkSenderIdResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgBulkSenderIdResponse(int code, Integer totalCount, Integer duplicateCount, Integer countSaved,
			String result, String message) {
		super();
		this.code = code;
		this.totalCount = totalCount;
		this.duplicateCount = duplicateCount;
		this.countSaved = countSaved;
		this.result = result;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getDuplicateCount() {
		return duplicateCount;
	}
	public void setDuplicateCount(Integer duplicateCount) {
		this.duplicateCount = duplicateCount;
	}
	public Integer getCountSaved() {
		return countSaved;
	}
	public void setCountSaved(Integer countSaved) {
		this.countSaved = countSaved;
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
	
	
	
	
	

}
