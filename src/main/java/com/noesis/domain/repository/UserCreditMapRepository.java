package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserCreditMap;

public interface UserCreditMapRepository extends CrudRepository<NgUserCreditMap, Serializable> {
	public NgUserCreditMap findByNgUser(NgUser ngUser);
	//public NgUserCreditMap findByUserName(String userName);
}
