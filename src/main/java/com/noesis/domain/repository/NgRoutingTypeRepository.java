package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgRoutingTypeMaster;
import com.noesis.domain.persistence.NgUser;

public interface NgRoutingTypeRepository extends CrudRepository<NgRoutingTypeMaster, Serializable> {
	
}
