package com.noesis.domain.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgPushDlrFailed;
import com.noesis.domain.repository.PushFailedDlrMessageRepository;

@Service
public class PushFailedDlrMessageService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PushFailedDlrMessageRepository pushFailedDlrMessageRepository;
	
	public void saveFailedDlrMessageObject (NgPushDlrFailed ngPushDlrFailed) {
		pushFailedDlrMessageRepository.save(ngPushDlrFailed);
		logger.info("Failed DLR Status Message saved in db :  "+ngPushDlrFailed);
	}
}
