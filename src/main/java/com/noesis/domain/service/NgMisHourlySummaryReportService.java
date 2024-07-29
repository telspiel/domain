package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgMisHourlySummaryReport;
import com.noesis.domain.repository.NgMisHourlySummaryRepository;
@Service
public class NgMisHourlySummaryReportService {
	
	@Autowired
	private NgMisHourlySummaryRepository ngMisHourlySummaryRepository;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<NgMisHourlySummaryReport> getAllNgMisHourlySummaryData(String userName) {
		List<NgMisHourlySummaryReport> ngSummaryReportList =  ngMisHourlySummaryRepository.findByUserNameOrderByHour(userName);
		logger.info("Total records found in view: "+ngSummaryReportList);
		return ngSummaryReportList;
	}
	
	//Hourly Summary
	
	public List<NgMisHourlySummaryReport> getAllNgMisHourlySummaryDataForParent(int paId) {
		List<NgMisHourlySummaryReport> ngSummaryReportList =  ngMisHourlySummaryRepository.findByPaIdOrderByHour(paId);
		logger.info("Total records found in view: "+ngSummaryReportList);
		return ngSummaryReportList;
	}
	
	public List<NgMisHourlySummaryReport> getAllNgMisHourlySummaryDataForSuperAdmin(int saId) {
		List<NgMisHourlySummaryReport> ngSummaryReportList =  ngMisHourlySummaryRepository.findBySaIdOrderByHour(saId);
		logger.info("Total records found in view: "+ngSummaryReportList);
		return ngSummaryReportList;
	}
	
	public List<NgMisHourlySummaryReport> getAllNgMisHourlySummaryDataForAdmin(int adId) {
		List<NgMisHourlySummaryReport> ngSummaryReportList =  ngMisHourlySummaryRepository.findByAdIdOrderByHour(adId);
		logger.info("Total records found in view: "+ngSummaryReportList);
		return ngSummaryReportList;
	}
	
	public List<NgMisHourlySummaryReport> getAllNgMisHourlySummaryDataForReseller(int reId) {
		List<NgMisHourlySummaryReport> ngSummaryReportList =  ngMisHourlySummaryRepository.findByReIdOrderByHour(reId);
		logger.info("Total records found in view: "+ngSummaryReportList);
		return ngSummaryReportList;
	}
	
	public List<NgMisHourlySummaryReport> getAllNgMisHourlySummaryDataForSeller(int seId) {
		List<NgMisHourlySummaryReport> ngSummaryReportList =  ngMisHourlySummaryRepository.findBySeIdOrderByHour(seId);
		logger.info("Total records found in view: "+ngSummaryReportList);
		return ngSummaryReportList;
	}
	
	public List<NgMisHourlySummaryReport> getAllNgMisHourlySummaryDataForAccountManager(int amId) {
		List<NgMisHourlySummaryReport> ngSummaryReportList =  ngMisHourlySummaryRepository.findByAmIdOrderByHour(amId);
		logger.info("Total records found in view: "+ngSummaryReportList);
		return ngSummaryReportList;
	}
}
