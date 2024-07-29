package com.noesis.domain.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgAnalyticsSummary;
import com.noesis.domain.repository.NgAnalyticsSummaryRepository;

@Service
public class NgAnalyticsSummaryService {
	
	@Autowired
	NgAnalyticsSummaryRepository ngAnalyticsSummaryRepository;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<NgAnalyticsSummary> getAllNgAnalyticsSummaryData(String userName) {
		List<NgAnalyticsSummary> ngAnalyticsSummaryReportList =  ngAnalyticsSummaryRepository.findByUserName(userName);
		logger.info("Total records found in view: "+ngAnalyticsSummaryReportList);
		return ngAnalyticsSummaryReportList;
	}

	
}
