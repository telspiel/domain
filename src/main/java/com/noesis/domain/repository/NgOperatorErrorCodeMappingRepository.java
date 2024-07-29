package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgOperatorErrorCodeMapping;

public interface NgOperatorErrorCodeMappingRepository extends CrudRepository<NgOperatorErrorCodeMapping, Serializable> {

	List<NgOperatorErrorCodeMapping> findByKannelId(Integer id);
	
	List<NgOperatorErrorCodeMapping> findByKannelIdAndIsRetryEnabled(Integer id, char isRetryEnabled);
	List<NgOperatorErrorCodeMapping> findByKannelIdAndErrorCode(Integer id, String errorCode);

}
