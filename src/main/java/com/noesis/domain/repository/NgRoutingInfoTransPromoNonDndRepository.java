package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgRoutingInfoTransPromoNonDnd;

public interface NgRoutingInfoTransPromoNonDndRepository extends CrudRepository<NgRoutingInfoTransPromoNonDnd, Serializable> {

	List<NgRoutingInfoTransPromoNonDnd> findByUserId(int userId);

	List<NgRoutingInfoTransPromoNonDnd> findByParentUserId(int parentUserId);

	List<NgRoutingInfoTransPromoNonDnd> findByUserIdAndSenderId(int userId, int idOfSenderId);
	List<NgRoutingInfoTransPromoNonDnd> findByGroupId(int groupId);

	NgRoutingInfoTransPromoNonDnd findById(int id);
}
