package com.noesis.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgRetryUserGroupMapping;
import com.noesis.domain.repository.NgRetryUserGroupMappingRepository;

@Service
public class NgRetryUserGroupMappingService {
	
	@Autowired
	NgRetryUserGroupMappingRepository ngRetryUserGroupMappingRepository;
	
	public List<NgRetryUserGroupMapping> getUserRetryMapping(Integer userId, List<Integer> groupId){
		List<NgRetryUserGroupMapping> ngRetryUserGroupMapping = ngRetryUserGroupMappingRepository.findByUserIdAndGroupIdNotInOrderByPriorityAsc(userId, groupId);
		return ngRetryUserGroupMapping;
	}
	
	public List<NgRetryUserGroupMapping> getUserRetryMappingForPriority(Integer userId, Integer priority){
		List<NgRetryUserGroupMapping> ngRetryUserGroupMapping = ngRetryUserGroupMappingRepository.findByUserIdAndPriorityGreaterThan(userId, priority);
		return ngRetryUserGroupMapping;
	}
}
