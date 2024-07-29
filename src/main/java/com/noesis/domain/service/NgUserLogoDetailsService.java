package com.noesis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgUserLogoDetails;
import com.noesis.domain.repository.NgUserLogoDetailsRepository;

@Service
public class NgUserLogoDetailsService {
	
	@Autowired
	NgUserLogoDetailsRepository ngUserLogoDetailsRepository;
	
	public NgUserLogoDetails findByUserId(int userId) {
		NgUserLogoDetails ngUserLogoDetails = ngUserLogoDetailsRepository.findByUserId(userId);
		return ngUserLogoDetails;
	}

	public NgUserLogoDetails saveUserLogoDetails(NgUserLogoDetails userLogoDetails) {
		NgUserLogoDetails savedUserLogoDetails = ngUserLogoDetailsRepository.save(userLogoDetails);
		return savedUserLogoDetails;
	}
}
