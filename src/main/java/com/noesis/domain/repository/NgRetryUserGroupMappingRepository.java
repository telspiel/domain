package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgRetryUserGroupMapping;

public interface NgRetryUserGroupMappingRepository extends CrudRepository<NgRetryUserGroupMapping, Serializable> {
	
	List<NgRetryUserGroupMapping> findByUserIdAndGroupIdNotIn(Integer userId, List<Integer> groupId);
	
	List<NgRetryUserGroupMapping> findByUserIdAndGroupIdNotInOrderByPriorityAsc(Integer userId, List<Integer> groupId);

	List<NgRetryUserGroupMapping> findByUserIdAndPriorityGreaterThan(Integer userId, Integer priority);
}
