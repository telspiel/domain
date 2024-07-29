package com.noesis.domain.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserPremiumList;
import com.noesis.domain.repository.UserPremiumListRepository;
import com.noesis.domain.repository.UserPremiumListRepository;

@Service
public class UserPremiumListService {

	private final Logger logger = LoggerFactory.getLogger(getClass()); 
	private final UserPremiumListRepository userPremiumListRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	public UserPremiumListService(UserPremiumListRepository userPremiumListRepository) {
		this.userPremiumListRepository = userPremiumListRepository;
	}
	
	@Autowired 
	private RedisTemplate<String, Set<String>> redisTemplateForUserPremiumList;
	
	public boolean loadAllUserPremiumListDataInCache(){
		redisTemplateForUserPremiumList.opsForHash().getOperations().delete("map:user:premiumlist");
		ArrayList<NgUser> ngUserList = userService.loadAllUsers();
		for (NgUser ngUser : ngUserList) {  
				Set<NgUserPremiumList> ngUserPremiumListSet = ngUser.getNgUserPremiumLists();
				Set<String> userPremiumListNumberSet = new HashSet<>();
				for (NgUserPremiumList ngUserPremiumList : ngUserPremiumListSet) {
					userPremiumListNumberSet.add(ngUserPremiumList.getPremiumNumber());
				}
				redisTemplateForUserPremiumList.opsForHash().put("map:user:premiumlist", ngUser.getUserName(), userPremiumListNumberSet);
		}
		return true;
	}
	
	public Boolean isUserPremiumListNumber(String userName, String number) {
		Set<String> userPremiumListNumberset = (Set<String>)redisTemplateForUserPremiumList.opsForHash().get("map:user:premiumlist", userName);
		if(userPremiumListNumberset != null && userPremiumListNumberset.size() > 0) {
			logger.debug("Number to be search in user premium list : "+ number);
			return userPremiumListNumberset.contains(number);
		}
		return false;
		
	}
}
