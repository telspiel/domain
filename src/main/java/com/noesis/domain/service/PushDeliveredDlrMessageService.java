package com.noesis.domain.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgPushDlrDelivered;
import com.noesis.domain.repository.PushDeliveredDlrMessageRepository;

@Service
public class PushDeliveredDlrMessageService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PushDeliveredDlrMessageRepository pushDeliveredDlrMessageRepository;
	
	public void saveDeliveredDlrMessageObject (NgPushDlrDelivered ngPushDlrDelivered) {
		pushDeliveredDlrMessageRepository.save(ngPushDlrDelivered);
		logger.info("Delivered Dlr status message saved in db :  "+ngPushDlrDelivered);
	}
}
