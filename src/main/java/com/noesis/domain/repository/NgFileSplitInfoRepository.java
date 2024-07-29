package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.domain.persistence.NgFileSplitInfo;

public interface NgFileSplitInfoRepository extends CrudRepository<NgFileSplitInfo, Serializable> {

	
	public NgFileSplitInfo findById(int id);
	
	public List<NgFileSplitInfo> findByScheduleTimeHhLessThanAndScheduleTimeMmLessThanAndIsProcessed(int Hh, int Mm, char isProcessed);
	
	public List<NgFileSplitInfo> findByScheduleTimeHhLessThanAndIsProcessedOrScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(int Hh1,char isProcessed1, int Hh2 , int Mm2, char isProcessed2);
	
	public List<NgFileSplitInfo> findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(Date scheduleDate1, int Hh1,char isProcessed1, Date scheduleDate2, int Hh2 , int Mm2, char isProcessed2);

	public List<NgFileSplitInfo> findByUserIdAndIsProcessed(int userId, char isProcessed);

	public List<NgFileSplitInfo> findByUserIdAndCampaignId(int userId, int campaignId);

	public List<NgFileSplitInfo> findByUserIdAndSenderIdAndIsProcessed(int userId, String senderId, char isProcessed);
	public List<NgFileSplitInfo> findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqual(int userId, Date fromDate, Date toDate);

	public List<NgFileSplitInfo> findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqualAndIsScheduled(
			int userId, Date date1, Date date2, char isScheduled);
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying(clearAutomatically = true)
	@Query("UPDATE NgFileSplitInfo SET isProcessed= :isProcessed WHERE id IN (:fileSplitInfoList)")
	Integer updateIsProcessedFileSplitFlag(@Param("fileSplitInfoList") List<Integer> fileSplitInfoList, @Param("isProcessed") char isProcessed);
					
//	@Transactional
//	@Modifying
//	@Query("UPDATE NgFileSplitInfo SET isProcessed= :isProcessed WHERE id  =:fileSplitInfoList")
//	Integer updateIsProcessedFileSplitFlag(@Param("fileSplitInfoList") Integer fileSplitInfoList, @Param("isProcessed") char isProcessed);
//	
	
	List<NgFileSplitInfo> findByIdIn(List<Integer> fileSplitInfoList);
}

