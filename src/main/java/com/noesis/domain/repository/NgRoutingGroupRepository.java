package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgRoutingGroupMaster;

public interface NgRoutingGroupRepository extends CrudRepository<NgRoutingGroupMaster, Serializable> {

	List<NgRoutingGroupMaster> findByUserId(int userId);
	public NgRoutingGroupMaster findById(int id);
	
}
