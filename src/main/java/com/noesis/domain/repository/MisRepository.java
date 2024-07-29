package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.noesis.domain.dto.DetailedMISQueryDTO;
import com.noesis.domain.dto.SmsCountQueryDTO;
import com.noesis.domain.persistence.NgMisMessage;

public interface MisRepository extends CrudRepository<NgMisMessage, Serializable> {
	
	@Query(value = "select m.receivedTs as receivedTs, m.messageId as messageId, m.mobileNumber as mobileNumber, "+
			"m.status as status, m.errorCode as errorCode, m.sentTs as sentTs, m.senderId as senderId, d.statusId as statusId,"
			+ "d.statusDesc as statusDesc, d.deliveredTs as deliveredTs " 
			+ "from NgMisMessage m, NgDlrMessage d where m.userId = :userId and d.messageId = m.messageId" )
	public List<DetailedMISQueryDTO> getMisDataForUser(@Param("userId") int userId);
	
	@Query(value = "select m.receivedTs as receivedTs, m.messageId as messageId, m.mobileNumber as mobileNumber, "+
			"m.status as status, m.errorCode as errorCode, m.sentTs as sentTs, m.senderId as senderId, d.statusId as statusId,"
			+ "d.statusDesc as statusDesc, d.deliveredTs as deliveredTs " 
			+ "from NgMisMessage m, NgDlrMessage d where m.userId = :userId and d.messageId = m.messageId and m.mobileNumber = :mobileNumber" )
	public List<DetailedMISQueryDTO> getMisDataForUserForMobileNumber(@Param("userId") int userId, @Param("mobileNumber") String mobileNumber);
	

	@Query(value = "select count(*) from NgMisMessage m  where m.userId = :userId ") 
	public SmsCountQueryDTO getSmsCountForUser(int userId);
}

