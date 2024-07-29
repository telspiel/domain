package com.noesis.domain.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.dto.DetailedMISQueryDTO;
import com.noesis.domain.dto.SmsCountQueryDTO;
import com.noesis.domain.persistence.NgMisMessage;
import com.noesis.domain.repository.MisRepository;

@Service
public class MisService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MisRepository misRepository;
	
	/*@Autowired
	private MisCurrentDateRepository misCurrentDateRepository;
	*/
	 @Autowired 
	 private RedisTemplate<String, NgMisMessage> redisTemplateForMis;

	public void saveMessageInMis (NgMisMessage misMessageObject) {
		//misRepository.save(misMessageObject);
		redisTemplateForMis.opsForList().rightPush("list:mis:object",misMessageObject);
		logger.info("MIS Message saved in redis list :  "+misMessageObject);
	}
	
	public void saveMisMessageObject (NgMisMessage misMessageObject) {
		misRepository.save(misMessageObject);
		logger.info("MIS Message saved in db :  "+misMessageObject);
	}
	
	public void saveMisMessageObjectinBulk (List<NgMisMessage> misMessageObjectList) {
		misRepository.save(misMessageObjectList);
		//logger.info("MIS Message saved in db :  ");
	}
	
/*	public void saveMisCurrentDateMessageObjectinBulk (List<NgMisMessageCurrentDate> misMessageObjectList) {
		misCurrentDateRepository.save(misMessageObjectList);
	}
*/	
	public List<DetailedMISQueryDTO> getMisDataForUser(int userId){
		List<DetailedMISQueryDTO> misList = misRepository.getMisDataForUser(userId);
		logger.info("MIS List Size is : "+misList.size());
		for (DetailedMISQueryDTO ngMisMessage : misList) {
			logger.info("Mis message id is: "+ngMisMessage.getMessageId());
			
		}
		return misList;
	}
	
	public List<DetailedMISQueryDTO> getMisDataForUserAndMobileNumber(int userId, String mobileNumber){
		List<DetailedMISQueryDTO> misList = misRepository.getMisDataForUserForMobileNumber(userId, mobileNumber);
		logger.info("MIS List Size is : "+misList.size());
		for (DetailedMISQueryDTO ngMisMessage : misList) {
			logger.info("Mis message id is: "+ngMisMessage.getMessageId());
			
		}
		return misList;
	}

	public SmsCountQueryDTO getSmsCountForUser(int userId) {
		SmsCountQueryDTO smsCount =  misRepository.getSmsCountForUser(userId);
		
		logger.info("SMS Count Today : "+smsCount.getTotalSmsToday());
		logger.info("SMS Count in the week : "+smsCount.getTotalSmsWeek());
		logger.info("SMS Count in the month : "+smsCount.getTotalSmsMonth());
		logger.info("SMS Count in two months : "+smsCount.getTotalSmsTwoMonths());
		
		return smsCount;
		
	}
}
