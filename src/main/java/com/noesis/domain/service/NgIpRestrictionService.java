package com.noesis.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgIpRestriction;
import com.noesis.domain.repository.NgIpRestrictionRepository;





@Service
public class NgIpRestrictionService {
	
	
	@Autowired
	private NgIpRestrictionRepository ngIpRestrictionRepository;
	
	public List<NgIpRestriction> getclientIpByUserName(String userName){
		List<NgIpRestriction> list1 = ngIpRestrictionRepository.findByUserName(userName);
		return list1;
		
	}
	
	
	
	
	
	
	
	
	


}
