package com.noesis.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgGroup;
import com.noesis.domain.persistence.NgGroupNumberDetails;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.GroupNumberDetailsRepository;
import com.noesis.domain.repository.NgGroupRepository;


@Service
public class GroupNumberDetailsService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private GroupNumberDetailsRepository groupNumberDetailsRepository;
	
	@Autowired
	private NgGroupRepository ngGroupRepository;
	
	@Autowired
	StringRedisTemplate stringTemplate;
	
	public NgGroup getGroup(int groupId) {
		NgGroup ngGroup = ngGroupRepository.findById(groupId);
		return ngGroup;
	}
	
	public Boolean isNumberInGroup(String number) {
		String key = "contactNumberSetKey";
		logger.info(number + " is member of Group : " + stringTemplate.opsForSet().isMember(key, number));
		return stringTemplate.opsForSet().isMember(key, number);
	}
	
	public NgGroupNumberDetails findByContactNumber(String contactNumber) {
		NgGroupNumberDetails ngGroupNumberDetails = groupNumberDetailsRepository.findByContactNumber(contactNumber);
		return ngGroupNumberDetails;
	}
	
	public List<NgGroupNumberDetails> findByGroupName(String groupName) {
		List<NgGroupNumberDetails> ngGroupNumberDetails = groupNumberDetailsRepository.findByGroupName(groupName);
		return ngGroupNumberDetails;
	}
	
	public Boolean addNumberInGroup(NgGroupNumberDetails ngGroupNumberDetails) {
		ngGroupNumberDetails = groupNumberDetailsRepository.save(ngGroupNumberDetails);
		return true;
	}
	
	public Boolean removeNumberFromGroup(String contactNumber) {
		NgGroupNumberDetails ngGroupNumberDetails = groupNumberDetailsRepository.findByContactNumber(contactNumber);
		groupNumberDetailsRepository.delete(ngGroupNumberDetails);
		
		return true;
	}

	public NgGroupNumberDetails isNumberInUserGroups(String contactNumber, List<String> userGroupNameList) {
		NgGroupNumberDetails ngGroupNumberDetails = groupNumberDetailsRepository.findByContactNumberAndGroupNameIn(contactNumber, userGroupNameList);
		return ngGroupNumberDetails;
	}
	
	public NgGroupNumberDetails isNumberInGroup(String contactNumber, String groupName) {
		NgGroupNumberDetails ngGroupNumberDetails = groupNumberDetailsRepository.findByContactNumberAndGroupName(contactNumber, groupName);
		return ngGroupNumberDetails;
	}

	public boolean removeNumberFromGroup(String contactNumber, String groupName) {
		NgGroupNumberDetails ngGroupNumberDetails = groupNumberDetailsRepository.findByContactNumberAndGroupName(contactNumber, groupName);
		groupNumberDetailsRepository.delete(ngGroupNumberDetails);
		return true;
	}
	
	public List<NgGroupNumberDetails> getAllNumbersInGroup(String groupName) {
		List<NgGroupNumberDetails> groupNumbersList = groupNumberDetailsRepository.findByGroupName(groupName);
		return groupNumbersList;
	}
	
	public Iterable<NgGroupNumberDetails> getAllNumbersInGroup(NgGroup ngGroup) {
		Iterable<NgGroupNumberDetails> groupNumbersList = groupNumberDetailsRepository.findByNgGroup(ngGroup);
		return groupNumbersList;
	}
	
	public Long getNumberCountInGroup(NgGroup ngGroup) {
		Long totalNumbersInGroup = groupNumberDetailsRepository.countByNgGroup(ngGroup);
		return totalNumbersInGroup;
	}
	
	public Boolean addBulkNumberInUserGroup(ArrayList<NgGroupNumberDetails> ngUserGroupNumberDetails, NgUser ngUser)  {
		// Add new numbers.
		for (NgGroupNumberDetails ngGroupNumberDetails : ngUserGroupNumberDetails) {
			try{
				groupNumberDetailsRepository.save(ngGroupNumberDetails);
			}catch(Exception ex){
				logger.error("{} Number already exist for user {}", ngGroupNumberDetails.getContactNumber(), ngUser.getUserName());
			}
		}
		return true;
	}
	
	public boolean removeNumbersFromGroup(ArrayList<Integer> numberList) {
		List<NgGroupNumberDetails> ngGroupNumberDetailsList = groupNumberDetailsRepository.findByIdIn(numberList);
		groupNumberDetailsRepository.delete(ngGroupNumberDetailsList);
		return true;
	}

	public Iterable<NgGroupNumberDetails> getAllNumbersInGroups(List<NgGroup> ngGroupList) {
		Iterable<NgGroupNumberDetails> groupNumbersList = groupNumberDetailsRepository.findByNgGroupIn(ngGroupList);
		return groupNumbersList;
	}
}
