package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgInternalUser;

public interface InternalUserRepository extends CrudRepository<NgInternalUser, Serializable> {
	public NgInternalUser findByUserName(String userName);

	public NgInternalUser findById(int id);
	
	public List<NgInternalUser> findByParentId(int parentId);
	
	//public List<NgInternalUser> findByAmId(int amId);


}
