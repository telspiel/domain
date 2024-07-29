package com.noesis.domain.platform;

public class DlrRetryMessageObject {

	private boolean isUserWiseRetry;

	private boolean isAllDlrRetry;

	private String userId;

	public boolean isUserWiseRetry() {
		return isUserWiseRetry;
	}

	public void setUserWiseRetry(boolean isUserWiseRetry) {
		this.isUserWiseRetry = isUserWiseRetry;
	}

	public boolean isAllDlrRetry() {
		return isAllDlrRetry;
	}

	public void setAllDlrRetry(boolean isAllDlrRetry) {
		this.isAllDlrRetry = isAllDlrRetry;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
