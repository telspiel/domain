package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgPushDlrDelivered;

public interface PushDeliveredDlrMessageRepository extends CrudRepository<NgPushDlrDelivered, Serializable> {
	
}
