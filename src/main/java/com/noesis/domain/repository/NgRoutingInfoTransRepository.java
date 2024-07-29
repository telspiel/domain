package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.noesis.domain.persistence.NgRoutingInfoTrans;

public interface NgRoutingInfoTransRepository extends CrudRepository<NgRoutingInfoTrans, Serializable> {

	List<NgRoutingInfoTrans> findByUserId(int userId);

	List<NgRoutingInfoTrans> findByParentUserId(int parentUserId);

	List<NgRoutingInfoTrans> findByUserIdAndSenderId(int userId, int idOfSenderId);
	List<NgRoutingInfoTrans> findByGroupId(int groupId);
	NgRoutingInfoTrans findById(int id);
	
	public List<NgRoutingInfoTrans> findByUserIdAndGroupId(int userId,int groupId);
	
	
	
}
