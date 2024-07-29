package com.noesis.domain.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgTemplateMessageFieldsMapping;
import com.noesis.domain.repository.NgTemplateMessageFieldMappingRepository;

@Service
public class NgTemplateMessageFieldsMappingService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgTemplateMessageFieldMappingRepository ngTemplateMessageFieldMappingRepository;
	
	
	public Iterable<NgTemplateMessageFieldsMapping> saveTemplateMessageFieldsMappingList(ArrayList<NgTemplateMessageFieldsMapping> fieldMappingList){
		Iterable<NgTemplateMessageFieldsMapping> iterator = ngTemplateMessageFieldMappingRepository.save(fieldMappingList);
		return iterator;
	}	
}
