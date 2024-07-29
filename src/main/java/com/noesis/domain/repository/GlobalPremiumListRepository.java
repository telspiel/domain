package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgGlobalPremiumList;

public interface GlobalPremiumListRepository extends CrudRepository<NgGlobalPremiumList, Serializable> {
	public NgGlobalPremiumList findByPremiumNumber(String premiumNumber);
}
