package com.noesis.domain.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDlrFailed;
import com.noesis.domain.repository.FailedDlrMessageRepository;

@Service
public class FailedDlrMessageService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private FailedDlrMessageRepository failedDlrMessageRepository;
	
	public void saveFailedDlrMessageObject (NgDlrFailed ngDlrFailed) {
		failedDlrMessageRepository.save(ngDlrFailed);
		logger.info("Failed DLR Status Message saved in db :  "+ngDlrFailed);
	}
	
	public NgDlrFailed getFailedDlrMessageObject (String messageId) {
		NgDlrFailed ngDlrFailedObject = failedDlrMessageRepository.findByMessageId(messageId);
		logger.info("Failed DLR Message object :  "+ngDlrFailedObject);
		return ngDlrFailedObject;
	}
	
	public NgDlrFailed getFailedDlrMessageIdAndRetriedStatus (String messageId, char isRetried) {
		NgDlrFailed ngDlrFailedObject = failedDlrMessageRepository.findByMessageIdAndIsRetried(messageId, isRetried);
		logger.info("Failed DLR Message object :  "+ngDlrFailedObject);
		return ngDlrFailedObject;
	}
	
	public List<NgDlrFailed> getFailedDlrListByUserId (int userId, char isRetried, int rowLimit) {
		Pageable pageable = new PageRequest(0, rowLimit);
		List<NgDlrFailed> ngDlrFailedObjectList = failedDlrMessageRepository.findByUserIdAndIsRetried(userId, isRetried, pageable);
		logger.info("Failed DLR Message object :  "+ngDlrFailedObjectList);
		return ngDlrFailedObjectList;
	}
	

	public void saveFailedDlrList (List<NgDlrFailed> ngDlrFailedList) {
		failedDlrMessageRepository.save(ngDlrFailedList);
		logger.info("Failed DLR Status Message saved in db successfully.");
	}
	
	public List<NgDlrFailed> getFailedDlrList (char isRetried, int rowLimit) {
		Pageable pageable = new PageRequest(0, rowLimit);
		List<NgDlrFailed> ngDlrFailedObjectList = failedDlrMessageRepository.findByIsRetried(isRetried, pageable);
		logger.info("Failed DLR Message object :  "+ngDlrFailedObjectList);
		return ngDlrFailedObjectList;
	}
	
}
