package com.noesis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgOperatorInfo;
import com.noesis.domain.repository.NgOperatorInfoRepository;

@Service
public class NgOperatorInfoService {
	
	@Autowired
	NgOperatorInfoRepository ngOperatorInfoRepository;

	public NgOperatorInfo getOperatorInfoByOperatorId(String operatorId) {
		NgOperatorInfo operatorInfo = ngOperatorInfoRepository.findByOperatorId(operatorId);
		return operatorInfo;
	}
}
