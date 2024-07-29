package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgKannelGroupMappingInfo;

public interface NgKannelGroupMappingInfoRepository extends CrudRepository<NgKannelGroupMappingInfo, Serializable> {

	List<NgKannelGroupMappingInfo> findByGroupId(int groupId);
	
}
