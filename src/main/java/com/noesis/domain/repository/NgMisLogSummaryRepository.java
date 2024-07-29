package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.noesis.domain.dto.MisSummaryQueryDto;
import com.noesis.domain.dto.ResellerSenderIdSummaryQueryDto;
import com.noesis.domain.dto.ResellerSummaryQueryDto;
import com.noesis.domain.persistence.NgSummaryReport;

public interface NgMisLogSummaryRepository extends CrudRepository<NgSummaryReport, Serializable> {
	
	public List<NgSummaryReport> findByUserName(String userName);
	
	public List<NgSummaryReport> findByUserNameAndDateGreaterThanEqualAndDateLessThanEqual(String userName, Date fromDate, Date toDate);
	
	Long countByUserNameAndDateGreaterThanEqualAndDateLessThanEqual(String userName, Date fromDate, Date toDate);

	@Query(value = "select userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where userName = :userName and date >= :fromDate and date <= :toDate group by userName,date order by date asc")
	public List<MisSummaryQueryDto> getMisSummaryDataForUserAndDate(@Param("userName") String userName, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "select userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where userName = :userName group by userName,date order by date asc")
	public List<MisSummaryQueryDto> getMisSummaryDataForUser(@Param("userName") String userName);
	
	@Query(value = "select paId as id,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where paId = :pId and date >= :fromDate and date <= :toDate  group by paId,date order by date asc")
	public List<ResellerSummaryQueryDto> getMisSummaryDataForParentUserAndDate(@Param("pId") Integer pId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select reId as id,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where reId = :rId and date >= :fromDate and date <= :toDate  group by reId,date order by date asc")
	public List<ResellerSummaryQueryDto> getMisSummaryDataForResellerUserAndDate(@Param("rId") Integer rId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate );
	
	@Query(value = "select seId as id,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where seId = :sId and date >= :fromDate and date <= :toDate  group by seId,date order by date asc")
	public List<ResellerSummaryQueryDto> getMisSummaryDataForSellerUserAndDate(@Param("sId") Integer sId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select adId as id,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where adId = :aId and date >= :fromDate and date <= :toDate  group by adId,date order by date asc")
	public List<ResellerSummaryQueryDto> getMisSummaryDataForAdminUserAndDate(@Param("aId") Integer aId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "select saId as id,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where saId = :saId and date >= :fromDate and date <= :toDate group by saId ,date order by date asc")
	public List<ResellerSummaryQueryDto> getMisSummaryDataForSuperAdminUserAndDate(@Param("saId") Integer saId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
 
	@Query(value = "select userId as id,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where userId = :userId and date >= :fromDate and date <= :toDate  group by userId ,date order by date asc")
	public List<ResellerSummaryQueryDto> getMisSummaryDataForClientUserAndDate(@Param("userId") Integer userId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	//Sender ID Summary Report
	
	@Query(value = "select saId as id,"+
			"senderId as senderId, userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where saId = :saId and date >= :fromDate and date <= :toDate  group by saId,userName,senderId,date order by date asc")
	public List<ResellerSenderIdSummaryQueryDto> getMisSenderIdSummaryDataForSuperAdminUserAndDate(@Param("saId") Integer saId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select adId as id,"+
			"senderId as senderId, userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where adId = :aId and date >= :fromDate and date <= :toDate  group by adId,userName,senderId,date order by date asc")
	public List<ResellerSenderIdSummaryQueryDto> getMisSenderIdSummaryDataForAdminUserAndDate(@Param("aId") Integer aId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "select reId as id,"+
			"senderId as senderId, userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where reId = :rId and date >= :fromDate and date <= :toDate  group by reId,userName,senderId,date order by date asc")
	public List<ResellerSenderIdSummaryQueryDto> getMisSenderIdSummaryDataForResellerUserAndDate(@Param("rId") Integer rId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate );
	
	@Query(value = "select seId as id,"+
			"senderId as senderId, userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where seId = :sId and date >= :fromDate and date <= :toDate  group by seId,userName,senderId,date order by date asc")
	public List<ResellerSenderIdSummaryQueryDto> getMisSenderIdSummaryDataForSellerUserAndDate(@Param("sId") Integer sId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select paId as id,"+
			"senderId as senderId, userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where paId = :pId and date >= :fromDate and date <= :toDate  group by paId,userName,senderId,date order by date asc")
	public List<ResellerSenderIdSummaryQueryDto> getMisSenderIdSummaryDataForParentUserAndDate(@Param("pId") Integer pId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select userId as id,"+
			"senderId as senderId, userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where userId = :userId and date >= :fromDate and date <= :toDate  group by userId,userName,senderId,date order by date asc")
	public List<ResellerSenderIdSummaryQueryDto> getMisSenderIdSummaryDataForClientUserAndDate(@Param("userId") Integer userId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	public NgSummaryReport findByUserNameAndDateAndSenderId(String username, Date currentDate, String senderIdString);

	public List<NgSummaryReport> findByUserNameAndDate(String username, Date currentDate);
	
}

