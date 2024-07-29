package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgFileUploadInfo;
import com.noesis.domain.repository.NgFileUploadInfoRepository;

@Service
public class NgFileUploadInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgFileUploadInfoRepository ngFileUploadInfoRepository;
	
	public NgFileUploadInfo findByFileUpload(int id) {
		NgFileUploadInfo ngFileUploadInfo = ngFileUploadInfoRepository.findById(id);
		return ngFileUploadInfo;
	}
	
	public NgFileUploadInfo saveFileUploadInfo(NgFileUploadInfo ngFileUploadInfo) {
		NgFileUploadInfo fileUploadInfo = ngFileUploadInfoRepository.save(ngFileUploadInfo);
		return fileUploadInfo;
	}

}
