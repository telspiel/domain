package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgCarrierMaster;
import com.noesis.domain.persistence.NgCircleMaster;
import com.noesis.domain.persistence.NgNumberCarrierCircleMapping;
import com.noesis.domain.persistence.NgRoutingTypeMaster;
import com.noesis.domain.persistence.NgUser;

public interface NgNumberSeriesRepository extends CrudRepository<NgNumberCarrierCircleMapping, Serializable> {
	
}
