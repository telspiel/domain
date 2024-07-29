package com.noesis.domain.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserPremiumList;

public interface UserPremiumListRepository extends CrudRepository<NgUserPremiumList, Serializable> {
	public NgUserPremiumList findByNgUser(NgUser ngUser);
	
	@Query(nativeQuery = true,value = "select * from ng_user_premium_list where premium_number =:number")
	public NgUserPremiumList findBypremiumNumber1(@Param("number")String number);
	
	@Query(nativeQuery = true,value = "select * from ng_user_premium_list where premium_number =:number and user_id =:userid")
	public NgUserPremiumList findBypremiumNumber(@Param("number")String number,@Param("userid")Integer userid);
	
	
	
	
}
