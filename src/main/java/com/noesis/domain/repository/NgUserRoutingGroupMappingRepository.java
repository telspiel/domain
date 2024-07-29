package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUserRoutingGroupMapping;

public interface NgUserRoutingGroupMappingRepository extends CrudRepository<NgUserRoutingGroupMapping, Serializable> {
	
}
