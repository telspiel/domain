package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgGlobalDndList;

public interface GlobalDndListRepository extends CrudRepository<NgGlobalDndList, Serializable> {
	public NgGlobalDndList findByPhoneNumber(String phoneNumber);
}
