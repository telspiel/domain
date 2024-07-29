package com.noesis.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgTemplateMessageScheduleInfo;
import com.noesis.domain.repository.NgTemplateMessageScheduleInfoRepository;

@Service
public class NgTemplateMessageScheduleInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgTemplateMessageScheduleInfoRepository ngTemplateMessageScheduleInfoRepository;
	
	public NgTemplateMessageScheduleInfo findByFileUpload(int id) {
		NgTemplateMessageScheduleInfo ngTemplateMessageScheduleInfo = ngTemplateMessageScheduleInfoRepository.findById(id);
		return ngTemplateMessageScheduleInfo;
	}

	public Iterable<NgTemplateMessageScheduleInfo> saveTemplateMessageScheduleInfoList(ArrayList<NgTemplateMessageScheduleInfo> ngFileSplitInfoList){
		Iterable<NgTemplateMessageScheduleInfo> iterator = ngTemplateMessageScheduleInfoRepository.save(ngFileSplitInfoList);
		return iterator;
	}	
	
	public NgTemplateMessageScheduleInfo saveTemplateMessageScheduleInfo(NgTemplateMessageScheduleInfo ngTemplateMessageScheduleInfo){
		NgTemplateMessageScheduleInfo savedScheduledInfo = ngTemplateMessageScheduleInfoRepository.save(ngTemplateMessageScheduleInfo);
		return savedScheduledInfo;
	}	
	
	public List<NgTemplateMessageScheduleInfo> getAllSplittedFileInfoToBeProcessed(int Hh, int Mm, char isProcessed){
		logger.info("Hour : {}",Hh);
		logger.info("Minute : {}",Mm);
		Date scheduleDate = getScheduleDate();
		List<NgTemplateMessageScheduleInfo> scheduledFileToBeProcessed = ngTemplateMessageScheduleInfoRepository.findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(scheduleDate, Hh, isProcessed, scheduleDate, Hh, Mm, isProcessed);
		logger.info("Scheduled File To Be Processed Are: {}",scheduledFileToBeProcessed);
		return scheduledFileToBeProcessed;
		
	}
	
	public Iterable<NgTemplateMessageScheduleInfo> updateProcessFlagForFileSplitInfo(List<NgTemplateMessageScheduleInfo> fileSplitInfoList){
		Iterable<NgTemplateMessageScheduleInfo> updatedFilesIterator = ngTemplateMessageScheduleInfoRepository.save(fileSplitInfoList);
		return updatedFilesIterator;
	}
	
	public List<NgTemplateMessageScheduleInfo> findAllScheduledTemplateCampaignsForUser(int userId) {
	List<NgTemplateMessageScheduleInfo> scheduledTemplateCampaignsForUser = ngTemplateMessageScheduleInfoRepository.findByUserIdAndIsProcessed(userId, 'N');
		return scheduledTemplateCampaignsForUser;
	}
	public List<NgTemplateMessageScheduleInfo> findAllScheduledTemplateCampaignsForDate(int userId, String fromDate, String toDate) throws ParseException {
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);	
		List<NgTemplateMessageScheduleInfo> scheduledTemplateCampaignsForUser = ngTemplateMessageScheduleInfoRepository.findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqual(userId, date1, date2 );
			return scheduledTemplateCampaignsForUser;
		}

	public List<NgTemplateMessageScheduleInfo> deleteScheduledTemplateCampaignForUser(int userId, int campaignId) {
		List<NgTemplateMessageScheduleInfo> scheduledTemplateCampaignsForUser = ngTemplateMessageScheduleInfoRepository.findByUserIdAndCampaignId(userId, campaignId);
		ngTemplateMessageScheduleInfoRepository.delete(scheduledTemplateCampaignsForUser);
		return scheduledTemplateCampaignsForUser;
	}
	
	private Date getScheduleDate() {
		// Sample DB 2019-08-06
		Date today = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		String date = DATE_FORMAT.format(today);
		Date date1 = null;
		try {
			date1 = DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			logger.error("Error while parsing schedule date from form");
			e.printStackTrace();
		}
		return date1;
	}
}
