package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgAnalyticsCurrDate;
import com.noesis.domain.repository.NgAnalyticsCurrDateRepository;

@Service
public class NgAnalyticsCurrDateService {

	@Autowired
	private NgAnalyticsCurrDateRepository ngAnalyticsCurrDateRepository;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public NgAnalyticsCurrDate save(NgAnalyticsCurrDate ngAnalysisCurrDate) {
		NgAnalyticsCurrDate savedNgAnalyticsCurrDate =  ngAnalyticsCurrDateRepository.save(ngAnalysisCurrDate);
		return savedNgAnalyticsCurrDate;
	}
	
	public List<NgAnalyticsCurrDate> getAllAnalyticsData(int userId) {
		List<NgAnalyticsCurrDate> ngAnalyticsReportList =  ngAnalyticsCurrDateRepository.findByUserId(userId);
		logger.info("Total records found in view: "+ ngAnalyticsReportList);
		return ngAnalyticsReportList;
	}
}
