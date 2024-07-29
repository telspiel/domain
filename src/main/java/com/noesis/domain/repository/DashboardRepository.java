package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.noesis.domain.persistence.NgSummaryReport;

public interface DashboardRepository extends CrudRepository<NgSummaryReport, Serializable>{
	
	public List<NgSummaryReport> findByUserName(String userName);
	
	/*Long sumTotalRequestByUserNameAndDateGreaterThanEqualAndDateLessThanEqual(@Param("userName") String userName, @Param("summaryDate") Date fromDate, @Param("toDate") Date toDate);*/
	
	@Query(value = "select sum(total_request) from ng_summary_report where sa_id = :saId and date >= :fromDate and date <= :toDate", nativeQuery=true)
	Long getSummaryForDateRangeForSuperAdmin(@Param("saId") Integer saId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select sum(total_request) from ng_summary_report where ad_id = :aId and date >= :fromDate and date <= :toDate", nativeQuery=true)
	Long getSummaryForDateRangeForAdmin(@Param("aId") Integer aId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select sum(total_request) from ng_summary_report where re_id = :rId and date >= :fromDate and date <= :toDate", nativeQuery=true)
	Long getSummaryForDateRangeForReseller(@Param("rId") Integer rId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select sum(total_request) from ng_summary_report where se_id = :sId and date >= :fromDate and date <= :toDate", nativeQuery=true)
	Long getSummaryForDateRangeForSeller(@Param("sId") Integer sId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select sum(total_request) from ng_summary_report where user_id = :userId and date >= :fromDate and date <= :toDate", nativeQuery=true)
	Long getSummaryForDateRangeForClient(@Param("userId")  Integer userId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value = "select sum(total_request) from ng_summary_report where am_id = :amId and date >= :fromDate and date <= :toDate", nativeQuery=true)
	Long getSummaryForDateRangeForAccountManager(@Param("amId")  Integer amId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	/*@Query(value = "select userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest"+
			"from NgSummaryReport where userName = :userName and date >= :date(NOW()) - INTERVAL 7 DAY group by userName,date")*/
	
	/*@Query(value = "select userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest"+
			"from NgSummaryReport where userName = :userName and date >= :date(NOW()) - INTERVAL 30 DAY group by userName,date")*/
	
	/*@Query(value = "select userName as userName,"+
			"date as summaryDate, sum(totalRequest) as totalRequest"+
			"from NgSummaryReport where userName = :userName and date >= :date(NOW()) - INTERVAL 60 DAY group by userName,date")*/
	
	
}
