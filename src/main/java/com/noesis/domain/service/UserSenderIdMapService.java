package com.noesis.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgContentTemplate;
import com.noesis.domain.persistence.NgDynamicMessageInfo;
import com.noesis.domain.persistence.NgDynamicMessageScheduleInfo;
import com.noesis.domain.persistence.NgFileSplitInfo;
import com.noesis.domain.persistence.NgRoutingInfoPromo;
import com.noesis.domain.persistence.NgRoutingInfoTrans;
import com.noesis.domain.persistence.NgRoutingInfoTransPromoDnd;
import com.noesis.domain.persistence.NgRoutingInfoTransPromoNonDnd;
import com.noesis.domain.persistence.NgServiceSubType;
import com.noesis.domain.persistence.NgServiceType;
import com.noesis.domain.persistence.NgTemplateMessageInfo;
import com.noesis.domain.persistence.NgTemplateMessageScheduleInfo;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserSenderIdMap;
import com.noesis.domain.repository.NgContentTemplateRepository;
import com.noesis.domain.repository.NgDynamicMessageInfoRepository;
import com.noesis.domain.repository.NgDynamicMessageScheduleInfoRepository;
import com.noesis.domain.repository.NgFileSplitInfoRepository;
import com.noesis.domain.repository.NgRoutingInfoPromoRepository;
import com.noesis.domain.repository.NgRoutingInfoTransPromoDndRepository;
import com.noesis.domain.repository.NgRoutingInfoTransPromoNonDndRepository;
import com.noesis.domain.repository.NgRoutingInfoTransRepository;
import com.noesis.domain.repository.NgTemplateMessageInfoRepository;
import com.noesis.domain.repository.NgTemplateMessageScheduleInfoRepository;
import com.noesis.domain.repository.UserSenderIdMapRepository;


@Service
public class UserSenderIdMapService {

	//static Logger logger = Logger.getLogger(UserSenderIdMapService.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final UserSenderIdMapRepository userSenderIdMapRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	NgRoutingInfoTransRepository ngRoutingInfoTransRepository;
	
	@Autowired
	NgRoutingInfoPromoRepository ngRoutingInfoPromoRepository;
	
	@Autowired
	NgRoutingInfoTransPromoDndRepository ngRoutingInfoTransPromoDndRepository;
	
	@Autowired
	NgRoutingInfoTransPromoNonDndRepository ngRoutingInfoTransPromoNonDndRepository;
	
	@Autowired
	NgFileSplitInfoRepository ngFileSplitInfoRepository;
	
	@Autowired
	NgDynamicMessageScheduleInfoRepository ngDynamicMessageScheduleInfoRepository;
	
	@Autowired
	NgDynamicMessageInfoRepository ngDynamicMessageInfoRepository;
	
	@Autowired
	NgTemplateMessageScheduleInfoRepository ngTemplateMessageScheduleInfoRepository;
	
	@Autowired
	NgTemplateMessageInfoRepository ngTemplateMessageInfoRepository;
	
	@Autowired
	StaticDataService staticDataService;
	
	@Autowired
	NgContentTemplateRepository ngContentTemplateRepository;

	@Autowired
	public UserSenderIdMapService(UserSenderIdMapRepository userSenderIdMapRepository) {
		this.userSenderIdMapRepository = userSenderIdMapRepository;
	}
	
	/*@Cacheable(value = "userCreditMap", key="#ngUser.userId")
	public NgUserCreditMap getUserCreditByUserId(int id) {
		logger.info("Getting user by ID {} from service.", id);
		NgUserCreditMap userCreditMap = userCreditMapRepository.findByUserId(id);
		logger.info("Available Credit For User Is : " + userCreditMap.getUserId() +"Available Credit is"+ userCreditMap.getAvailableCredit());
		return userCreditMap;
	}*/
	
	@Cacheable(value = "userDefaultSenderIdMap", key="#userName")
	public List<NgUserSenderIdMap> getDefaultUserSenderIdByUserName(String userName) {
		//logger.info("Getting user by ID {} from service.", userName);
		NgUser user = userService.getUserByName(userName);
		//logger.info("User found by name: "+user);
		//logger.info("USer sender id list from user is : "+user.getNgUserSenderIdMaps());
		
		
		if(user!=null) {
			List<NgUserSenderIdMap> userSenderIdMapList = new ArrayList<>();
			/*Iterable<NgUserSenderIdMap> iteratorList = userSenderIdMapRepository.findAll();
			for (NgUserSenderIdMap ngUserSenderIdMap : iteratorList) {
				userSenderIdMapList.add(ngUserSenderIdMap);
			}*/
			//userSenderIdMapList = userSenderIdMapRepository.findByNgUserInAndIsDefaultInAndIsActiveIn(user, 'Y','Y');
			//logger.info("Default and Active sender id list for ' {} ' user is: {}",user.getUserName(), userSenderIdMapList.size());
		
			userSenderIdMapList = userSenderIdMapRepository.findByNgUserAndIsDefaultAndIsActive(user, 'Y','Y');
			logger.info("Sender Id list by findByNgUserAndIsDefaultAndIsActive: 1{} {}",user.getUserName(), userSenderIdMapList.size());
		
			return userSenderIdMapList;
		}
		return null;
	}
	
	@Cacheable(value = "userDefaultDndSenderIdMap", key="#userName")
	public List<NgUserSenderIdMap> getNonDndDefaultUserSenderIdByUserName(String userName) {
		//logger.info("Getting user by ID {} from service.", userName);
		NgUser user = userService.getUserByName(userName);
		//logger.info("User found by name: "+user);
		//logger.info("USer sender id list from user is : "+user.getNgUserSenderIdMaps());
		
		
		if(user!=null) {
			List<NgUserSenderIdMap> userSenderIdMapList = new ArrayList<>();
			/*Iterable<NgUserSenderIdMap> iteratorList = userSenderIdMapRepository.findAll();
			for (NgUserSenderIdMap ngUserSenderIdMap : iteratorList) {
				userSenderIdMapList.add(ngUserSenderIdMap);
			}*/
			//userSenderIdMapList = userSenderIdMapRepository.findByNgUserInAndIsDefaultInAndIsActiveIn(user, 'Y','Y');
			//logger.info("Default and Active sender id list for ' {} ' user is: {}",user.getUserName(), userSenderIdMapList.size());
		
			userSenderIdMapList = userSenderIdMapRepository.findByNgUserAndIsNonDndNumberAllowed(user,'Y');
			logger.info("Sender Id list by findByNgUserAndIsDndNumberAllowed: {} {}",user.getUserName(), userSenderIdMapList.size());
		
			return userSenderIdMapList;
		}
		return null;
	}

	@Cacheable(value = "userDefaultSenderIdMap", key="#userName")
	public List<NgUserSenderIdMap> loadAllDefaultActiveSenderId() {
		//logger.info("Getting user by ID {} from service.", userName);
		//NgUser user = userService.getUserByName(userName);
		//logger.info("USer found by name: "+user);
		//if(user != null) {
			List<NgUserSenderIdMap> userSenderIdMapList = userSenderIdMapRepository.findAllIsDefaultAndIsActive();
			
			//logger.info("Default and Active sender id list for ' {} ' user is: ",user.getUserName(), userSenderIdMapList.size());
			return userSenderIdMapList;
		//}
		//return null;
	}
	
	public Iterable<NgUserSenderIdMap> getAllSenderIdList() {
		Iterable<NgUserSenderIdMap> senderIdList = userSenderIdMapRepository.findAll();
		return senderIdList;
	}
	
	public Iterable<NgUserSenderIdMap> getAllSenderIdListForUser(NgUser user, char isActive) {
		Iterable<NgUserSenderIdMap> senderIdList = userSenderIdMapRepository.findByNgUserAndIsActive(user,isActive);
		return senderIdList;
	}
	
	public Iterable<NgUserSenderIdMap> getAllSenderIdListForUser(NgUser user) {
		Iterable<NgUserSenderIdMap> senderIdList = userSenderIdMapRepository.findByNgUserAndIsActive(user,'Y');
		return senderIdList;
	}
	
	public Iterable<NgUserSenderIdMap> getAllSenderIdForUser(NgUser user) {
		Iterable<NgUserSenderIdMap> senderIdList = userSenderIdMapRepository.findByNgUser(user);
		return senderIdList;
	}
	
	public NgUserSenderIdMap saveSenderId(NgUserSenderIdMap userSenderIdMap) {
		NgUserSenderIdMap ngUserSenderIdMap = userSenderIdMapRepository.save(userSenderIdMap);
		loadAllDefaultActiveSenderId();
		return ngUserSenderIdMap;
	}
	public NgUserSenderIdMap getSenderIdByIdAndUserId(String senderId, int userId) {
		NgUserSenderIdMap ngUserSenderIdMap = userSenderIdMapRepository.findBySenderIdAndUserId(senderId, userId);
		return ngUserSenderIdMap;
	}
	/*
	@CachePut(value = "userCreditMap", key="#userName")
	public Integer updateUserCreditByUserName(String userName, int countToBeDeducted) {
		logger.info("Getting user by ID {} from service.", userName);
		NgUser user = userService.getUserByName(userName);
		logger.info("USer found by name: "+user);
		if(user!=null) {
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			logger.info("Available Credit For User Is : " + userCreditMap.getNgUser().getUserName() +"Available Credit is"+ userCreditMap.getAvailableCredit());
			if(userCreditMap.getAvailableCredit()>0) {
				userCreditMap.setAvailableCredit(userCreditMap.getAvailableCredit()-countToBeDeducted);
			}
			userCreditMapRepository.save(userCreditMap);
			return userCreditMap.getAvailableCredit();
		}
		return 0;
	}
*/

	public boolean approveRejectSenderId(String senderId, String userName, char status) {
		NgUser ngUser = userService.getUserByName(userName);
		if(ngUser != null) {
			NgUserSenderIdMap ngUserSenderIdMap = userSenderIdMapRepository.findBySenderIdAndUserId(senderId.toUpperCase(), ngUser.getId());
			if(ngUserSenderIdMap != null) {
				ngUserSenderIdMap.setIsActive(status);
				ngUserSenderIdMap = userSenderIdMapRepository.save(ngUserSenderIdMap);
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}

	public boolean addRemoveDefaultSenderId(String senderId, String userName,  char status) {
		NgUser ngUser = userService.getUserByName(userName);
		if(ngUser != null) {
			NgUserSenderIdMap ngUserSenderIdMap = userSenderIdMapRepository.findBySenderIdAndUserId(senderId.toUpperCase(), ngUser.getId());
			if(ngUserSenderIdMap != null) {
				ngUserSenderIdMap.setIsDefault(status);
				ngUserSenderIdMap = userSenderIdMapRepository.save(ngUserSenderIdMap);
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	
	
	public Map<String, Integer> getAllActiveSenderIdForUser(NgUser ngUser){    
		Map<String, Integer> activeSenderIdMap = new HashMap<String, Integer>();
		//List<NgUserSenderIdMap> userSenderIdList = userSenderIdMapRepository.findByNgUserAndIsActive(ngUser,'Y');
		// only add this line
		List<NgUserSenderIdMap> userSenderIdList = userSenderIdMapRepository.findByNgUser(ngUser);
		for (NgUserSenderIdMap ngUserSenderIdMap : userSenderIdList) {
			activeSenderIdMap.put(ngUserSenderIdMap.getSenderId(), ngUserSenderIdMap.getId());
		}
		return activeSenderIdMap;
	}
	
	public NgUserSenderIdMap removeSenderIdFromUserSenderIdList(String senderId) {
		NgUserSenderIdMap senderIdList = userSenderIdMapRepository.findBySenderId(senderId);
		userSenderIdMapRepository.delete(senderIdList);
		return senderIdList;
	}

	public List<NgUserSenderIdMap> getAllSenderIdListForUsers(List<NgUser> childUsers, char isActive) {
		List<NgUserSenderIdMap> senderIdList = userSenderIdMapRepository.findByNgUserInAndIsActive(childUsers,isActive);
		loadAllDefaultActiveSenderId();
		return senderIdList;
	}

	public NgUserSenderIdMap getSenderIdById(int idOfSenderId) {
		NgUserSenderIdMap ngUserSenderIdMap = userSenderIdMapRepository.findById(idOfSenderId);
		return ngUserSenderIdMap;
	}
	
	public NgUserSenderIdMap removeSenderId(int idOfSenderId, int userId) {
		
		// Delete from all routings for sender id.
		NgUserSenderIdMap senderId = userSenderIdMapRepository.findById(idOfSenderId);
		
		List<NgRoutingInfoTrans> ngRoutingInfoTransList = ngRoutingInfoTransRepository.findByUserIdAndSenderId(userId, idOfSenderId);
		ngRoutingInfoTransRepository.delete(ngRoutingInfoTransList);
		
		List<NgRoutingInfoPromo> ngRoutingInfoPromoList = ngRoutingInfoPromoRepository.findByUserIdAndSenderId(userId, idOfSenderId);
		ngRoutingInfoPromoRepository.delete(ngRoutingInfoPromoList);
		
		List<NgRoutingInfoTransPromoDnd> ngRoutingInfoTransPromoDndList = ngRoutingInfoTransPromoDndRepository.findByUserIdAndSenderId(userId, idOfSenderId);
		ngRoutingInfoTransPromoDndRepository.delete(ngRoutingInfoTransPromoDndList);
		
		List<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoTransPromoNonDndList = ngRoutingInfoTransPromoNonDndRepository.findByUserIdAndSenderId(userId, idOfSenderId);
		ngRoutingInfoTransPromoNonDndRepository.delete(ngRoutingInfoTransPromoNonDndList);
		
		// Delete scheduled dynamic, bulk, template, group messaging
		List<NgFileSplitInfo> ngFileSplitInfoList = ngFileSplitInfoRepository.findByUserIdAndSenderIdAndIsProcessed(userId, senderId.getSenderId(), 'N');
		ngFileSplitInfoRepository.delete(ngFileSplitInfoList);
		
		List<NgDynamicMessageScheduleInfo> ngDynamicMessageScheduleInfoList = ngDynamicMessageScheduleInfoRepository.findByUserIdAndSenderIdAndIsProcessed(userId, senderId.getSenderId(), 'N');
		ngDynamicMessageScheduleInfoRepository.delete(ngDynamicMessageScheduleInfoList);
		
		/*List<NgDynamicMessageInfo> ngDynamicMessageInfoList = ngDynamicMessageInfoRepository.findByNgUserAndSenderId(userId, senderId.getSenderId());
		ngDynamicMessageInfoRepository.delete(ngDynamicMessageInfoList);*/
		
		List<NgTemplateMessageScheduleInfo> ngTemplateMessageScheduleInfoList = ngTemplateMessageScheduleInfoRepository.findByUserIdAndSenderIdAndIsProcessed(userId, senderId.getSenderId(), 'N');
		ngTemplateMessageScheduleInfoRepository.delete(ngTemplateMessageScheduleInfoList);
		
		/*List<NgTemplateMessageInfo> ngTemplateMessageInfoList = ngTemplateMessageInfoRepository.findByUserIdAndSenderId(userId, senderId.getSenderId());
		ngTemplateMessageInfoRepository.delete(ngTemplateMessageInfoList);*/
		
		//TODO : Remove file from the server.
		userSenderIdMapRepository.delete(senderId);
		
		// Refresh routing cache and routing cache
		staticDataService.loadRoutingInfoTrans();
		staticDataService.loadRoutingInfoPromo();
		staticDataService.loadRoutingInfoTransPromoDnd();
		staticDataService.loadRoutingInfoTransPromoNonDnd();
		staticDataService.loadAllSenderId();
		
		return senderId;
	}

	public Iterable<NgUserSenderIdMap> getAllSenderIdListForUserAndMsgTypeAndSubType(NgUser ngUser,
			NgServiceType ngServiceType, NgServiceSubType ngServiceSubType) {
		Iterable<NgUserSenderIdMap> senderIdList = userSenderIdMapRepository.findByNgUserAndIsActiveAndNgServiceTypeAndNgServiceSubType(ngUser,'Y', ngServiceType, ngServiceSubType);
		return senderIdList;
	}

	public Iterable<NgUserSenderIdMap> saveUserSenderIdList(List<NgUserSenderIdMap> ngUserSenderIdMapList) {
		Iterable<NgUserSenderIdMap> ngUserSenderIdList = userSenderIdMapRepository.save(ngUserSenderIdMapList);
		loadAllDefaultActiveSenderId();
		return ngUserSenderIdList;
	}
}
