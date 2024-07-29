package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.noesis.domain.dto.MisSummaryQueryDto;
import com.noesis.domain.persistence.NgSummaryReport;

public interface NgMisWebtoolSummaryRepository extends CrudRepository<NgSummaryReport, Serializable>{
	
	public List<NgSummaryReport> findByUserName(String userName);
	
	public List<NgSummaryReport> findByUserNameAndDateGreaterThanEqualAndDateLessThanEqual(String userName, Date fromDate, Date toDate);
	
	Long countByUserNameAndDateGreaterThanEqualAndDateLessThanEqual(String userName, Date fromDate, Date toDate);
	
	@Query(value = "select userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where userName = :userName and date >= :fromDate and date <= :toDate group by userName,date order by date asc")
	public List<MisSummaryQueryDto> getNgMisWebtoolSummaryDataForUserAndDate(@Param("userName") String userName, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "select userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest, sum(submitted) as totalSubmitted,"+ 
			"sum(rejected) as totalRejected ,sum(delivered) as totalDelivered, "+
			"sum(failed) as totalFailed ,sum(awaited) as totalAwaited "+
			"from NgSummaryReport where userName = :userName group by userName,date order by date asc")
	public List<MisSummaryQueryDto> getNgMisWebtoolSummaryDataForUser(@Param("userName") String userName);

	public List<NgSummaryReport> findByUserNameAndDate(String username, String date);

	public NgSummaryReport findByUserNameAndDateAndSenderId(String username, Date currentDate, String senderId);
}
