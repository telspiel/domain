package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgBillingType;
import com.noesis.domain.repository.BillingTypeRepository;

@Service
public class BillingTypeService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BillingTypeRepository billingTypeRepository;

	public NgBillingType getBillingTypeByType(String type) {
		NgBillingType ngBillingType = billingTypeRepository.findByType(type);
		return ngBillingType;
	}

}
