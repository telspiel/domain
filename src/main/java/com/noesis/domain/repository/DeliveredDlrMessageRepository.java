package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDlrDelivered;

public interface DeliveredDlrMessageRepository extends CrudRepository<NgDlrDelivered, Serializable> {
	
}
