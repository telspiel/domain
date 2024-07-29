package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgBillingCycle;
import com.noesis.domain.persistence.NgDepartment;

public interface BillingCycleRepository extends CrudRepository<NgBillingCycle, Serializable> {
	NgBillingCycle findByType(String type);
	
	NgBillingCycle findByName(String type);
}
