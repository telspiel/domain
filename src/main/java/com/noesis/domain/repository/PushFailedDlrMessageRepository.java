package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgPushDlrFailed;

public interface PushFailedDlrMessageRepository extends CrudRepository<NgPushDlrFailed, Serializable> {
	
	NgPushDlrFailed findByMessageId(String messageId);
	
	NgPushDlrFailed findByMessageIdAndIsRetried(String messageId, char isRetried);
	
	List<NgPushDlrFailed> findByUserIdAndIsRetried(int userId, char isRetried, Pageable pageable);
	
	List<NgPushDlrFailed> findByIsRetried(char isRetried, Pageable pageable);
}
