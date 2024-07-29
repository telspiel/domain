package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class FailedDlrRetryService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String failedDlrRetryMapKey = "FAILED_DLR_RETRY_Map";
	
	private static final String failedDlrMessagePartCountyMapKey = "FAILED_DLR_MESSAGE_PART_COUNT_MAP";
	private static final String deliveredDlrMessagePartCountyMapKey = "DELIVERED_DLR_MESSAGE_PART_COUNT_MAP";
	
	@Autowired
	StringRedisTemplate stringTemplate; 

	public synchronized boolean saveFaileDlrRetryData(String requestId, String kannelId) {
		String failedDlrDataKey  = requestId+"!!!"+kannelId;
		stringTemplate.opsForHash().put(failedDlrRetryMapKey, failedDlrDataKey, kannelId);
		logger.info("Failed Dlr Retry Map Key Updated in redis : "+ failedDlrDataKey);
		return true;
	}
	
	public synchronized Integer saveMessagePartCountForFailedDlr(String requestId, String kannelId) {
		String failedDlrDataKey  = requestId+"!!!"+kannelId;
		if(stringTemplate.opsForHash().get(failedDlrMessagePartCountyMapKey, failedDlrDataKey)!=null) {
			Integer messagePartCount = Integer.parseInt((String)stringTemplate.opsForHash().get(failedDlrMessagePartCountyMapKey, failedDlrDataKey));
			logger.info("Failed DLR {} message part received for request id and kannel id {} and {}", messagePartCount, requestId, kannelId);
			messagePartCount++;
			stringTemplate.opsForHash().put(failedDlrMessagePartCountyMapKey, failedDlrDataKey, ""+messagePartCount.intValue());
			return messagePartCount;
		}else {
			stringTemplate.opsForHash().put(failedDlrMessagePartCountyMapKey, failedDlrDataKey, "1");
			logger.info("Failed DLR received for first part for request id and kannel id {} and {}", requestId, kannelId);
		}
		return 1;
	}
	
	public synchronized Integer saveMessagePartCountForDeliveredDlr(String requestId, String kannelId) {
		String deliveredDlrDataKey  = requestId+"!!!"+kannelId;
		if(stringTemplate.opsForHash().get(deliveredDlrMessagePartCountyMapKey, deliveredDlrDataKey)!=null) {
			Integer messagePartCount = Integer.parseInt((String)stringTemplate.opsForHash().get(deliveredDlrMessagePartCountyMapKey, deliveredDlrDataKey));
			logger.info("Delivered DLR {} message part received for request id and kannel id {} and {}", messagePartCount, requestId, kannelId);
			messagePartCount++;
			stringTemplate.opsForHash().put(deliveredDlrMessagePartCountyMapKey, deliveredDlrDataKey, ""+messagePartCount.intValue());
			return messagePartCount;
		}else {
			stringTemplate.opsForHash().put(deliveredDlrMessagePartCountyMapKey, deliveredDlrDataKey, "1");
			logger.info("Delivered DLR received for first part for request id and kannel id {} and {}", requestId, kannelId);
		}
		return 1;
	}

	public synchronized Integer getTotalFailedDlrReceived(String requestId, String kannelId) {
		String failedDlrDataKey  = requestId+"!!!"+kannelId;
		if(stringTemplate.opsForHash().get(failedDlrMessagePartCountyMapKey, failedDlrDataKey)!=null) {
			Integer messagePartCount = (Integer)stringTemplate.opsForHash().get(failedDlrMessagePartCountyMapKey, failedDlrDataKey);
			logger.info("Total failed dlr received for request id and kannel id {}, {} is : {}", requestId, kannelId, messagePartCount);
			return messagePartCount;
		}else {
			stringTemplate.opsForHash().put(failedDlrMessagePartCountyMapKey, failedDlrDataKey, 1);
			logger.info("Total failed dlr received for request id and kannel id {}, {} is : {}", requestId, kannelId, 1);
			return 1;
		}
	}
	
	public synchronized boolean isFailedDlrRetriedForKannel(String requestId, String kannelId) {
		String failedDlrDataKey  = requestId+"!!!"+kannelId; 
		if(stringTemplate.opsForHash().get(failedDlrRetryMapKey, failedDlrDataKey)!=null) {
			logger.info("Failed Dlr Retry key found in redis : "+ failedDlrDataKey);
			return true;
		}
		logger.info("Failed Dlr Retry key not found in redis : "+ failedDlrDataKey);
		return false;
	}
	
	public synchronized boolean isAnyDlrDeliveredForMessageAndKannel(String requestId, String kannelId) {
		String deliveredDlrDataKey  = requestId+"!!!"+kannelId;
		if(stringTemplate.opsForHash().get(deliveredDlrMessagePartCountyMapKey, deliveredDlrDataKey)!=null) {
			logger.info("Delivered dlr found for failed dlr for message : "+ deliveredDlrDataKey);
			return true;
		}
		logger.info("No delivered dlr found for Failed Dlr of message : "+ deliveredDlrDataKey);
		return false;
	}
}
 