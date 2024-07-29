package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgOrganisation;

public interface OrganisationRepository extends CrudRepository<NgOrganisation, Serializable> {
	
	public NgOrganisation findById(int id);
	
	public List<NgOrganisation> findBySaId(int SaId);
	
	public List<NgOrganisation> findByAdId(int adId);
	
	public List<NgOrganisation> findByPaId(int paId);
}
