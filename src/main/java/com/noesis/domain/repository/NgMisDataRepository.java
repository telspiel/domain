package com.noesis.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgMisData;
import com.noesis.domain.persistence.NgMisDataId;



public interface NgMisDataRepository extends CrudRepository<NgMisData, NgMisDataId> {
	
	public List<NgMisData> findByIdOrgId(Integer orgId);
	
}
