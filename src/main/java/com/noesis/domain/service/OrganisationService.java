package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgOrganisation;
import com.noesis.domain.repository.OrganisationRepository;

@Service
public class OrganisationService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private OrganisationRepository organisationRepository;
	
	public Iterable<NgOrganisation> getAllOrganisationList() {
		Iterable<NgOrganisation> orgList = organisationRepository.findAll();
		return orgList;
	}

	public NgOrganisation saveOrganisation(NgOrganisation organisation) {
		NgOrganisation ngOrganisation = organisationRepository.save(organisation);
		return ngOrganisation;
		
	}
	
	public NgOrganisation getOrganisationById(int orgId) {
		NgOrganisation ngOrganisation = organisationRepository.findById(orgId);
		return ngOrganisation;
	}

	public List<NgOrganisation> getAllOrganisationListForSuperAdmin(int saId) {
		List<NgOrganisation> orgList = organisationRepository.findBySaId(saId);
		return orgList;
	}

	public List<NgOrganisation> getAllOrganisationListForAdmin(int adId) {
		List<NgOrganisation> orgList = organisationRepository.findByAdId(adId);
		return orgList;
	}
	
	public List<NgOrganisation> getAllOrganisationListForParentUser(int paId) {
		List<NgOrganisation> orgList = organisationRepository.findByPaId(paId);
		return orgList;
	}
}
