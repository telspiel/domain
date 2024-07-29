package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.domain.persistence.NgDlrUndeliveredRetry;

public interface DlrMisRetryRepository extends CrudRepository<NgDlrUndeliveredRetry, Serializable> {

	@Query(value = "select ng from NgDlrUndeliveredRetry ng "
			+ "where ng.isDelivered =:isDelivered and ng.retryStatus =:retryStatus and ng.retryCount <:retryCount "
			+ "and ng.messageSource like %:messageSource% ")
	List<NgDlrUndeliveredRetry> getUndeliveredDlrList(@Param("isDelivered") char isDelivered,
			@Param("retryStatus") char retryStatus, @Param("retryCount") int retryCount,
			@Param("messageSource") String messageSource);

	@Modifying
	@Transactional
	@Query("UPDATE NgDlrUndeliveredRetry SET retryStatus =:retryStatus, retryCount =:retryCount, retryTimeStamp =:retryTimeStamp "
			+ "WHERE messageId =:messageId")
	Integer updateDlrStatusAndCount(@Param("retryStatus") char retryStatus, @Param("retryCount") int retryCount,
			@Param("retryTimeStamp") Date retryTimeStamp, @Param("messageId") String messageId);

	@Modifying
	@Transactional
	@Query("UPDATE NgDlrUndeliveredRetry SET retryStatus =:retryStatuNow, retryTimeStamp =:retryTimeStamp WHERE "
			+ "isDelivered =:isDelivered and retryStatus =:retryStatus and retryCount <:retryCount")
	Integer retryDlrStatusUpdate(@Param("retryStatuNow") char retryStatuNow,
			@Param("retryTimeStamp") Date retryTimeStamp, @Param("isDelivered") char isDelivered,
			@Param("retryStatus") char retryStatus, @Param("retryCount") int retryCount);

	@Modifying
	@Transactional
	@Query("DELETE from NgDlrUndeliveredRetry WHERE messageId =:messageId")
	Integer deliveredRetryDataRemove(@Param("messageId") String messageId);

}
