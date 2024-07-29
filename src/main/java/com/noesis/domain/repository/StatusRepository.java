package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgStatus;

public interface StatusRepository extends CrudRepository<NgStatus, Serializable> {
	NgStatus findByCode(String code);
	NgStatus findByDisplayName(String code);
}
