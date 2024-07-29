package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PreferenceDndListService {
	private static final Logger logger = LoggerFactory.getLogger(PreferenceDndListService.class);
	@Autowired
	StringRedisTemplate stringTemplate;

	public Boolean isPrefDndNumber(String number) {
		String key = "PrefNumberSetKey";
		logger.info(number + " is member of Preference Dnd List : " + stringTemplate.opsForSet().isMember(key, number));
		return stringTemplate.opsForSet().isMember(key, number);
	}
	public boolean clearAllDndDataFromCache() {
		String key = "PrefNumberSetKey";
		stringTemplate.opsForSet().getOperations().delete(key);
		return true;
	}
 

}
