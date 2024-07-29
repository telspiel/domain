package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgSmscAdminMapping;
import com.noesis.domain.repository.NgSmscAdminMappingRepository;

@Service
public class NgSmscAdminMappingService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NgSmscAdminMappingRepository ngSmscAdminMappingRepository;
	
	public NgSmscAdminMapping saveSmsc(NgSmscAdminMapping smsc) {
		NgSmscAdminMapping ngSmscAdminMapping = ngSmscAdminMappingRepository.save(smsc);
		return ngSmscAdminMapping;
	}
	
	public NgSmscAdminMapping getSmscById(int id) {
		NgSmscAdminMapping ngSmscAdminMapping = ngSmscAdminMappingRepository.findById(id);
		return ngSmscAdminMapping;
	}

	public List<NgSmscAdminMapping> getAllSmscListForAdminUser(int adId) {
		List<NgSmscAdminMapping> smscList = ngSmscAdminMappingRepository.findByAdId(adId);
		return smscList;
	}
	
	public List<NgSmscAdminMapping> getAllSmscListForSuperAdminUser(int saId) {
		List<NgSmscAdminMapping> smscList = ngSmscAdminMappingRepository.findBySaId(saId);
		return smscList;
	}
}
