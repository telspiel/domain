package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDownloadReportInfo;
import com.noesis.domain.repository.NgDownloadReportInfoRepository;

@Service
public class NgDownloadReportInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgDownloadReportInfoRepository ngDownloadReportInfoRepository;
	
	public NgDownloadReportInfo findById(int id) {
		NgDownloadReportInfo ngDownloadReportInfo = ngDownloadReportInfoRepository.findById(id);
		return ngDownloadReportInfo;
	}

	public List<NgDownloadReportInfo> findByUserId(int userId) {
		List<NgDownloadReportInfo> ngDownloadReportInfoList = ngDownloadReportInfoRepository.findByUserId(userId);
		return ngDownloadReportInfoList;
	}

	public NgDownloadReportInfo saveDownloadReportRequest(NgDownloadReportInfo ngDownloadReportInfo){
		NgDownloadReportInfo downloadReportInfo = ngDownloadReportInfoRepository.save(ngDownloadReportInfo);
		return downloadReportInfo;
	}	
	
	public NgDownloadReportInfo updateProcessFlagForDownloadReportInfo(NgDownloadReportInfo ngDownloadReportInfo){
		NgDownloadReportInfo downloadReportInfo = ngDownloadReportInfoRepository.save(ngDownloadReportInfo);
		return downloadReportInfo;
	}
	
	public NgDownloadReportInfo getDownloadReportInfoToBeProcessed(char status) {
		Pageable pageable = new PageRequest(0, 1);
		List<NgDownloadReportInfo> ngDownloadReportInfoList = ngDownloadReportInfoRepository.findByStatus(status, pageable);
		if(ngDownloadReportInfoList != null && ngDownloadReportInfoList.size()>=1) {
			return ngDownloadReportInfoList.get(0);
		}
		return null;
	}
}
