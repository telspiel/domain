package com.noesis.domain.service;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noesis.domain.dto.UpdateDlrRetryData;
import com.noesis.domain.persistence.NgDlrFailed;
import com.noesis.domain.persistence.NgDlrMessage;
import com.noesis.domain.persistence.NgDlrRetryAll;
import com.noesis.domain.persistence.NgDlrRetryTmp;
import com.noesis.domain.repository.AllDlrMisRepository;
import com.noesis.domain.repository.DlrMisRepository;
import com.noesis.domain.repository.DlrRetryMisTempRepository;

@Service
public class DlrMisService {

	// private static final Logger logger = LogManager.getLogger(MisService.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DlrMisRepository dlrMisRepository;

	/*
	 * @Autowired private DlrMisCurrentDateRepository dlrCurrentDateMisRepository;
	 */
	@Autowired
	private AllDlrMisRepository allDlrMisRepository;

	@Autowired
	private DlrRetryMisTempRepository dlrRetryMisTempRepository;

	/*
	 * @Autowired private RedisTemplate<String, NgDlrMessage> redisTemplateForMis;
	 * 
	 * public void saveDlrMessageInMis (NgDlrMessage dlrMisMessageObject) {
	 * //misRepository.save(misMessageObject);
	 * redisTemplateForMis.opsForList().rightPush("list:dlr:mis:object",
	 * dlrMisMessageObject);
	 * logger.info("DLR MIS Message saved in redis list :  "+dlrMisMessageObject); }
	 */

	public void saveDlrMisMessageObject(NgDlrMessage dlrMisMessageObject) {
		dlrMisRepository.save(dlrMisMessageObject);
		logger.info("MIS Message saved in db :  " + dlrMisMessageObject);
	}

	public void saveDlrMisMessageObjectInBulk(List<NgDlrMessage> dlrMisMessageObjectList) {
		dlrMisRepository.save(dlrMisMessageObjectList);
		// logger.info("MIS Message saved in db : "+dlrMisMessageObject);
	}

	/*
	 * public void saveDlrMisCurrentDateMessageObjectInBulk
	 * (List<NgDlrMessageCurrentDate> dlrMisMessageObjectList) {
	 * dlrCurrentDateMisRepository.save(dlrMisMessageObjectList);
	 * logger.info("MIS Message saved in db :  "+dlrMisMessageObject); }
	 */

	public void saveAllDlrMisMessageObject(NgDlrRetryAll allDlrMisMessageObject) {
		allDlrMisRepository.save(allDlrMisMessageObject);
		logger.info("MIS Message saved in db :  " + allDlrMisMessageObject);
	}

	public void saveAllDlrMisMessageObjectInBulk(List<NgDlrRetryAll> allDlrMisMessageObjectList) {
		allDlrMisRepository.save(allDlrMisMessageObjectList);
		// logger.info("MIS Message saved in db : "+allDlrMisMessageObject);
	}

	public NgDlrMessage getDlrMisMessageFromMessageId(String messageId) {
		NgDlrMessage ngDlrMessage = dlrMisRepository.findByMessageId(messageId);
		logger.info("Getting dlr from dlr mis table :  " + ngDlrMessage);
		return ngDlrMessage;
	}

	public NgDlrRetryTmp getDlrMisMessageFromTmpMessageId(String messageId) {
		NgDlrRetryTmp ngDlrMessage = dlrRetryMisTempRepository.findByMessageId(messageId);
		logger.info("Getting dlr from dlr mis tmp table :  " + ngDlrMessage);
		return ngDlrMessage;
	}

	public Integer updateDeliveredFlag(String messageId, char isDelivered, Date retryTimeStamp, char retryStatus) {
		logger.info("UpdateIsDeliveredFlag dlr from DlrMisRepository:  " + messageId + " :::" + retryStatus);
		return dlrMisRepository.updateIsDeliveredFlag( isDelivered, retryStatus, retryTimeStamp, messageId);
	}

}
