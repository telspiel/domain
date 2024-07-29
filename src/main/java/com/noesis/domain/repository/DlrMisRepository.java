package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.domain.persistence.NgDlrMessage;

public interface DlrMisRepository extends CrudRepository<NgDlrMessage, Serializable> {

	NgDlrMessage findByMessageId(String messageId);

	@Modifying
	@Transactional
	@Query("UPDATE NgDlrMessage SET isDelivered = :isDelivered, retryStatus = :retryStatus, retryTimeStamp= :retryTimeStamp "
			+ "WHERE messageId = :messageId")
	Integer updateIsDeliveredFlag(@Param("isDelivered") char isDelivered, @Param("retryStatus") char retryStatus,
			@Param("retryTimeStamp") Date retryTimeStamp, @Param("messageId") String messageId);

}
