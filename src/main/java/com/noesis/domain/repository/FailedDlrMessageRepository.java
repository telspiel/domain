package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDlrFailed;

public interface FailedDlrMessageRepository extends CrudRepository<NgDlrFailed, Serializable> {
	
	NgDlrFailed findByMessageId(String messageId);
	
	NgDlrFailed findByMessageIdAndIsRetried(String messageId, char isRetried);
	
	List<NgDlrFailed> findByUserIdAndIsRetried(int userId, char isRetried, Pageable pageable);
	
	List<NgDlrFailed> findByIsRetried(char isRetried, Pageable pageable);
}
