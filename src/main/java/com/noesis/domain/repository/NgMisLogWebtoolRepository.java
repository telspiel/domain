package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgMisLogWebtool;

public interface NgMisLogWebtoolRepository extends CrudRepository<NgMisLogWebtool, Serializable>{
	
	public List<NgMisLogWebtool> findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqual(String userName, Date fromDate, Date toDate);
	public List<NgMisLogWebtool> findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqualAndMobileNumber(String userName, Date fromDate, Date toDate, String mobileNumber);

	public List<NgMisLogWebtool> findByUserName(String userName);
	
	Long countByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqual(String userName, Date fromDate, Date toDate);
	public List<NgMisLogWebtool> findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqualAndSenderId(String userName,
			Date finalFromDate, Date finalToDate, String senderId);
	public List<NgMisLogWebtool> findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqualAndSenderIdAndMobileNumber(
			String userName, Date finalFromDate, Date finalToDate, String senderId, String mobileNumber);

}

