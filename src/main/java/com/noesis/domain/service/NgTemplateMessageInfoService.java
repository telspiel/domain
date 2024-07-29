package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgFileUploadInfo;
import com.noesis.domain.persistence.NgTemplateMessageInfo;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgFileUploadInfoRepository;
import com.noesis.domain.repository.NgTemplateMessageInfoRepository;

@Service
public class NgTemplateMessageInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgTemplateMessageInfoRepository ngTemplateMessageInfoRepository;
	
	public NgTemplateMessageInfo saveTemplateMessageInfo(NgTemplateMessageInfo templateMessageInfo) {
		NgTemplateMessageInfo savedTemplateMessageInfo = ngTemplateMessageInfoRepository.save(templateMessageInfo);
		return savedTemplateMessageInfo;
	}
	
	public NgTemplateMessageInfo getTemplateMessageInfoForUserAndFileName(NgUser ngUser, String serverFileName) {
		NgTemplateMessageInfo ngTemplateMessageInfo = ngTemplateMessageInfoRepository.findByNgUserAndServerFileName(ngUser, serverFileName);
		return ngTemplateMessageInfo;
	}
	
	public NgTemplateMessageInfo getTemplateMessageInfoById(Integer templateMessageInfoId) {
		NgTemplateMessageInfo ngTemplateMessageInfo = ngTemplateMessageInfoRepository.findById(templateMessageInfoId);
		return ngTemplateMessageInfo;
	}

}
