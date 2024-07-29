package com.noesis.domain.dto;

import java.util.ArrayList;

public class SummaryReportFormData {
	
	private Integer totalPageCount;
	private String downloadReportLink;
	private ArrayList<SummaryMisFormResponseDataGrid> grid;
	
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public ArrayList<SummaryMisFormResponseDataGrid> getGrid() {
		return grid;
	}
	public void setGrid(ArrayList<SummaryMisFormResponseDataGrid> grid) {
		this.grid = grid;
	}
	public String getDownloadReportLink() {
		return downloadReportLink;
	}
	public void setDownloadReportLink(String downloadReportLink) {
		this.downloadReportLink = downloadReportLink;
	}
}
