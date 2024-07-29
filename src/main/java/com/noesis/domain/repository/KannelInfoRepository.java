package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgKannelInfo;

public interface KannelInfoRepository extends CrudRepository<NgKannelInfo, Serializable> {
	@Query(value = "select id, kannel_name, is_active, max_tps,kannel_url, dlr_url from ng_kannel_info where is_active = 'Y'", nativeQuery=true)
	public List<NgKannelInfo> getAllIsActiveIn(char isActive);
	
	
	public List<NgKannelInfo> findByIsActive(char isActive);
	
	public List<NgKannelInfo> findByIsActiveAndKannelMessageType(char isActive, String kannelType);
	
	public NgKannelInfo findByIsActiveAndId(char isActive, Integer kannelId);
	
	public NgKannelInfo findById(Integer kannelId);
	
	public List<NgKannelInfo> findByIsActiveAndIdIn(char isActive, List<Integer> kannelIds);

	public List<NgKannelInfo> findByUserIdOrIdLessThan(int userId, int dummyKannelId);
	
	public List<NgKannelInfo> findByIsActiveAndUserIdOrIdLessThan(char isActive, int userId, int dummyKannelId);
	
}
