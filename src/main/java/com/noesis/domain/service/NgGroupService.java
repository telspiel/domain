package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgGroup;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgGroupRepository;

@Service
public class NgGroupService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgGroupRepository ngGroupRepository;
	
	@Autowired
	StringRedisTemplate stringTemplate;
	
	public NgGroup findByGroupId(int id) {
		NgGroup ngGroup = ngGroupRepository.findById(id);
		return ngGroup;
	}
	
	public NgGroup getGroupById(int groupId) {
		NgGroup ngGroup = ngGroupRepository.findById(groupId);
		return ngGroup;
	}
	
	public NgGroup findByGroupName(String groupName) {
		NgGroup ngGroup = ngGroupRepository.findByGroupName(groupName);
		return ngGroup;
	}
	
	public Iterable<NgGroup> getAllGroupList() {
		Iterable<NgGroup> grpList = ngGroupRepository.findAll();
		return grpList;
	}
	
	public List<NgGroup> getAllGroupForUser(NgUser ngUser) {
		List<NgGroup> grpList = ngGroupRepository.findByNgUser(ngUser);
		return grpList;
	}
	
	public NgGroup saveGroup(NgGroup group) {
		NgGroup ngGroup = ngGroupRepository.save(group);
		return ngGroup;
	}
	
	public NgGroup removeGroupFromUserGroupList(String groupName) {
		NgGroup grpList = ngGroupRepository.findByGroupName(groupName);
		ngGroupRepository.delete(grpList);
		return grpList;
	}
}
