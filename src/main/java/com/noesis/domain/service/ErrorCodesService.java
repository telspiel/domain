package com.noesis.domain.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgErrorMaster;
import com.noesis.domain.repository.ErrorCodesRepository;


@Service
public class ErrorCodesService {

	//private static final Logger logger = LogManager.getLogger(ErrorCodesService.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ErrorCodesRepository errorCodesRepository;

	@Autowired
	StringRedisTemplate stringTemplate;

	public HashMap<Integer, String> getAllErrorCodes() {
		HashMap<Integer, String> errorCodesMap = new HashMap<>();
		Iterable<NgErrorMaster> errorCodesList = errorCodesRepository.findAll();
		logger.info("Loading all available error codes from DB.");
		for (NgErrorMaster ngErrorMaster : errorCodesList) {
			errorCodesMap.put(ngErrorMaster.getErrorCode(),ngErrorMaster.getErrorDesc());
		}
		return errorCodesMap;
	}
}
