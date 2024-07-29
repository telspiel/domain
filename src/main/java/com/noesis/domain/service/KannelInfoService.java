package com.noesis.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgKannelInfo;
import com.noesis.domain.repository.KannelInfoRepository;

@Service
public class KannelInfoService {

	//private static final Logger logger = LogManager.getLogger(KannelInfoService.class);
	private final Logger logger = LoggerFactory.getLogger(KannelInfoService.class);
	private final KannelInfoRepository kannelInfoRepository;
	private final int dummyKannelId = -1;
	
	@Autowired
	public KannelInfoService(KannelInfoRepository kannelInfoRepository) {
		this.kannelInfoRepository = kannelInfoRepository;
	}
	
	//@Cacheable(value = "allActiveKannelInfoList", key="activeKannel")
	public List<NgKannelInfo> getAllActiveKannelInfoList() {
		logger.info("Getting all active kannel info list from service.");
		List<NgKannelInfo> activeKannelInfoList = new ArrayList<>();
		Iterable<NgKannelInfo> iterableList = kannelInfoRepository.findByIsActive('Y');
		for (NgKannelInfo ngKannelInfo : iterableList) {
			activeKannelInfoList.add(ngKannelInfo);
		}
		logger.info("Available active kannel list size is ' {} ' ", activeKannelInfoList.size());
		return activeKannelInfoList;
		
	}
	
	//@Cacheable(value = "allActiveKannelInfoList", key="activeKannel")
		public List<NgKannelInfo> getAllActiveKannelByType(String kannelType) {
			logger.info("Getting all active kannel info list for type : "+kannelType);
			List<NgKannelInfo> activeKannelInfoList = new ArrayList<>();
			Iterable<NgKannelInfo> iterableList = kannelInfoRepository.findByIsActiveAndKannelMessageType('Y', kannelType);
			for (NgKannelInfo ngKannelInfo : iterableList) {
				activeKannelInfoList.add(ngKannelInfo);
			}
			logger.info("Available active kannel list size is ' {} ' ", activeKannelInfoList.size());
			return activeKannelInfoList;
			
		}
		
		public NgKannelInfo getKannelInfoFromKannelId(Integer kannelId) {
			logger.info("Getting kannel info from kannelId : "+kannelId);
			NgKannelInfo ngKannelInfo = kannelInfoRepository.findByIsActiveAndId('Y', kannelId);
			return ngKannelInfo;
		}
		
		public NgKannelInfo getDefaultKannelInfoForRejectedMessage() {
			logger.info("Getting kannel info with id 0");
			NgKannelInfo ngKannelInfo = kannelInfoRepository.findById(-1);
			return ngKannelInfo;
		}

		public List<NgKannelInfo> removeInActiveKannelsFromArray(String[] kannelIdsArray) {
			logger.debug("Total Kannels found : {}" , kannelIdsArray.toString());
			int[] kannelIdsArrayInt = Arrays.stream(kannelIdsArray).mapToInt(Integer::parseInt).toArray();
			List<Integer> kannelIdsList = new ArrayList<>();
			for (int i : kannelIdsArrayInt) {
				kannelIdsList.add(i);
			}
			
			List<NgKannelInfo> finalList = new ArrayList<>();
			List<NgKannelInfo> activeKannelInfoList = kannelInfoRepository.findByIsActiveAndIdIn('Y', kannelIdsList);
			for (int i : kannelIdsArrayInt) {
				for (NgKannelInfo ngKannelInfo : activeKannelInfoList) {
					if(i == ngKannelInfo.getId().intValue()) {
						finalList.add(ngKannelInfo);
						break;
					}
				}
			}
			
			if(finalList != null) {
				logger.info("Final kannel list after removing inactive kannels is : {}",finalList.toString());
			}
			return finalList;
			
		}
		
		public List<NgKannelInfo> getAllActiveKannelIncludingDummyForUser(int userId){
			List<NgKannelInfo> kannelInfoList = kannelInfoRepository.findByIsActiveAndUserIdOrIdLessThan('Y',userId, dummyKannelId);	
			return kannelInfoList;
		}
}
