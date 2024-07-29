package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgGroup;
import com.noesis.domain.persistence.NgUser;

public interface NgGroupRepository extends CrudRepository<NgGroup, Serializable> {
	
	public NgGroup findById(int id);

	public NgGroup findByGroupName(String groupName);

	public List<NgGroup> findByNgUser(NgUser ngUser);
	
	
}
