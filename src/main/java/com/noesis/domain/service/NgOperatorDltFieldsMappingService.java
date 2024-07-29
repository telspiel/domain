package com.noesis.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgOperatorDltFieldsMapping;
import com.noesis.domain.persistence.NgOperatorInfo;
import com.noesis.domain.repository.NgOperatorDltFieldsMappingRepository;

@Service
public class NgOperatorDltFieldsMappingService {
	
	@Autowired
	NgOperatorDltFieldsMappingRepository ngOperatorDltFieldsMappingRepository;

	public List<NgOperatorDltFieldsMapping> getAllFieldsForFileTypeAndOperator(String operatorId, String fileType) {
		List<NgOperatorDltFieldsMapping> operatorFieldsMappingList = ngOperatorDltFieldsMappingRepository.findByOperatorIdAndFileType(operatorId, fileType);
		return operatorFieldsMappingList;
	}
	public List<NgOperatorDltFieldsMapping> getAllFieldsForFileType(String fileType) {
		List<NgOperatorDltFieldsMapping> operatorFieldsMappingList = ngOperatorDltFieldsMappingRepository.findByFileType(fileType);
		return operatorFieldsMappingList;
	}
}
