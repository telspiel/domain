package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgCampaignReport;

public interface NgCampaignReportRepository extends CrudRepository<NgCampaignReport, Serializable> {
	
	public List<NgCampaignReport> findByUserName(String userName);
	
	public List<NgCampaignReport> findByUserNameAndDateGreaterThanEqualAndDateLessThanEqual(String userName, Date fromDate, Date toDate);
	
//	public List<NgCampaignReport> findByUserNameAndScheduleDateGreaterThanEqualAndScheduleDateLessThanEqual(String userName, String fromDate, String toDate);
	
	Long countByUserNameAndDateGreaterThanEqualAndDateLessThanEqual(String userName, Date fromDate, Date toDate);

	public List<NgCampaignReport> findByUserIdAndCampaignId(int userId, int campaignId);

	public List<NgCampaignReport> findByUserIdAndCampaignIdAndCampaignName(int userId, int campaignId, String campaignName);

}
