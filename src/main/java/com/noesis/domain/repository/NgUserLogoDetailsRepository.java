package com.noesis.domain.repository;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUserLogoDetails;

public interface NgUserLogoDetailsRepository extends CrudRepository<NgUserLogoDetails, Serializable> {
	public NgUserLogoDetails findByUserId(int userId);

}
