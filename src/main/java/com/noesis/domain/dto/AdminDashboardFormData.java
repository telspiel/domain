package com.noesis.domain.dto;

import java.util.ArrayList;

public class AdminDashboardFormData {
	
	private ArrayList<AdminDashboardFormResponseDataGrid> grid;
	
	private String username;
	private String role;
	private String authToken;

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

	public ArrayList<AdminDashboardFormResponseDataGrid> getGrid() {
		return grid;
	}

	public void setGrid(ArrayList<AdminDashboardFormResponseDataGrid> grid) {
		this.grid = grid;
	}

	
	
	
}
