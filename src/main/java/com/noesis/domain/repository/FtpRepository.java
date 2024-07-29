package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.FTPCampaign;

public interface FtpRepository extends CrudRepository<FTPCampaign, Serializable> {

	public FTPCampaign findById(int id);

}
