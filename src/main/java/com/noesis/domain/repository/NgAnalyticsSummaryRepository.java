package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgAnalyticsSummary;

	public interface NgAnalyticsSummaryRepository extends CrudRepository<NgAnalyticsSummary, Serializable> {
		
		public List<NgAnalyticsSummary> findByUserName(String userName);

}


