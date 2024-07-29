package com.noesis.domain.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDlrUndeliveredRetry;
import com.noesis.domain.repository.DlrMisRetryRepository;

@Service
public class DlrMisRetryService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DlrMisRetryRepository dlrMisRetryRepository;

	public void saveDlrMisRetryObjectInBulk(List<NgDlrUndeliveredRetry> dlrMisUndeliveredRetryObjectList) {
		dlrMisRetryRepository.save(dlrMisUndeliveredRetryObjectList);
		logger.info("MIS Retry Message saved in db :  " + dlrMisUndeliveredRetryObjectList);
	}

	public void deliveredRetryDataRemove(String messageId) {
		dlrMisRetryRepository.deliveredRetryDataRemove(messageId);
		logger.info("MIS Message saved in db :  " + messageId);
	}

	public List<NgDlrUndeliveredRetry> getUndeliveredDlrList(char isDelivered, char retryStatus, int rertyCount,
			String messageSource, Timestamp dateTime) {
		List<NgDlrUndeliveredRetry> ngDlrUndeliveredObjectList = dlrMisRetryRepository
				.getUndeliveredDlrList(isDelivered, retryStatus, rertyCount, messageSource);
		logger.info("Undelivered DLR Message object List:  " + ngDlrUndeliveredObjectList);
		return ngDlrUndeliveredObjectList;
	}

	public void updateDlrStatusAndCount(NgDlrUndeliveredRetry dlrList) {
		dlrMisRetryRepository.updateDlrStatusAndCount(dlrList.getRetryStatus(), dlrList.getRetryCount(),
				dlrList.getRetryTimeStamp(), dlrList.getMessageId());
		logger.info("Failed DLR Message object updateDlrStatusAndCount: " + dlrList);
	}

	public int retryDlrStatusUpdate(int retryCount, Date ts) {
		logger.info("Failed DLR Message object retryDlrStatusUpdate: ");
		// Date toDate = new Date(System.currentTimeMillis() -
		// TimeUnit.MINUTES.toMillis(5));
		// Timestamp ts = new Timestamp(toDate.getTime());
		// Date ts = new Timestamp(System.currentTimeMillis());
		return dlrMisRetryRepository.retryDlrStatusUpdate('N', ts, 'N', 'P', retryCount);

	}

}
