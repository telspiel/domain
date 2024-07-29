package com.noesis.domain.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgGlobalBlackList;
import com.noesis.domain.persistence.NgGlobalPremiumList;
import com.noesis.domain.repository.GlobalPremiumListRepository;

@Service
public class GlobalPremiumListService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final GlobalPremiumListRepository globalPremiumListRepository;
	
	private final String globalPremiumNumberListKey = "GLOBAL_PREMIUM_NUMBER_LIST";
	
	@Autowired
	public GlobalPremiumListService(GlobalPremiumListRepository globalPremiumListRepository) {
		this.globalPremiumListRepository = globalPremiumListRepository;
	}
	
	@Autowired
	StringRedisTemplate stringTemplate;

	public boolean loadAllGlobalPremiumNumberListDataInCache() {
		stringTemplate.opsForSet().getOperations().delete(globalPremiumNumberListKey);
		ArrayList<NgGlobalPremiumList> ngGlobalPremiumList = new ArrayList<>();
		Set<String> blackListNumberSet = new HashSet<>();
		globalPremiumListRepository.findAll().forEach(ngGlobalPremiumList::add);
		if(ngGlobalPremiumList.size() > 0) {
			for (NgGlobalPremiumList object : ngGlobalPremiumList) {
				blackListNumberSet.add(object.getPremiumNumber());
			}

			String[] values = blackListNumberSet.toArray(new String[blackListNumberSet.size()]);
			logger.info("SetKey add [" + stringTemplate.opsForSet().add(globalPremiumNumberListKey, values) + "] values ");
		}
		return true;
	}
	
	public boolean clearAllPremiumListDataFromCache() {
		stringTemplate.opsForSet().getOperations().delete(globalPremiumNumberListKey);
		return true;
	}
	
	/*public boolean loadAllUserPremiumListDataInCache(){
		redisTemplateForGlobalPremiumList.opsForHash().getOperations().delete("map:global:premiumlist");
		Set<String> globalPremiumListNumberSet = new HashSet<>();
		Iterable<NgGlobalPremiumList> ngGlobalPremiumListIterator = globalPremiumListRepository.findAll();
		for (NgGlobalPremiumList ngGlobalPremiumList : ngGlobalPremiumListIterator) {
			globalPremiumListNumberSet.add(ngGlobalPremiumList.getPremiumNumber());
		}
		redisTemplateForGlobalPremiumList.opsForHash().put("map:global:premiumlist", globalPremiumNumberListKey, globalPremiumListNumberSet);
		return true;
	}*/
	
	public Boolean isGlobalPremiumListNumber(String number) {
		logger.info(number + " is member of Global Premium List : " + stringTemplate.opsForSet().isMember(globalPremiumNumberListKey, number));
		return stringTemplate.opsForSet().isMember(globalPremiumNumberListKey, number);
	}
	/*public Boolean isGlobalPremiumListNumber(String number) {
		Set<String> globalPremiumListNumberset = (Set<String>)redisTemplateForGlobalPremiumList.opsForHash().get("map:user:premiumlist", globalPremiumNumberListKey);
		if(globalPremiumListNumberset != null && globalPremiumListNumberset.size() > 0) {
			logger.debug("Number to be search in user premium list : "+ number);
			return globalPremiumListNumberset.contains(number);
		}
		return false;
		
	}*/
	
	public Boolean addNumberInGlobalPremiumList(String number) {
		NgGlobalPremiumList ngGlobalPremiumList = new NgGlobalPremiumList();
		ngGlobalPremiumList.setCreatedDate(new Date());
		ngGlobalPremiumList.setPremiumNumber(number);
		
		ngGlobalPremiumList = globalPremiumListRepository.save(ngGlobalPremiumList);
		return loadAllGlobalPremiumNumberListDataInCache();
	}
	
	public Boolean removeNumberInGlobalPremiumList(String number) {
		NgGlobalPremiumList ngGlobalPremiumList = globalPremiumListRepository.findByPremiumNumber(number);
		globalPremiumListRepository.delete(ngGlobalPremiumList);
		
		return loadAllGlobalPremiumNumberListDataInCache();
	}

	public Boolean addBulkNumberInGlobalPremiumList(ArrayList<NgGlobalPremiumList> ngGlobalPremiumNumberList)  {
		// Delete all existing numbers;
		globalPremiumListRepository.deleteAll();
		
		// Add new numbers.
		Iterable<NgGlobalPremiumList> ngGlobalPremiumNumberListIterator = globalPremiumListRepository.save(ngGlobalPremiumNumberList);
		
		// Load new numbers in Cache
		return loadAllGlobalPremiumNumberListDataInCache();
	}
}
