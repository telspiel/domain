package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserBlackList;

public interface UserBlackListRepository extends CrudRepository<NgUserBlackList, Serializable> {
	//public NgUserBlackList findByNgUser(NgUser ngUser);
	
	public NgUserBlackList findByBlackListNumber(String blackListNumber);
	
	public Iterable<NgUserBlackList> findByNgUser(NgUser ngUser);
	
	public NgUserBlackList findByNgUserAndBlackListNumber(NgUser ngUser, String blackListNumber);

	public List<NgUserBlackList> findByIdIn(List numbers);

	public List<NgUserBlackList> findByNgUserAndBlackListNumberIn(NgUser ngUser, ArrayList<String> blackListNumber);
	
	@Query(value = "SELECT n.user_id,n.black_list_number FROM ng_user_black_list n",nativeQuery = true)
	public List<Object[]> getBlackListNameAndNumber();
}
