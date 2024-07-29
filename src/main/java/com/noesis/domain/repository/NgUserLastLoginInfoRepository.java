package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUserLastLoginInfo;

public interface NgUserLastLoginInfoRepository extends CrudRepository<NgUserLastLoginInfo, Serializable> {

	NgUserLastLoginInfo findByUserIdAndAppName(int userId, String appName);
	//@Query("select * from ng_user_last_login_info where user_id = :userId order by id desc limit 1")
	List<NgUserLastLoginInfo> findByUserId (int userId);
	
	
	
	
	
	
}


