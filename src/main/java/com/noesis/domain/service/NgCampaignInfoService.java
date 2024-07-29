package com.noesis.domain.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgCampaignInfo;
import com.noesis.domain.repository.NgCampaignInfoRepository;

@Service
public class NgCampaignInfoService {
	
	@Autowired
	NgCampaignInfoRepository ngCampaignInfoRepository;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<NgCampaignInfo> getAllScheduledCampaignData(int userId) {
		List<NgCampaignInfo> ngCampaignList =  ngCampaignInfoRepository.findByUserId(userId);
		logger.info("Total records found in view: "+ ngCampaignList);
		return ngCampaignList;
	}
	
	public NgCampaignInfo removeCampaignFromUserCampaignList(int id) {
		NgCampaignInfo ngCampaignInfo = ngCampaignInfoRepository.findById(id);
		ngCampaignInfoRepository.delete(ngCampaignInfo);
		return ngCampaignInfo;
	}
	
	public NgCampaignInfo saveCampaignInfo(NgCampaignInfo ngCampaignInfo) {
		NgCampaignInfo savedNgCampaignInfo = ngCampaignInfoRepository.save(ngCampaignInfo);
		return savedNgCampaignInfo;
	}
}
