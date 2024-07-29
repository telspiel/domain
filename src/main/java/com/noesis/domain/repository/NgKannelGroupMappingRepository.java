package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgKannelGroupMapping;

public interface NgKannelGroupMappingRepository extends CrudRepository<NgKannelGroupMapping, Serializable> {

	Iterable<NgKannelGroupMapping> findByGroupId(Integer groupId);
	
}
