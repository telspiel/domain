package com.noesis.domain.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDlrMediumType;

public interface NgDlrMediumTypeRepository extends CrudRepository<NgDlrMediumType, Serializable>{
	NgDlrMediumType findByCode(String code);
	
	NgDlrMediumType findByDisplayName(String code);
}
