package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noesis.domain.persistence.NgUserCreditStatus;
@Repository
public interface NgUserCreditStatusRepository extends CrudRepository<NgUserCreditStatus, Serializable> {
	NgUserCreditStatus findByUserName(String userName);
	void delete(NgUserCreditStatus ngUserCreditStatus);
	

}
