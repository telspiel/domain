package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgServiceType;

public interface NgServiceTypeRepository extends CrudRepository<NgServiceType, Serializable> {

	NgServiceType findByDisplayCode(String displayCode);
	
}
