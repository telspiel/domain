package com.noesis.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDynamicMessageScheduleInfo;
import com.noesis.domain.persistence.NgFileSplitInfo;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgDynamicMessageScheduleInfoRepository;

@Service
public class NgDynamicMessageScheduleInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgDynamicMessageScheduleInfoRepository ngDynamicMessageScheduleInfoRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	UserCreditMapService userCreditMapService;

	
	public NgDynamicMessageScheduleInfo findByFileUpload(int id) {
		NgDynamicMessageScheduleInfo ngDynamicMessageScheduleInfo = ngDynamicMessageScheduleInfoRepository.findById(id);
		return ngDynamicMessageScheduleInfo;
	}

	public Iterable<NgDynamicMessageScheduleInfo> saveDynamicMessageScheduleInfoList(ArrayList<NgDynamicMessageScheduleInfo> ngFileSplitInfoList){
		Iterable<NgDynamicMessageScheduleInfo> iterator = ngDynamicMessageScheduleInfoRepository.save(ngFileSplitInfoList);
		return iterator;
	}	
	
	public NgDynamicMessageScheduleInfo saveDynamicMessageScheduleInfo(NgDynamicMessageScheduleInfo ngDynamicMessageScheduleInfo){
		NgDynamicMessageScheduleInfo savedScheduledInfo = ngDynamicMessageScheduleInfoRepository.save(ngDynamicMessageScheduleInfo);
		return savedScheduledInfo;
	}	
	
	public List<NgDynamicMessageScheduleInfo> getAllSplittedFileInfoToBeProcessed(int Hh, int Mm, char isProcessed){
		logger.info("Hour : {}",Hh);
		logger.info("Minute : {}",Mm);
		Date scheduleDate = getScheduleDate();
		List<NgDynamicMessageScheduleInfo> scheduledFileToBeProcessed = ngDynamicMessageScheduleInfoRepository.findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(scheduleDate, Hh, isProcessed, scheduleDate, Hh, Mm, isProcessed);
		logger.info("Dynamic Scheduled File To Be Processed Are: {}",scheduledFileToBeProcessed);
		return scheduledFileToBeProcessed;
	}
	
	public List<NgDynamicMessageScheduleInfo> getAllSplittedFileInfoToBeProcessedForType(int Hh, int Mm, char isProcessed, String text){
		logger.info("Hour : {}",Hh);
		logger.info("Minute : {}",Mm);
		Date scheduleDate = getScheduleDate();
		List<NgDynamicMessageScheduleInfo> scheduledFileToBeProcessed = ngDynamicMessageScheduleInfoRepository.findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessedAndServerFileNameContaining(scheduleDate, Hh, isProcessed, scheduleDate, Hh, Mm, isProcessed, text);
		logger.info("Scheduled File To Be Processed Are: {}",scheduledFileToBeProcessed);
		return scheduledFileToBeProcessed;
		
	}
	
	public List<NgDynamicMessageScheduleInfo> getFirstSplittedFileInfoToBeProcessedForType(int Hh, int Mm, char isProcessed, String text){
		logger.info("Hour : {}",Hh);
		logger.info("Minute : {}",Mm);
		Date scheduleDate = getScheduleDate();
		List<NgDynamicMessageScheduleInfo> scheduledFileToBeProcessed = ngDynamicMessageScheduleInfoRepository.findFirstByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessedAndServerFileNameContaining(scheduleDate, Hh, isProcessed, scheduleDate, Hh, Mm, isProcessed, text);
		logger.info("Scheduled File To Be Processed Are: {}",scheduledFileToBeProcessed);
		return scheduledFileToBeProcessed;
		
	}
	
	public Iterable<NgDynamicMessageScheduleInfo> updateProcessFlagForFileSplitInfo(List<NgDynamicMessageScheduleInfo> fileSplitInfoList){
		Iterable<NgDynamicMessageScheduleInfo> updatedFilesIterator = ngDynamicMessageScheduleInfoRepository.save(fileSplitInfoList);
		return updatedFilesIterator;
	}
	
	public List<NgDynamicMessageScheduleInfo> findAllScheduledDynamicCampaignsForUser(int userId) {
	List<NgDynamicMessageScheduleInfo> scheduledDynamicCampaignsForUser = ngDynamicMessageScheduleInfoRepository.findByUserIdAndIsProcessed(userId, 'N');
		return scheduledDynamicCampaignsForUser;
	}
	public List<NgDynamicMessageScheduleInfo> findAllScheduledDynamicCampaignsForDate(int userId, String fromDate, String toDate) throws ParseException {

Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);		
	List<NgDynamicMessageScheduleInfo> scheduledDynamicCampaignsForUser = ngDynamicMessageScheduleInfoRepository.findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqualAndIsScheduled(userId, date1, date2,'Y' );	
	return scheduledDynamicCampaignsForUser;
	}
	public List<NgDynamicMessageScheduleInfo> deleteScheduledDynamicCampaignForUser(int userId, int campaignId) {
		List<NgDynamicMessageScheduleInfo> scheduledDynamicCampaignsForUser = ngDynamicMessageScheduleInfoRepository.findByUserIdAndCampaignId(userId, campaignId);
		if(scheduledDynamicCampaignsForUser != null && scheduledDynamicCampaignsForUser.size() > 0) {
			for (NgDynamicMessageScheduleInfo ngDynamicMessageScheduleInfo : scheduledDynamicCampaignsForUser) {
				NgUser ngUser = userService.getUserByIdFromDb(ngDynamicMessageScheduleInfo.getUserId());
				userCreditMapService.updateUserBlockedCredit(ngUser.getUserName(),userCreditMapService.getBlockedCreditForUserFromDB(ngUser.getUserName())-ngDynamicMessageScheduleInfo.getBlockedCredit(),"BLOCKED_CREDIT_RELEASED");
			}
		}
		
		ngDynamicMessageScheduleInfoRepository.delete(scheduledDynamicCampaignsForUser);
		return scheduledDynamicCampaignsForUser;
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
//	Update schdule file status 
	public List<NgDynamicMessageScheduleInfo> updateProcessDynamicMessageScheduleInfoById(List<Integer> updatedFileSplitInfoListById){
		logger.info("Update Process Flag for Split file by User id :- {}", updatedFileSplitInfoListById);
		ngDynamicMessageScheduleInfoRepository.updateIsProcessedDynamicMessageFlag(updatedFileSplitInfoListById,'Y');
		List<NgDynamicMessageScheduleInfo> updatedFilesIterator =  ngDynamicMessageScheduleInfoRepository.findByIdIn(updatedFileSplitInfoListById);
		return updatedFilesIterator;
	}
}
