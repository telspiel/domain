package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUserDomainMapping;

public interface UserDomainMappingRepository extends CrudRepository<NgUserDomainMapping, Serializable> {

	List<NgUserDomainMapping> findByPlatformDefaultAndIsActive(char isPlaformDefault, char isActive);
	
	List<NgUserDomainMapping> findByUserIdAndIsActive(int userId, char isActive);
	
	public NgUserDomainMapping findById(int id);

	List<NgUserDomainMapping> findByUserIdAndIsActiveAndIsApproved(int userId, char isActive, char isApproved);

	List<NgUserDomainMapping> findByUserId(int userId);

	NgUserDomainMapping findByUserIdAndDomainNameAndIsActiveAndIsApproved(int userId, String domainName, char isActive,
			char isApproved);

}
