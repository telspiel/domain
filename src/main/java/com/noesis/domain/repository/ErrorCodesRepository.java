package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgErrorMaster;

public interface ErrorCodesRepository extends CrudRepository<NgErrorMaster, Serializable> {
	public NgErrorMaster findByErrorCode(int errorCode);
}
