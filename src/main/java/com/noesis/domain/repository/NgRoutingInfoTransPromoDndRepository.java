package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgRoutingInfoTransPromoDnd;

public interface NgRoutingInfoTransPromoDndRepository extends CrudRepository<NgRoutingInfoTransPromoDnd, Serializable> {

	List<NgRoutingInfoTransPromoDnd> findByUserId(int userId);

	List<NgRoutingInfoTransPromoDnd> findByParentUserId(int parentUserId);

	List<NgRoutingInfoTransPromoDnd> findByUserIdAndSenderId(int userId, int idOfSenderId);
	List<NgRoutingInfoTransPromoDnd> findByGroupId(int groupId);

	NgRoutingInfoTransPromoDnd findById(int id);
}
