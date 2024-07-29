package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgOperatorInfo;

public interface NgOperatorInfoRepository extends CrudRepository<NgOperatorInfo, Serializable> {

	NgOperatorInfo findByOperatorId(String operatorId);
	
}
