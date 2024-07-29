package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgFileUploadInfo;

public interface NgFileUploadInfoRepository extends CrudRepository<NgFileUploadInfo, Serializable> {
	public NgFileUploadInfo findById(int id);
}
