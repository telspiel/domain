package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noesis.domain.persistence.NgIpRestriction;

@Repository
public interface NgIpRestrictionRepository extends CrudRepository<NgIpRestriction,Serializable> {
	
	List<NgIpRestriction> findByUserName(String userName);

	//List<NgIpRestriction> findByUserName();
	

}
