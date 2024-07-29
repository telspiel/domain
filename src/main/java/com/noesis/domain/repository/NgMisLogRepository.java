package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgMisLog;



public interface NgMisLogRepository extends CrudRepository<NgMisLog, Serializable> {
	public List<NgMisLog> findByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThan(String userName, Date fromDate, Date toDate);
	public List<NgMisLog> findByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThanAndMobileNumber(String userName, Date fromDate, Date toDate, String mobileNumber);

	public List<NgMisLog> findByUserName(String userName);
	
	Long countByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThan(String userName, Date fromDate, Date toDate);
	
	public List<NgMisLog> findByUserNameAndSenderIdAndMessageIdIn(String userName, String senderId, List<String> messageIds);
	
	
}

