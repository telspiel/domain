package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgBillingCycle;
import com.noesis.domain.repository.BillingCycleRepository;

@Service
public class BillingCycleService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BillingCycleRepository billingCycleRepository;

	public NgBillingCycle getBillingCycleByType(String type) {
		NgBillingCycle ngBillingCycle = billingCycleRepository.findByType(type);
		return ngBillingCycle;
	}

	public NgBillingCycle getBillingCycleByName(String type) {
		NgBillingCycle ngBillingCycle = billingCycleRepository.findByName(type);
		return ngBillingCycle;
	}
}
