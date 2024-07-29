package com.noesis.domain.service;

import java.util.ArrayList;
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

import com.noesis.domain.common.IDConverter;
import com.noesis.domain.persistence.NgShortUrl;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgShortUrlRepository;

@Service
public class ShortUrlService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String shortUrlIntIdKey = "SHORT_URL_INT_ID";
	
	private final String shortUrlMapKey = "SHORT_URL_MAP";
	
	@Autowired
	private UserService userService;

	@Autowired
	NgShortUrlRepository ngShortUrlRepository;
	
	@Autowired 
	private RedisTemplate<String, Integer> redisTemplateForShortUrlId;
	
	@Autowired 
	private RedisTemplate<String, Map<String,String>> redisTemplateForShortUrlMap;
	
	@Value("${short.url.expire.days:90}")
	private String shortUrlExpireDays;
	
	public Long incrementId() {
		Long id = redisTemplateForShortUrlId.opsForValue().increment(shortUrlIntIdKey, 1);
    	return id - 1;
    }
	
	public void saveUrl(String shortUrlKey, String longUrl, int ngUserId, char isDynamic) {
		logger.info("Saving: {} at {}", longUrl, shortUrlKey);
		Map<String, String> shortUrlDetailsMap = new HashMap<>();
		shortUrlDetailsMap.put("longUrl", longUrl);
		shortUrlDetailsMap.put("ngUserId", ""+ngUserId);
		shortUrlDetailsMap.put("isDynamic", ""+isDynamic);
        //redisTemplateForShortUrlMap.opsForHash().put(shortUrlMapKey,shortUrlKey,shortUrlDetailsMap);
        redisTemplateForShortUrlMap.opsForValue().set(shortUrlKey, shortUrlDetailsMap);
        redisTemplateForShortUrlMap.expire(shortUrlKey, Integer.parseInt(shortUrlExpireDays), TimeUnit.DAYS);
    }
	
	public NgShortUrl removeShortUrlFromUserShortUrlList(int id) {
		NgShortUrl ngShortUrl = ngShortUrlRepository.findById(id);
		ngShortUrlRepository.delete(ngShortUrl);
		return ngShortUrl;
	}
	
	public String getLongUrlForShortUrlKey(String shortUrlKey) throws Exception {
		logger.info("Retrieving at {}", shortUrlKey);
        Map<String, String> shortUrlMap = (Map<String, String>)(redisTemplateForShortUrlMap.opsForValue().get(shortUrlKey));
        if(shortUrlMap == null){
        	shortUrlMap = (Map<String, String>)(redisTemplateForShortUrlMap.opsForHash().get(shortUrlMapKey, shortUrlKey));
        }
        logger.info("Retrieved {} at {}", shortUrlMap.get("longUrl"),shortUrlKey);
        String longUrl = shortUrlMap.get("longUrl");
        if (longUrl == null) {
            throw new Exception("URL at key" + shortUrlKey + " does not exist");
        }
        return longUrl;
    }
	
	public NgShortUrl findByShortUrlName(String name) {
		NgShortUrl urlList = ngShortUrlRepository.findByName(name);
		return urlList;
	}
	
	public NgShortUrl findByShortUrlNameAndUserId(String name, Integer userId) {
//		NgShortUrl urlList = ngShortUrlRepository.findByName(name);
		NgShortUrl urlList = ngShortUrlRepository.findByNameAndUserId(name,userId);
		return urlList;
	}
//	New Method 
	public List<NgShortUrl> findByShortUrlNameAndUserId(List<String>  name, Integer userId) {
//		NgShortUrl urlList = ngShortUrlRepository.findByName(name);
		List<NgShortUrl> urlList = ngShortUrlRepository.findByNameAndUserId(name,userId);
		return urlList;
	}
//	end method
	public NgShortUrl saveShortUrl(NgShortUrl shortUrl) {
		NgShortUrl ngShortUrl = ngShortUrlRepository.save(shortUrl);
		return ngShortUrl;
	}
	
	public List<NgShortUrl> getAllActiveShortUrlForUser(NgUser user) {
		List<NgShortUrl> urlList = ngShortUrlRepository.findByUserIdAndIsActive(user.getId(), 'Y');
		return urlList;
	}
	
	public NgShortUrl getShortUrlForUserAndUniqueKey(int userId, String uniqueKey) {
		NgShortUrl ngShortUrl = ngShortUrlRepository.findByUserIdAndUniqueKey(userId, uniqueKey);
		return ngShortUrl;
	}
	
	public String shortenURL(String hostName, String longUrl, int ngUserId, char isDynamic) {
        logger.info("Shortening {}", longUrl);
        Long id = incrementId();
        String uniqueId = IDConverter.createUniqueID(id);
        saveUrl(uniqueId, longUrl, ngUserId, isDynamic);
        return uniqueId;
    }
    
    public Map<String, String> getShortUrlDetailsFromKey(String shortUrlKey) throws Exception {
    	Map<String, String> shortUrlDetails = (Map<String, String>)(redisTemplateForShortUrlMap.opsForValue().get(shortUrlKey));
    	if(shortUrlDetails != null) {
    		logger.info("Short URL details found in redis : {} ",shortUrlDetails.toString() );
        	return shortUrlDetails;
    	}else {
    		shortUrlDetails = (Map<String, String>)(redisTemplateForShortUrlMap.opsForHash().get(shortUrlMapKey, shortUrlKey));
    	    if(shortUrlDetails != null){
    	    	logger.info("Short URL details found in redis : {} ",shortUrlDetails.toString() );
            	return shortUrlDetails;
    	    }
    	}
    	return null;
    }
	public NgShortUrl findByShortUrlId(int id) {
		NgShortUrl urlList = ngShortUrlRepository.findById(id);
		return urlList;
	}
	public void changeCallbackUrl(NgShortUrl shortUrl, String callbackUrl) {
		shortUrl.setCallbackUrl(callbackUrl);
		ngShortUrlRepository.save(shortUrl);
	}

  /*  private String formatLocalURLFromShortener(String localURL) {
        String[] addressComponents = localURL.split("/");
        // remove the endpoint (last index)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < addressComponents.length - 1; ++i) {
            sb.append(addressComponents[i]);
            sb.append('/');
        }
        return sb.toString();
    }*/
}
