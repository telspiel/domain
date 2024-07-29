package com.noesis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgServiceType;
import com.noesis.domain.repository.NgServiceTypeRepository;

@Service
public class NgServiceTypeService {
	
	@Autowired
	NgServiceTypeRepository ngServiceTypeRepository;
	
	public NgServiceType getServiceTypeByCode(String displayCode) {
		NgServiceType ngServiceType = ngServiceTypeRepository.findByDisplayCode(displayCode);
		return ngServiceType;
	}
}
