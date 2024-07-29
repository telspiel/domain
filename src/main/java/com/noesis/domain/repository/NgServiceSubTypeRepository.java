package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgServiceSubType;

public interface NgServiceSubTypeRepository extends CrudRepository<NgServiceSubType, Serializable> {
	
	NgServiceSubType findByDisplayCode(String displayCode);
	
}
