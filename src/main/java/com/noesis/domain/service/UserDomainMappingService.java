package com.noesis.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgUserDomainMapping;
import com.noesis.domain.repository.UserDomainMappingRepository;

@Service
public class UserDomainMappingService {
	
	@Autowired
	UserDomainMappingRepository userDomainMappingRepository;
	
	public List<NgUserDomainMapping> findAllDefaultHostByPlatform(){
		List<NgUserDomainMapping> platformDefaultDomains = userDomainMappingRepository.findByPlatformDefaultAndIsActive('Y','Y');
		return platformDefaultDomains;
	}
	
	public List<NgUserDomainMapping> findAllActiveDomainForUser(int userId){
		List<NgUserDomainMapping> userActiveDomains = userDomainMappingRepository.findByUserIdAndIsActive(userId, 'Y');
		return userActiveDomains;
	}
	
	public List<NgUserDomainMapping> findAllDomainForUser(int userId){
		List<NgUserDomainMapping> userActiveDomains = userDomainMappingRepository.findByUserId(userId);
		return userActiveDomains;
	}
	
	public List<NgUserDomainMapping> findAllActiveAndApprovedDomainForUser(int userId){
		List<NgUserDomainMapping> userActiveDomains = userDomainMappingRepository.findByUserIdAndIsActiveAndIsApproved(userId, 'Y', 'Y');
		return userActiveDomains;
	}
	
	public NgUserDomainMapping saveHostName(NgUserDomainMapping hostName) {
		NgUserDomainMapping userDomainMapping = userDomainMappingRepository.save(hostName);
		return userDomainMapping;
	}
	
	public NgUserDomainMapping removeHostNameFromUserHostNameList(int id) {
		NgUserDomainMapping ngUserDomainMapping = userDomainMappingRepository.findById(id);
		userDomainMappingRepository.delete(ngUserDomainMapping);
		return ngUserDomainMapping;
	}

	public NgUserDomainMapping isDomainNameActiveAndApproved(int userId, String domainName, char isActive, char isApproved) {
		NgUserDomainMapping ngUserDomainMapping = userDomainMappingRepository.findByUserIdAndDomainNameAndIsActiveAndIsApproved(userId, domainName, isActive, isApproved);
		return ngUserDomainMapping;
	}
}
