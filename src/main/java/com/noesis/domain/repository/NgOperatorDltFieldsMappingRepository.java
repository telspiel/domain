package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgOperatorDltFieldsMapping;

public interface NgOperatorDltFieldsMappingRepository extends CrudRepository<NgOperatorDltFieldsMapping, Serializable> {

	List<NgOperatorDltFieldsMapping> findByOperatorIdAndFileType(String operatorId, String fileType);
	List<NgOperatorDltFieldsMapping> findByFileType(String fileType);
}
