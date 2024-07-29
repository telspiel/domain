package com.noesis.domain.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgFileSplitInfo;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgFileSplitInfoRepository;

@Service
public class NgFileSplitInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgFileSplitInfoRepository ngFileSplitInfoRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	UserCreditMapService userCreditMapService;
	
	public NgFileSplitInfo findByFileUpload(int id) {
		NgFileSplitInfo ngFileSplitInfo = ngFileSplitInfoRepository.findById(id);
		return ngFileSplitInfo;
	}

	public Iterable<NgFileSplitInfo> saveSplitFileInfoList(ArrayList<NgFileSplitInfo> ngFileSplitInfoList){
		Iterable<NgFileSplitInfo> iterator = ngFileSplitInfoRepository.save(ngFileSplitInfoList);
		return iterator;
	}	
	
	public List<NgFileSplitInfo> getAllSplittedFileInfoToBeProcessed(int Hh, int Mm, char isProcessed){
		logger.info("Hour : {}",Hh);
		logger.info("Minute : {}",Mm);
		Date scheduleDate = getScheduleDate();
		List<NgFileSplitInfo> scheduledFileToBeProcessed = ngFileSplitInfoRepository.findByScheduleDateLessThanEqualAndScheduleTimeHhLessThanAndIsProcessedOrScheduleDateLessThanEqualAndScheduleTimeHhEqualsAndScheduleTimeMmLessThanAndIsProcessed(scheduleDate, Hh, isProcessed, scheduleDate, Hh, Mm, isProcessed);
		logger.info("Scheduled File To Be Processed Are: {}",scheduledFileToBeProcessed);
		return scheduledFileToBeProcessed;
		
	}
	
	public Iterable<NgFileSplitInfo> updateProcessFlagForFileSplitInfo(List<NgFileSplitInfo> fileSplitInfoList){
		Iterable<NgFileSplitInfo> updatedFilesIterator = ngFileSplitInfoRepository.save(fileSplitInfoList);
		return updatedFilesIterator;
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

	public List<NgFileSplitInfo> findAllScheduledCampaignsForUser(int userId) {
	List<NgFileSplitInfo> scheduledCampaignsForUser = ngFileSplitInfoRepository.findByUserIdAndIsProcessed(userId, 'N');
		return scheduledCampaignsForUser;
	}
	public List<NgFileSplitInfo> findAllScheduledCampaignsForDate(int userId, String fromDate, String toDate) throws ParseException {
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);	
		List<NgFileSplitInfo> scheduledCampaignsForUser = ngFileSplitInfoRepository.findByUserIdAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqualAndIsScheduled(userId, date1, date2, 'Y');
			return scheduledCampaignsForUser;
		}

	public List<NgFileSplitInfo> deleteScheduledCampaignForUser(int userId, int campaignId) {
		List<NgFileSplitInfo> scheduledCampaignsForUser = ngFileSplitInfoRepository.findByUserIdAndCampaignId(userId, campaignId);
		// Reverse blocked credit for campaign
		if(scheduledCampaignsForUser != null && scheduledCampaignsForUser.size() > 0) {
			for (NgFileSplitInfo ngFileSplitInfo : scheduledCampaignsForUser) {
				NgUser ngUser = userService.getUserByIdFromDb(ngFileSplitInfo.getUserId());
				userCreditMapService.updateUserBlockedCredit(ngUser.getUserName(),userCreditMapService.getBlockedCreditForUserFromDB(ngUser.getUserName())-ngFileSplitInfo.getBlockedCredit(),"BLOCKED_CREDIT_RELEASED");
			}
		}
		ngFileSplitInfoRepository.delete(scheduledCampaignsForUser);
		return scheduledCampaignsForUser;
	}
//	Update schdule file status 
	public List<NgFileSplitInfo> updateProcessFlagForSplitInfoById(List<Integer> updatedFileSplitInfoListById){
		logger.info("Update Process Flag for Split file by User id :- {}", updatedFileSplitInfoListById);
		ngFileSplitInfoRepository.updateIsProcessedFileSplitFlag(updatedFileSplitInfoListById,'Y');
		List<NgFileSplitInfo> updatedFilesIterator =  ngFileSplitInfoRepository.findByIdIn(updatedFileSplitInfoListById);
		return updatedFilesIterator;
	}
}
