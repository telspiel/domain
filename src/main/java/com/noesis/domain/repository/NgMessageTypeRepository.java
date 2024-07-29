package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgMessageType;

public interface NgMessageTypeRepository extends CrudRepository<NgMessageType, Serializable>{
	NgMessageType findByCode(String code);
	
	NgMessageType findByDisplayName(String code);
}

