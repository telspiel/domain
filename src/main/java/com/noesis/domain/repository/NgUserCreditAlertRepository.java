package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUserCreditAlert;


public interface NgUserCreditAlertRepository extends CrudRepository<NgUserCreditAlert, Serializable>{
	
List<NgUserCreditAlert> findByUserName(String username);
}
