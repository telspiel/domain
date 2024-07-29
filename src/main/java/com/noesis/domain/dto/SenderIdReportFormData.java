package com.noesis.domain.dto;

import java.util.ArrayList;

public class SenderIdReportFormData {
	
	private Integer totalPageCount;
	private String downloadReportLink;
	private ArrayList<SenderIdMisFormResponseDataGrid> grid;
	
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public String getDownloadReportLink() {
		return downloadReportLink;
	}
	public void setDownloadReportLink(String downloadReportLink) {
		this.downloadReportLink = downloadReportLink;
	}
	public ArrayList<SenderIdMisFormResponseDataGrid> getGrid() {
		return grid;
	}
	public void setGrid(ArrayList<SenderIdMisFormResponseDataGrid> grid) {
		this.grid = grid;
	}

}
