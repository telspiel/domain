package com.noesis.domain.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgGlobalDndList;
import com.noesis.domain.repository.GlobalDndListRepository;

@Service
public class GlobalDndListService {

	//private static final Logger logger = LogManager.getLogger(GlobalDndListService.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private GlobalDndListRepository dndListRepository;
	
	/* @Autowired
	 private RedisTemplate< String, Set<String> > template;
	 
	 @Autowired 
	 private RedisTemplate< String, String[] > arrayTemplate;*/
	 
	 @Autowired
	 StringRedisTemplate stringTemplate; 

	public boolean loadAllDndDataInCache(){
		ArrayList<NgGlobalDndList> ngGlobalDndList = new ArrayList<>();
		Set<String> dndNumberSet = new HashSet<>();
		dndListRepository.findAll().forEach(ngGlobalDndList::add);
		
		for (NgGlobalDndList object : ngGlobalDndList) {
			dndNumberSet.add(object.getPhoneNumber());
		}
/*		template.opsForSet().add("dndNumberSet", dndNumberSet);
		arrayTemplate.opsForSet().add("dndNumberSetAsArray", dndNumberSet.toArray(new String[dndNumberSet.size()]));
*/		
		String key = "dndNumberSetKey";
		String[] values = dndNumberSet.toArray(new String[dndNumberSet.size()]);
		logger.info("SetKey add [" + stringTemplate.opsForSet().add(key, values ) + "] values ");
		return true;
	}
	
	public boolean clearAllDndDataFromCache() {
		String key = "dndNumberSetKey";
		stringTemplate.opsForSet().getOperations().delete(key);
		return true;
	}
	
	public Boolean isDndNumber(String number) {
		String key = "dndNumberSetKey";
		logger.info(number + " is member of Dnd List : " + stringTemplate.opsForSet().isMember(key, number));
		return stringTemplate.opsForSet().isMember(key, number);
		
	}
}
