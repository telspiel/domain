package com.noesis.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgPlatformErrorCodes;
import com.noesis.domain.repository.NgPlatformErrorCodesRepository;

@Service
public class NgPlatformErrorCodesService {
	
	@Autowired
	private NgPlatformErrorCodesRepository ngPlatformErrorCodesRepository;
	
	public List<NgPlatformErrorCodes> getAllErrorCodesListForAdmin(int adId) {
		List<NgPlatformErrorCodes> errorCodesList = ngPlatformErrorCodesRepository.findByAdId(adId);
		return errorCodesList;
	}

}
