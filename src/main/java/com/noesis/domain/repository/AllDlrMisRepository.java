package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDlrMessage;
import com.noesis.domain.persistence.NgDlrRetryAll;

public interface AllDlrMisRepository extends CrudRepository<NgDlrRetryAll, Serializable> {
	NgDlrRetryAll findByMessageId(String messageId);
}
