package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgAccountType;

public interface NgAccountTypeRepository extends CrudRepository<NgAccountType, Serializable>{
	NgAccountType findByCode(String code);
	NgAccountType findByDisplayName(String code);
}

