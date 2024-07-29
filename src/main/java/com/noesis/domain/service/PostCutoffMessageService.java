package com.noesis.domain.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgPostCutoffMessage;
import com.noesis.domain.repository.PostCutoffMessageRepository;

@Service
public class PostCutoffMessageService {

	//private static final Logger logger = LogManager.getLogger(PostCutoffMessageService.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PostCutoffMessageRepository postCutoffMessageRepository;

	public void savePostCutoffMessage (NgPostCutoffMessage ngPostCutoffMessage) {
		postCutoffMessageRepository.save(ngPostCutoffMessage);
		logger.info("Saving Post CutOff Message {} "+ngPostCutoffMessage.getMessageObject());
	}
}
