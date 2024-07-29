package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgPriority;

public interface NgPriorityRepository extends CrudRepository<NgPriority, Serializable>{
	NgPriority findByCode(String code);
	
	NgPriority findByDisplayName(String code);
}

