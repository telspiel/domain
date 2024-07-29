package com.noesis.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgAbusingWordsList;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserAbusingWordsCategoryMap;
import com.noesis.domain.persistence.NgUserBlackList;
import com.noesis.domain.repository.AbusingWordsListRepository;

@Service
public class AbusingWordsListService {

	//private static final Logger logger = LogManager.getLogger(AbusingWordsListService.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AbusingWordsListRepository abusingWordsListRepository;

	@Autowired
	StringRedisTemplate stringTemplate;

	@Autowired
	private UserService userService;
	
	@Autowired 
	private RedisTemplate<String, Set<String>> redisTemplateForAbusingWordsList;
	
	public boolean loadAllUserAbusingWordsDataInCache(){
		redisTemplateForAbusingWordsList.opsForHash().getOperations().delete("map:user:abusingwords");
		ArrayList<NgUser> ngUserList = userService.loadAllUsers();
		for (NgUser ngUser : ngUserList) {
				List<String> userAbusingCategoryList = new ArrayList<>();
				Set<NgUserAbusingWordsCategoryMap> ngUserAbusingWordsCategoryList = ngUser.getNgUserAbusingWordsCategoryMaps();
				for (NgUserAbusingWordsCategoryMap ngUserAbusingWordsCategoryMap : ngUserAbusingWordsCategoryList) {
					userAbusingCategoryList.add(ngUserAbusingWordsCategoryMap.getCategory());
				}
				List<NgAbusingWordsList> abusingWordsList = abusingWordsListRepository.findByAbusingWordCatagoryIn(userAbusingCategoryList);
				Set<String> userAbusingWordsSet = new HashSet<>();
				for (NgAbusingWordsList ngAbusingWordsList : abusingWordsList) {
					userAbusingWordsSet.add(ngAbusingWordsList.getAbusingWord().toLowerCase());
				}
				redisTemplateForAbusingWordsList.opsForHash().put("map:user:abusingwords", ngUser.getUserName(), userAbusingWordsSet);
		}
		return true;
	}
	
	public Boolean isUserAbusingWord(String userName, String abusingWord) {
		Set<String> userAbusingWordset = (Set<String>)redisTemplateForAbusingWordsList.opsForHash().get("map:user:abusingwords", userName);
		if(userAbusingWordset != null && userAbusingWordset.size() > 0) {
			logger.debug("Word to be search in user abusing word list : "+ abusingWord);
			return userAbusingWordset.contains(abusingWord.toLowerCase());
		}
		return false;
	}
	
	public Set<String> getUserAbusingWordsList(String userName) {
		Set<String> userAbusingWordset = (Set<String>)redisTemplateForAbusingWordsList.opsForHash().get("map:user:abusingwords", userName);
		if(userAbusingWordset != null && userAbusingWordset.size() > 0) {
			return userAbusingWordset;
		}
		return null;
	}
	
}
