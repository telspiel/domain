package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgPlatformErrorCodes;

public interface NgPlatformErrorCodesRepository extends CrudRepository<NgPlatformErrorCodes, Serializable> {
	
	List<NgPlatformErrorCodes> findByAdId(int adId);
	
}


