package com.noesis.domain.dto;

import java.util.ArrayList;

public class HourlySummaryReportFormData {
	
	private Integer totalPageCount;
	
	private ArrayList<HourlySummaryMisFormResponseDataGrid> grid;
	
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public ArrayList<HourlySummaryMisFormResponseDataGrid> getGrid() {
		return grid;
	}
	public void setGrid(ArrayList<HourlySummaryMisFormResponseDataGrid> grid) {
		this.grid = grid;
	}
	
}
