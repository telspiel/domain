package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgKannelGroupMappingInfo;
import com.noesis.domain.repository.NgKannelGroupMappingInfoRepository;

@Service
public class NgKannelGroupMappingInfoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgKannelGroupMappingInfoRepository ngKannelGroupMappingInfoRepository;
	
	public List<NgKannelGroupMappingInfo> getKannelDistrubtionInGroup(int groupId){
		List<NgKannelGroupMappingInfo> ngKannelGroupMappingInfoList = ngKannelGroupMappingInfoRepository.findByGroupId(groupId);
		return ngKannelGroupMappingInfoList;
	}

	public boolean saveKannelGroupMappingInfo(List<NgKannelGroupMappingInfo> ngKannelGroupMappingInfoList, Integer groupId) {
		logger.debug("Going to delete exisiting kannel group mapping for group : {}", groupId);
		List<NgKannelGroupMappingInfo> existingNgKannelGroupMappingInfoList = getKannelDistrubtionInGroup(groupId);
		ngKannelGroupMappingInfoRepository.delete(existingNgKannelGroupMappingInfoList);
		logger.debug("Group kannel mapping deleted successfully. Now going to save new kannel group mapping");
		Iterable<NgKannelGroupMappingInfo> iterable = ngKannelGroupMappingInfoRepository.save(ngKannelGroupMappingInfoList);
		if(iterable != null) {
			return true;
		}
		return false;
	}
}
