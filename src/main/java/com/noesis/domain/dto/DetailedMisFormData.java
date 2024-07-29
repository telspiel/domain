package com.noesis.domain.dto;

import java.util.ArrayList;

public class DetailedMisFormData {
	
	private Integer totalPageCount;
	private String downloadReportLink;
	private ArrayList<DetailedMisFormResponseDataGrid> grid;
	
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public ArrayList<DetailedMisFormResponseDataGrid> getGrid() {
		return grid;
	}
	public void setGrid(ArrayList<DetailedMisFormResponseDataGrid> grid) {
		this.grid = grid;
	}
	public String getDownloadReportLink() {
		return downloadReportLink;
	}
	public void setDownloadReportLink(String downloadReportLink) {
		this.downloadReportLink = downloadReportLink;
	}
	
}
