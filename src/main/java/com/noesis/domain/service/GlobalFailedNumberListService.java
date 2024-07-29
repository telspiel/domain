package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class GlobalFailedNumberListService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	 
	@Autowired
	StringRedisTemplate secondaryStringTemplate; 

	public Boolean isFailedNumber(String number) {
		String key = "alwaysFailedNumberSetKey";
		logger.info(number + " is member of Falied Number List : " + secondaryStringTemplate.opsForSet().isMember(key, number));
		return secondaryStringTemplate.opsForSet().isMember(key, number);
	}
}
