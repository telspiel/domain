package com.noesis.domain.dto;

import java.util.ArrayList;

public class UserCreditHistoryFormData {
	private Integer totalPageCount;	
	private ArrayList<UserCreditHistoryFormResponseDataGrid> grid;
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public ArrayList<UserCreditHistoryFormResponseDataGrid> getGrid() {
		return grid;
	}
	public void setGrid(ArrayList<UserCreditHistoryFormResponseDataGrid> grid) {
		this.grid = grid;
	}
	
}
