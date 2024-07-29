package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgAnalyticsCurrDate;

public interface NgAnalyticsCurrDateRepository extends CrudRepository<NgAnalyticsCurrDate, Serializable> {

	public List<NgAnalyticsCurrDate> findByUserId(int userId);
}
