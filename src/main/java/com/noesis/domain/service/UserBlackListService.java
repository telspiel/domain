package com.noesis.domain.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserBlackList;
import com.noesis.domain.persistence.NgUserSenderIdBlackList;
import com.noesis.domain.repository.UserBlackListRepository;

@Service
public class UserBlackListService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final UserBlackListRepository userBlackListRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	public UserBlackListService(UserBlackListRepository userBlackListRepository) {
		this.userBlackListRepository = userBlackListRepository;
	}
	
	@Autowired 
	//@Qualifier("redisTemplateForUserBlackList")
	private RedisTemplate<String, Set<String>> redisTemplateForUserBlackList;
	
	@Autowired 
	private RedisTemplate<String, Set<String>> redisTemplateForUserSenderIdBlackList;
	
	public boolean loadAllUserBlackListDataInCache() {
	    redisTemplateForUserBlackList.opsForHash().getOperations().delete("map:user:blacklist");

	    ArrayList<NgUser> ngUserList = userService.loadAllUsersFromDB();
	    List<CompletableFuture<Void>> futures = new ArrayList<>();

	    for (NgUser ngUser : ngUserList) {
	        if (ngUser.getIsBlackListAllowed() == 'Y') {
	        	//Add-On some code for resolving the Black List Number (Aman)
	            futures.add(CompletableFuture.runAsync(() -> {
	                Iterable<NgUserBlackList> ngUserBlackListSet = userBlackListRepository.findByNgUser(ngUser);
	                Set<String> userBlackListNumberSet = new HashSet<>();

	                for (NgUserBlackList ngUserBlackList : ngUserBlackListSet) {
	                    userBlackListNumberSet.add(ngUserBlackList.getBlackListNumber());
	                }

	                redisTemplateForUserBlackList.opsForHash().put("map:user:blacklist", ngUser.getUserName(), userBlackListNumberSet);
	            }));
	        }
	    }

	    // Wait for all CompletableFuture tasks to complete
	    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
	    return true;
	}
	 //@Cacheable(value = "numbers", key = "#userName")
	public Boolean isUserBlackListNumber(String userName, String number) {
		long t3 = System.currentTimeMillis();
	    Set<String> userBlackListNumberSet = (Set<String>) redisTemplateForUserBlackList.opsForHash().get("map:user:blacklist", userName);
	    long t4 = System.currentTimeMillis();
	    System.out.println("redis"  + (t4 - t3));
	    //long t5 = System.currentTimeMillis();
	    Map<String, String> map = new HashMap<>();
	    for(String s : userBlackListNumberSet) {
	    	map.put(s, s);
	    }
	    long t6 = System.currentTimeMillis();
	    //System.out.println("iteration"  + (t6 - t5));
	    long t7 = System.currentTimeMillis();
	    if (userBlackListNumberSet != null && userBlackListNumberSet.contains(number)) {
	    	long t8 = System.currentTimeMillis();
	    	System.out.println("get in if"  + (t8 - t7));
	        logger.debug("Number to be searched in user blacklist: " + number);
	        return true;
	    }
	     return false;
	}
	// start
//	public Boolean isUserBlackListNumber( String userId,String number,Map<String, Integer> map ) {
//		
//		if (map!= null && map.containsKey(number)) {
//			
//			if(map.get(number).equals(Integer.parseInt(userId))) {
//				
//				return true;
//				
//			}
//		}
//		return false;
//	}
	
	// end
	
	public Boolean addBulkNumberInUserBlackList(ArrayList<NgUserBlackList> ngUserBlackNumberList, NgUser ngUser) {
	    // Delete all existing numbers
	    // userBlackListRepository.deleteAll();

	    // Add new numbers
	    for (NgUserBlackList ngUserBlackList : ngUserBlackNumberList) {
	        try {
	            userBlackListRepository.save(ngUserBlackList);
	        } catch (Exception ex) {
	            logger.error("{} Number already exists for user {}", ngUserBlackList.getBlackListNumber(), ngUser.getUserName());
	        }
	    }
		//userBlackListRepository.save(ngUserBlackNumberList);
	    // Load new numbers into cache
	    return loadAllUserBlackListDataInCache();
	}

	public boolean addNumberInUserBlackList(NgUserBlackList ngUserBlackList) {
	    ngUserBlackList = userBlackListRepository.save(ngUserBlackList);
	    return loadAllUserBlackListDataInCache();
	}

	public boolean removeNumberFromUserBlackList(String number) {
	    NgUserBlackList ngUserBlackList = userBlackListRepository.findByBlackListNumber(number);
	    userBlackListRepository.delete(ngUserBlackList);
	    return true;
	}

	public boolean loadAllUserSenderIdBlackListDataInCache() {
	    redisTemplateForUserSenderIdBlackList.opsForHash().getOperations().delete("map:user:senderid:blacklist");

	    ArrayList<NgUser> ngUserList = userService.loadAllUsers();
	    List<CompletableFuture<Void>> futures = new ArrayList<>();

	    for (NgUser ngUser : ngUserList) {
	        futures.add(CompletableFuture.runAsync(() -> {
	            Set<NgUserSenderIdBlackList> ngUserSenderIdBlackListSet = ngUser.getNgUserSenderIdBlackLists();
	            Set<String> userBlackListSenderIdSet = new HashSet<>();

	            for (NgUserSenderIdBlackList ngUserSenderIdBlackList : ngUserSenderIdBlackListSet) {
	                userBlackListSenderIdSet.add(ngUserSenderIdBlackList.getSenderId().toLowerCase());
	            }

	            redisTemplateForUserBlackList.opsForHash().put("map:user:senderid:blacklist", ngUser.getUserName(), userBlackListSenderIdSet);
	        }));
	    }

	    // Wait for all CompletableFuture tasks to complete
	    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
	    return true;
	}

	public Boolean isUserSenderIdBlackList(String userName, String senderId) {
	    Set<String> userBlackListSenderIdSet = (Set<String>) redisTemplateForUserSenderIdBlackList.opsForHash().get("map:user:senderid:blacklist", userName);
	    if (userBlackListSenderIdSet != null && userBlackListSenderIdSet.contains(senderId.toLowerCase())) {
	        logger.debug("Sender ID to be searched in user sender ID blacklist: " + senderId);
	        return true;
	    }
	    return false;
	}

	public Iterable<NgUserBlackList> getAllUserBlacklistNumbers(NgUser ngUser) {
	    return userBlackListRepository.findByNgUser(ngUser);
	}

	public NgUserBlackList isBlackListNumber(NgUser ngUser, String blackListNumber) {
	    return userBlackListRepository.findByNgUserAndBlackListNumber(ngUser, blackListNumber);
	}

	public boolean removeUserBlackListNumbers(NgUser ngUser, ArrayList<String> blackListNumber) {
	    List<NgUserBlackList> ngUserBlackList = userBlackListRepository.findByNgUserAndBlackListNumberIn(ngUser, blackListNumber);
	    userBlackListRepository.delete(ngUserBlackList);
	    loadAllUserBlackListDataInCache();
	    return true;
	}

	public boolean removeNumberFromUserBlackList(ArrayList<Integer> numberToBeRemoved) {
	    List<NgUserBlackList> ngUserBlackList = userBlackListRepository.findByIdIn(numberToBeRemoved);
	    userBlackListRepository.delete(ngUserBlackList);
	    loadAllUserBlackListDataInCache();
	    return true;
	}
	// userblacklist from db taken from aman****************************************************************
	//Check validation for User Blacklist Number from DB
		public boolean isUserBlackListNumberFromDB(NgUser ngUser, String number) {
			NgUserBlackList blackList = userBlackListRepository.findByNgUserAndBlackListNumber(ngUser, number);
			if (blackList != null) {
				return true;
			}
			return false;
		}
	// end***************************************************
	
}
