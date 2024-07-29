package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgStatus;
import com.noesis.domain.repository.StatusRepository;

@Service
public class StatusService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StatusRepository statusRepository;

	public NgStatus getStatusByCode(String code) {
		NgStatus ngStatus = statusRepository.findByCode(code);
		return ngStatus;
	}
	
	public NgStatus getStatusByName(String code) {
		NgStatus ngStatus = statusRepository.findByDisplayName(code);
		return ngStatus;
	}
}
