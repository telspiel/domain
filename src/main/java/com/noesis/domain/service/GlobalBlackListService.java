package com.noesis.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgGlobalBlackList;
import com.noesis.domain.persistence.NgGlobalSenderIdBlackList;
import com.noesis.domain.repository.GlobalBlackListRepository;
import com.noesis.domain.repository.GlobalSenderIdBlackListRepository;

@Service
public class GlobalBlackListService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private GlobalBlackListRepository blackListRepository;

	@Autowired
	private GlobalSenderIdBlackListRepository senderIdBlackListRepository;
 
	@Autowired
	StringRedisTemplate stringTemplate;

	public boolean loadAllGlobalBlackListDataInCache() {
		stringTemplate.opsForSet().getOperations().delete("blackListNumberSetKey");
		ArrayList<NgGlobalBlackList> ngGlobalBlackList = new ArrayList<>();
		Set<String> blackListNumberSet = new HashSet<>();
		blackListRepository.findAll().forEach(ngGlobalBlackList::add);
		if(ngGlobalBlackList.size() > 0) {
			for (NgGlobalBlackList object : ngGlobalBlackList) {
				blackListNumberSet.add(object.getPhoneNumber());
			}

			String key = "blackListNumberSetKey";
			String[] values = blackListNumberSet.toArray(new String[blackListNumberSet.size()]);
			logger.info("SetKey add [" + stringTemplate.opsForSet().add(key, values) + "] values ");
		}
		return true;
	}

	public boolean clearAllBlackListDataFromCache() {
		String key = "blackListNumberSetKey";
		stringTemplate.opsForSet().getOperations().delete(key);
		return true;
	}
    // global black list check *******************************************************************************************************************
	public Boolean isBlackListNumber(String number) {
		String key = "blackListNumberSetKey";
		logger.info("check Global Black List From Redis Ok Ok Ok Ok ");
		logger.info(number + " is member of Global Black List : " + stringTemplate.opsForSet().isMember(key, number));
		return stringTemplate.opsForSet().isMember(key, number);
		
//		if (phone.contains(number)) {
//			logger.info(number + "****************number is in global blacklist**********");
//			return true;
//			
//		}
		
		//return false;
	}
	// global black list end************************************************************************************************************
	
	public Boolean addNumberInGlobalBlackList(String number) {
		NgGlobalBlackList ngGlobalBlackList = new NgGlobalBlackList();
		ngGlobalBlackList.setCreatedDate(new Date().toString());
		ngGlobalBlackList.setPhoneNumber(number);
		
		ngGlobalBlackList = blackListRepository.save(ngGlobalBlackList);
		return loadAllGlobalBlackListDataInCache();
	}
	
	public Boolean removeNumberInGlobalBlackList(String number) {
		NgGlobalBlackList ngGlobalBlackList = blackListRepository.findByPhoneNumber(number);
		blackListRepository.delete(ngGlobalBlackList);
		
		return loadAllGlobalBlackListDataInCache();
	}
	
	public Boolean addBulkNumberInGlobalBlackList(ArrayList<NgGlobalBlackList> ngGlobalBlackNumberList)  {
		// Delete all existing numbers;
		blackListRepository.deleteAll();
		
		// Add new numbers.
		Iterable<NgGlobalBlackList> ngGlobalPremiumNumberListIterator = blackListRepository.save(ngGlobalBlackNumberList);
		
		// Load new numbers in Cache
		return loadAllGlobalBlackListDataInCache();
	}
	
	// Global Black List Sender Id methods.
	
	public boolean loadAllGlobalSenderIdBlackListDataInCache() {
		stringTemplate.opsForSet().getOperations().delete("blackListSenderIdSetKey");
		ArrayList<NgGlobalSenderIdBlackList> ngGlobalSenderIdBlackList = new ArrayList<>();
		Set<String> blackListSenderIdSet = new HashSet<>();
		senderIdBlackListRepository.findAll().forEach(ngGlobalSenderIdBlackList::add);

		for (NgGlobalSenderIdBlackList object : ngGlobalSenderIdBlackList) {
			blackListSenderIdSet.add(object.getSenderId().toLowerCase());
		}

		String key = "blackListSenderIdSetKey";
		String[] values = blackListSenderIdSet.toArray(new String[blackListSenderIdSet.size()]);
		logger.info("SetKey add [" + stringTemplate.opsForSet().add(key, values) + "] values ");
		return true;
	}

	public boolean clearAllSenderIdBlackListDataFromCache() {
		String key = "blackListSenderIdSetKey";
		stringTemplate.opsForSet().getOperations().delete(key);
		return true;
	}

	public Boolean isBlackListSenderId(String senderId) {
		String key = "blackListSenderIdSetKey";
		logger.info(senderId + " is member of Global Sender Id Black List : " + stringTemplate.opsForSet().isMember(key, senderId));
		return stringTemplate.opsForSet().isMember(key, senderId.toLowerCase());
	}
}
