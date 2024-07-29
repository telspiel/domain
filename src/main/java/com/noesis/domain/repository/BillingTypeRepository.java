package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgBillingType;

public interface BillingTypeRepository extends CrudRepository<NgBillingType, Serializable>{
	NgBillingType findByType(String type);
	
	NgBillingType findByDisplayName(String type);
}


