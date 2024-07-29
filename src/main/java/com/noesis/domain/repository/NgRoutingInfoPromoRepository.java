package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgRoutingInfoPromo;

public interface NgRoutingInfoPromoRepository extends CrudRepository<NgRoutingInfoPromo, Serializable> {

	List<NgRoutingInfoPromo> findByUserId(int userId);

	List<NgRoutingInfoPromo> findByParentUserId(int parentUserId);

	List<NgRoutingInfoPromo> findByUserIdAndSenderId(int userId, int idOfSenderId);
	List<NgRoutingInfoPromo> findByGroupId(int groupId);

	NgRoutingInfoPromo findById(int id);
	
}
