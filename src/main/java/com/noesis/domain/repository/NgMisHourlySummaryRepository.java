package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgMisHourlySummaryReport;

public interface NgMisHourlySummaryRepository extends CrudRepository<NgMisHourlySummaryReport, Serializable>{
	
	public List<NgMisHourlySummaryReport> findByUserNameOrderByHour(String userName);
	
	public List<NgMisHourlySummaryReport> findByPaIdOrderByHour(int paId);
	
	public List<NgMisHourlySummaryReport> findBySaIdOrderByHour(int saId);
	
	public List<NgMisHourlySummaryReport> findByAdIdOrderByHour(int adId);
	
	public List<NgMisHourlySummaryReport> findByReIdOrderByHour(int reId);
	
	public List<NgMisHourlySummaryReport> findBySeIdOrderByHour(int seId);
	
	public List<NgMisHourlySummaryReport> findByAmIdOrderByHour(int amId);
	
}
