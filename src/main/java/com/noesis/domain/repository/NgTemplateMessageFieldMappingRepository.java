package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgTemplateMessageFieldsMapping;
import com.noesis.domain.persistence.NgTemplateMessageScheduleInfo;

public interface NgTemplateMessageFieldMappingRepository extends CrudRepository<NgTemplateMessageFieldsMapping, Serializable> {
	
	
}
