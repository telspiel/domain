package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.domain.persistence.NgDynamicMessageScheduleInfo;

public interface NgDynamicMessageScheduleInfoRepository extends CrudRepository<NgDynamicMessageScheduleInfo, Serializable> {
	
	public NgDynamicMessageScheduleInfo findById(int id);
	
	public List<NgDynamicMessageScheduleInfo> findByScheduleTimeHhLessThanAndScheduleTimeMmLessThanAndIsProcessed(int Hh, int Mm, char isProcessed);
	
	public List<NgDynamicMessageScheduleInfo> findByScheduleTimeHhLessThanAndIsProcessedOrScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(int Hh1,char isProcessed1, int Hh2 , int Mm2, char isProcessed2);
	
	public List<NgDynamicMessageScheduleInfo> findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(Date scheduleDate1, int Hh1,char isProcessed1, Date scheduleDate2, int Hh2 , int Mm2, char isProcessed2);
	
	public List<NgDynamicMessageScheduleInfo> findByUserIdAndIsProcessed(int userId, char isProcessed);

	public List<NgDynamicMessageScheduleInfo> findByUserIdAndCampaignId(int userId, int campaignId);

	public List<NgDynamicMessageScheduleInfo> findByUserIdAndSenderIdAndIsProcessed(int userId, String senderId, char isProcessed);
	public List<NgDynamicMessageScheduleInfo> findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqual(int userId, Date fromDate, Date toDate);

	public List<NgDynamicMessageScheduleInfo> findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqualAndIsScheduled(
			int userId, Date date1, Date date2, char c);

	public List<NgDynamicMessageScheduleInfo> findFirstByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(
			Date scheduleDate, int hh, char isProcessed, Date scheduleDate2, int hh2, int mm, char isProcessed2);

	public List<NgDynamicMessageScheduleInfo> findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessedAndServerFileNameContaining(
			Date scheduleDate, int hh, char isProcessed, Date scheduleDate2, int hh2, int mm, char isProcessed2,
			String text);

	public List<NgDynamicMessageScheduleInfo> findFirstByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessedAndServerFileNameContaining(
			Date scheduleDate, int hh, char isProcessed, Date scheduleDate2, int hh2, int mm, char isProcessed2,
			String text);
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying(clearAutomatically = true)
	@Query("UPDATE NgDynamicMessageScheduleInfo SET isProcessed= :isProcessed WHERE id IN (:fileSplitInfoList)")
	Integer updateIsProcessedDynamicMessageFlag(@Param("fileSplitInfoList") List<Integer> fileSplitInfoList, @Param("isProcessed") char isProcessed);
	
	List<NgDynamicMessageScheduleInfo> findByIdIn(List<Integer> fileSplitInfoList);
	
}
