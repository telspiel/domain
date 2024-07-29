package com.noesis.domain.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgMisData;
import com.noesis.domain.repository.NgMisDataRepository;

@Service
public class NgMisDataService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NgMisDataRepository ngMisDataRepository;
	
	public Iterable<NgMisData> getAllNgMisData(String username, Integer orgId) {
		

		Iterable<NgMisData> ngMisDataList =  ngMisDataRepository.findByIdOrgId(orgId);
		logger.info("Total records found in view: "+ngMisDataList);
		
		for (NgMisData misData : ngMisDataList) {
			
			logger.info("Total Submit Count is: "+misData.getId().getTotalDelivered());
		}
		return ngMisDataList;
	} 
}
