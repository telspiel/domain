package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.noesis.domain.dto.ConnectSenderIdSummaryQueryDto;
import com.noesis.domain.dto.ConnectSummaryQueryDto;
import com.noesis.domain.persistence.NgConnectSummeryAll;

public interface NgConnectSummeryAllRepository extends CrudRepository<NgConnectSummeryAll, Serializable> {
	// Today Summary
	
	@Query(value = "select saId as id," + "receiveDate as receiveDate, smscId as connectName, "
			+ "sum(submitCnt) as totalSubmit, sum(dlvrdCnt) as delivered, sum(failCnt) as failed "
			+ "from NgConnectSummeryAll where saId = :saId and receiveDate = :receiveDate group by saId,receiveDate,smscId ")
	List<ConnectSummaryQueryDto> getDayConnectSummaryDataForSuperAdminUser(@Param("saId") Integer saId,
			@Param("receiveDate") Date receiveDate);

	@Query(value = "select adId as id," + "receiveDate as receiveDate, smscId as connectName, "
			+ "sum(submitCnt) as totalSubmit, sum(dlvrdCnt) as delivered, sum(failCnt) as failed "
			+ "from NgConnectSummeryAll where adId = :adId and receiveDate = :receiveDate group by adId,receiveDate,smscId ")
	List<ConnectSummaryQueryDto> getDayConnectSummaryDataForAdminUser(@Param("adId") Integer adId,
			@Param("receiveDate") Date receiveDate);

	@Query(value = "select saId as id," + "smscId as connectName, "
			+ "sum(submitCnt) as totalSubmit, sum(dlvrdCnt) as delivered, sum(failCnt) as failed "
			+ "from NgConnectSummeryAll where saId = :saId and receiveDate >= :fromReceiveDate and receiveDate <= :toReceiveDate group by saId,smscId ")
	List<ConnectSummaryQueryDto> getMonthConnectSummaryDataForSuperAdminUser(@Param("saId") Integer saId, @Param("fromReceiveDate") Date fromReceiveDate,
			@Param("toReceiveDate") Date toReceiveDate);

	@Query(value = "select adId as id," + "smscId as connectName, "
			+ "sum(submitCnt) as totalSubmit, sum(dlvrdCnt) as delivered, sum(failCnt) as failed "
			+ "from NgConnectSummeryAll where adId = :adId and receiveDate >= :fromReceiveDate and receiveDate <= :toReceiveDate group by adId,smscId ")
	List<ConnectSummaryQueryDto> getMonthConnectSummaryDataForAdminUser(@Param("adId") Integer adId, @Param("fromReceiveDate") Date fromReceiveDate,
			@Param("toReceiveDate") Date toReceiveDate);
	
	// Today Sender ID Summary
	
	@Query(value = "select receiveDate as receiveDate, userName as userName, smscId as connectName, "
			+ "senderId as senderId, sum(submitCnt) as totalSubmit, sum(dlvrdCnt) as delivered, sum(failCnt) as failed "
			+ "from NgConnectSummeryAll where saId = :saId and receiveDate >= :fromReceiveDate and receiveDate <= :toReceiveDate group by receiveDate,userName,smscId,senderId")
	List<ConnectSenderIdSummaryQueryDto> getDayConnectSenderIdSummaryDataForSuperAdminUser(@Param("saId") Integer saId,
			@Param("fromReceiveDate") Date fromReceiveDate, @Param("toReceiveDate") Date toReceiveDate);

	@Query(value = "select receiveDate as receiveDate, userName as userName, smscId as connectName, "
			+ "senderId as senderId, sum(submitCnt) as totalSubmit, sum(dlvrdCnt) as delivered, sum(failCnt) as failed "
			+ "from NgConnectSummeryAll where adId = :adId and receiveDate >= :fromReceiveDate and receiveDate <= :toReceiveDate group by receiveDate,userName,smscId,senderId")
	List<ConnectSenderIdSummaryQueryDto> getDayConnectSenderIdSummaryDataForAdminUser(@Param("adId") Integer adId,
			@Param("fromReceiveDate") Date fromReceiveDate, @Param("toReceiveDate") Date toReceiveDate);
	
}
