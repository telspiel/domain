package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDownloadReportInfo;

public interface NgDownloadReportInfoRepository extends CrudRepository<NgDownloadReportInfo, Serializable> {
	public NgDownloadReportInfo findById(int id);
	
	public List<NgDownloadReportInfo> findByUserId(int userId);

	public List<NgDownloadReportInfo> findByStatus(char c, Pageable i);
}
