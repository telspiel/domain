package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgSmscAdminMapping;

public interface NgSmscAdminMappingRepository extends CrudRepository<NgSmscAdminMapping, Serializable> {

	NgSmscAdminMapping findById(int id);

	List<NgSmscAdminMapping> findByAdId(int adId);
	
	List<NgSmscAdminMapping> findBySaId(int saId);
}


