package com.noesis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgServiceSubType;
import com.noesis.domain.repository.NgServiceSubTypeRepository;

@Service
public class NgServiceSubTypeService {
	
	@Autowired
	NgServiceSubTypeRepository ngServiceSubTypeRepository;
	
	public NgServiceSubType getServiceSubTypeByCode(String displayCode) {
		NgServiceSubType ngServiceSubType = ngServiceSubTypeRepository.findByDisplayCode(displayCode);
		return ngServiceSubType;
	}
}
