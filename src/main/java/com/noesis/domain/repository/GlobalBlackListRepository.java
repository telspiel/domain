package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noesis.domain.persistence.NgGlobalBlackList;
@Repository
public interface GlobalBlackListRepository extends CrudRepository<NgGlobalBlackList, Serializable> {
	public NgGlobalBlackList findByPhoneNumber(String phoneNumber);
	//public NgGlobalBlackList save(NgGlobalBlackList ngGlobalBlackList);
	@Query(nativeQuery = true,value = "SELECT * FROM ng_global_black_list ;")
	public List<NgGlobalBlackList> findAll();
	//public void saveAll(List<NgGlobalBlackList> saveNumberInDataBase);
	//public void saveAll(List<NgGlobalBlackList> list);
	
}
