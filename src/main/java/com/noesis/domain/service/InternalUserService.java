package com.noesis.domain.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.noesis.domain.dto.ChildUserIdQueryDto;
import com.noesis.domain.persistence.NgDepartment;
import com.noesis.domain.persistence.NgOrganisation;
import com.noesis.domain.persistence.NgInternalUser;
import com.noesis.domain.repository.InternalUserRepository;
import com.noesis.domain.repository.UserRepository;

@Service
public class InternalUserService {

	//private static final Logger logger = LogManager.getLogger(UserService.class);
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
	private InternalUserRepository internalUserRepository;

	@Autowired
	public InternalUserService(InternalUserRepository internalUserRepository) {
		this.internalUserRepository = internalUserRepository;
	}

	@Cacheable(value = "internalUserCacheById", key = "#id")
	public NgInternalUser getInternalUserById(int id) {
		NgInternalUser user = internalUserRepository.findOne(id);
		return user;
	}

	@Cacheable(value = "internalUserCacheByName", key = "#userName")
	public NgInternalUser getInternalUserByName(String userName) {
		NgInternalUser user = internalUserRepository.findByUserName(userName);
		if(user !=null) {
			logger.info("User password is from service: " + user.getPassword());
		}
		return user;
	} 
	
	public NgInternalUser getInternalUserByNameFromDb(String userName) {
		NgInternalUser user = internalUserRepository.findByUserName(userName);
		if(user !=null) {
			logger.info("User password is from service: " + user.getPassword());
		}
		return user;
	} 
	
	@CachePut(value = "internalUserCacheById", key = "#id")
	public NgInternalUser updateUserById(int id) {
		NgInternalUser user = getInternalUserById(id);
		internalUserRepository.save(user);
		return user;
	}
	
	@Cacheable(value = "internalUserCacheByName", key="#userName")
	public NgInternalUser addInternalUserInCacheByUserName(String userName) {
		NgInternalUser user = internalUserRepository.findByUserName(userName);
		return user;
	}
	
	@Cacheable(value = "internalUserCacheById", key="#id")
	public NgInternalUser addInternalUserInCacheById(int id) {
		NgInternalUser user = internalUserRepository.findById(id);
		return user;
	}
	
	@Cacheable(value = "all-users")
	public ArrayList<NgInternalUser> loadAllInternalUsers() {
		ArrayList<NgInternalUser> usersList = new ArrayList<NgInternalUser>();
		internalUserRepository.findAll().forEach(usersList::add);;
		return usersList;
	}

	public Iterable<NgInternalUser> getAllInternalUserList() {
		Iterable<NgInternalUser> userList = internalUserRepository.findAll();
		return userList;
	}
		
	public NgInternalUser getInternalUser(int userId) {
		NgInternalUser ngUser = internalUserRepository.findById(userId);
		return ngUser;
	}

	@CachePut(value = "internalUserCacheByName", key = "#userName")
	public NgInternalUser saveInternalUser(String userName, NgInternalUser ngUser) {
		NgInternalUser user = internalUserRepository.save(ngUser);
		return user;
	}

	public List<NgInternalUser> getAllInternalUsersByParentId(int parentId) {
		List<NgInternalUser> childUserList = internalUserRepository.findByParentId(parentId);
		return childUserList;
	}
	
}
