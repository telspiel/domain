package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgTemplateMessageScheduleInfo;

public interface NgTemplateMessageScheduleInfoRepository extends CrudRepository<NgTemplateMessageScheduleInfo, Serializable> {
	
	public NgTemplateMessageScheduleInfo findById(int id);
	
	public List<NgTemplateMessageScheduleInfo> findByScheduleTimeHhLessThanAndScheduleTimeMmLessThanAndIsProcessed(int Hh, int Mm, char isProcessed);
	
	public List<NgTemplateMessageScheduleInfo> findByScheduleTimeHhLessThanAndIsProcessedOrScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(int Hh1,char isProcessed1, int Hh2 , int Mm2, char isProcessed2);
	
	public List<NgTemplateMessageScheduleInfo> findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(Date scheduleDate1, int Hh1,char isProcessed1, Date scheduleDate2, int Hh2 , int Mm2, char isProcessed2);
	
	public List<NgTemplateMessageScheduleInfo> findByUserIdAndIsProcessed(int userId, char isProcessed);

	public List<NgTemplateMessageScheduleInfo> findByUserIdAndCampaignId(int userId, int campaignId);

	public List<NgTemplateMessageScheduleInfo> findByUserIdAndSenderIdAndIsProcessed(int userId, String senderId,char isProcessed);
	public List<NgTemplateMessageScheduleInfo> findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqual(int userId, Date fromDate, Date toDate);
	
}
