package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDlrRetryTmp;

public interface DlrRetryMisTempRepository extends CrudRepository<NgDlrRetryTmp, Serializable> {
	NgDlrRetryTmp findByMessageId(String messageId);
}
