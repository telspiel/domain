package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgCampaignInfo;

	public interface NgCampaignInfoRepository extends CrudRepository<NgCampaignInfo, Serializable> {
		
		public List<NgCampaignInfo> findByUserId(int userId);
		
		public NgCampaignInfo findById(int id);

}


