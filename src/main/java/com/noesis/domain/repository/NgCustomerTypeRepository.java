package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgCustomerType;

public interface NgCustomerTypeRepository extends CrudRepository<NgCustomerType, Serializable> {
	NgCustomerType findByCustType(String custType);
	
	NgCustomerType findByDisplayName(String custType);
}
