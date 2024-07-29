package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDynamicMessageInfo;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgDynamicMessageInfoRepository;

@Service
public class NgDynamicMessageInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgDynamicMessageInfoRepository ngDynamicMessageInfoRepository;
	
	public NgDynamicMessageInfo saveDynamicMessageInfo(NgDynamicMessageInfo DynamicMessageInfo) {
		NgDynamicMessageInfo savedDynamicMessageInfo = ngDynamicMessageInfoRepository.save(DynamicMessageInfo);
		return savedDynamicMessageInfo;
	}
	
	public NgDynamicMessageInfo getDynamicMessageInfoForUserAndFileName(NgUser ngUser, String serverFileName) {
		NgDynamicMessageInfo ngDynamicMessageInfo = ngDynamicMessageInfoRepository.findByNgUserAndServerFileName(ngUser, serverFileName);
		return ngDynamicMessageInfo;
	}
	
	public NgDynamicMessageInfo getDynamicMessageInfoById(Integer DynamicMessageInfoId) {
		NgDynamicMessageInfo ngDynamicMessageInfo = ngDynamicMessageInfoRepository.findById(DynamicMessageInfoId);
		return ngDynamicMessageInfo;
	}

}
