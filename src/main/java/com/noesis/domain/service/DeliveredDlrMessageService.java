package com.noesis.domain.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDlrDelivered;
import com.noesis.domain.repository.DeliveredDlrMessageRepository;

@Service
public class DeliveredDlrMessageService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DeliveredDlrMessageRepository deliveredDlrMessageRepository;
	
	public void saveDeliveredDlrMessageObject (NgDlrDelivered ngDlrDelivered) {
		deliveredDlrMessageRepository.save(ngDlrDelivered);
		logger.info("Delivered Dlr status message saved in db :  "+ngDlrDelivered);
	}
}
