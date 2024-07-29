package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgGroup;
import com.noesis.domain.persistence.NgGroupNumberDetails;

public interface GroupNumberDetailsRepository extends CrudRepository<NgGroupNumberDetails, Serializable> {
	
	public NgGroupNumberDetails findByContactNumber(String contactNumber);

	public NgGroupNumberDetails findByContactNumberAndGroupName(String contactNumber, String groupName);
	
	public List<NgGroupNumberDetails> findByGroupName(String groupName);
	
	public Iterable<NgGroupNumberDetails> findByNgGroup(NgGroup ngGroup);

	public Long countByNgGroup(NgGroup ngGroup);

	public NgGroupNumberDetails findByContactNumberAndGroupNameIn(String contactNumber, List<String> userGroupNameList);

	public List<NgGroupNumberDetails> findByIdIn(List numberList);

	public Iterable<NgGroupNumberDetails> findByNgGroupIn(List<NgGroup> ngGroupList);
	
}
