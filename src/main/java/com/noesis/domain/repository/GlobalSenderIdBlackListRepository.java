package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgGlobalSenderIdBlackList;

public interface GlobalSenderIdBlackListRepository extends CrudRepository<NgGlobalSenderIdBlackList, Serializable> {
	public NgGlobalSenderIdBlackList findBySenderId(String senderId);
}
