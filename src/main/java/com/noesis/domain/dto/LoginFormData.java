package com.noesis.domain.dto;

import java.util.ArrayList;

public class LoginFormData {
		private String username;
		private String role;
		private String authToken;
		private String lastLoginTime;
		private String lastLoginIp;
		private ArrayList<String> userPrivileges;

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getAuthToken() {
			return authToken;
		}
		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}
		public String getLastLoginTime() {
			return lastLoginTime;
		}
		public void setLastLoginTime(String lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}
		public String getLastLoginIp() {
			return lastLoginIp;
		}
		public void setLastLoginIp(String lastLoginIp) {
			this.lastLoginIp = lastLoginIp;
		}
		public ArrayList<String> getUserPrivileges() {
			return userPrivileges;
		}
		public void setUserPrivileges(ArrayList<String> userPrivileges) {
			this.userPrivileges = userPrivileges;
		}
	
}
