package com.noesis.domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgShortUrlChildMapping;
import com.noesis.domain.repository.NgShortUrlChildMappingRepository;

@Service
public class NgShortUrlChildMappingService {

private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String childShortUrlMapKey = "CHILD_SHORT_URL_MAP";
	
	@Autowired
	private UserService userService;

	@Autowired
	NgShortUrlChildMappingRepository ngShortUrlChildMappingRepository;
	
	@Autowired 
	private RedisTemplate<String, Map<String,String>> redisTemplateForChildShortUrlMap;
	
	@Value("${short.url.expire.days:90}")
	private String shortUrlExpireDays;

	public NgShortUrlChildMapping saveChildShortUrlMapping(NgShortUrlChildMapping childShortUrl, String longUrl, char isDynamic) {
		logger.error("BITLY : Going to save child short url mapping  : {}",childShortUrl.getChildUniqueKey());
		NgShortUrlChildMapping ngChildShortUrl = ngShortUrlChildMappingRepository.save(childShortUrl);
		saveChildUrlDetailsInRedis(ngChildShortUrl, longUrl, isDynamic);
		logger.error("BITLY : End saving child short url mapping  : {}",childShortUrl.getChildUniqueKey());
		return ngChildShortUrl;
		
	}
	
	public NgShortUrlChildMapping saveChildShortUrlMappingInDBOnly(NgShortUrlChildMapping childShortUrl, String longUrl, char isDynamic) {
		NgShortUrlChildMapping ngChildShortUrl = ngShortUrlChildMappingRepository.save(childShortUrl);
		return ngChildShortUrl;
	}

	public NgShortUrlChildMapping saveChildShortUrlMappingInRedisOnly(NgShortUrlChildMapping ngChildShortUrl, String longUrl, char isDynamic) {
		saveChildUrlDetailsInRedis(ngChildShortUrl, longUrl, isDynamic);
		return ngChildShortUrl;
	}
	
	public void saveChildUrlDetailsInRedis(NgShortUrlChildMapping ngChildShortUrl, String longUrl, char isDynamic) {
		logger.info("Saving: {} at {}", longUrl, ngChildShortUrl.getChildUniqueKey());
		logger.error("BITLY : Going to save child url in redis : {}",ngChildShortUrl.getChildUniqueKey());
		Map<String, String> childShortUrlDetailsMap = new HashMap<>();
		childShortUrlDetailsMap.put("longUrl", longUrl);
		childShortUrlDetailsMap.put("userId", ""+ngChildShortUrl.getUserId());
		childShortUrlDetailsMap.put("isDynamic", ""+isDynamic);
		childShortUrlDetailsMap.put("mobileNumber", ngChildShortUrl.getMobileNumber());
		childShortUrlDetailsMap.put("campaignName", ngChildShortUrl.getCampaignName());
		childShortUrlDetailsMap.put("childShortUrlId", ""+ngChildShortUrl.getId());
		childShortUrlDetailsMap.put("callbackUrl", ""+ngChildShortUrl.getCallbackUrl());
		childShortUrlDetailsMap.put("parentShortUrl", ""+ngChildShortUrl.getParentShortUrl());
		childShortUrlDetailsMap.put("parentShortUrlId", ""+ngChildShortUrl.getParentShortUrlId());
		childShortUrlDetailsMap.put("campaignId", ""+ngChildShortUrl.getCampaignId());
		childShortUrlDetailsMap.put("campaignDate", ""+ngChildShortUrl.getCreatedDate());
		
		//redisTemplateForChildShortUrlMap.opsForHash().put(childShortUrlMapKey,ngChildShortUrl.getChildUniqueKey(),childShortUrlDetailsMap);
		redisTemplateForChildShortUrlMap.opsForValue().set("child-"+ngChildShortUrl.getChildUniqueKey(),childShortUrlDetailsMap);
		redisTemplateForChildShortUrlMap.expire("child-"+ngChildShortUrl.getChildUniqueKey(), Integer.parseInt(shortUrlExpireDays), TimeUnit.DAYS);
		
		logger.error("BITLY : End saving child url in redis : {}",ngChildShortUrl.getChildUniqueKey());
	}

	 public Map<String, String> getChildShortUrlDetailsFromKey(String shortUrlKey) throws Exception {
	    	Map<String, String> childShortUrlDetails = (Map<String, String>)(redisTemplateForChildShortUrlMap.opsForValue().get("child-"+shortUrlKey));
	    	if(childShortUrlDetails != null) {
	    		logger.info("Short URL details found in redis : {} ",childShortUrlDetails.toString() );
	        	return childShortUrlDetails;
	    	}else{
	    		childShortUrlDetails = (Map<String, String>)(redisTemplateForChildShortUrlMap.opsForHash().get(childShortUrlMapKey, shortUrlKey));
	    		if(childShortUrlDetails != null){
	    			logger.info("Short URL details found in redis : {} ",childShortUrlDetails.toString() );
	    			return childShortUrlDetails;
	    		}
	        }
	    	return null;
	    }

	public NgShortUrlChildMapping findById(int id) {
		NgShortUrlChildMapping ngShortUrlChildMapping = ngShortUrlChildMappingRepository.findById(id);
		return ngShortUrlChildMapping;
	}

	public void saveChildShortUrlListInDBOnly(List<NgShortUrlChildMapping> ngChildShortUrlMappingList) {
		ngShortUrlChildMappingRepository.save(ngChildShortUrlMappingList);
	}
}
