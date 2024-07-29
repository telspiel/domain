package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgServiceSubType;
import com.noesis.domain.persistence.NgServiceType;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserSenderIdMap;

public interface UserSenderIdMapRepository extends CrudRepository<NgUserSenderIdMap, Serializable> {
	
	
	//@Query(value="select * from ng_user_sender_id_map where is_default='Y' and is_active='Y'", nativeQuery=true)
	public List<NgUserSenderIdMap> findByNgUserInAndIsDefaultInAndIsActiveIn(NgUser ngUser, char isDefault, char isActive);
	
	public List<NgUserSenderIdMap> findByNgUserAndIsDefaultAndIsActive(NgUser ngUser, char isDefault, char isActive);
	
	@Query(value="select * from ng_user_sender_id_map where is_default='Y' and is_active='Y'", nativeQuery=true)
	public List<NgUserSenderIdMap> findAllIsDefaultAndIsActive();

	public NgUserSenderIdMap findByNgUser(int userId);

	public List<NgUserSenderIdMap> findByNgUserAndIsNonDndNumberAllowed(NgUser user, char isDndNumberAllowed);
	
	public NgUserSenderIdMap findBySenderId(String senderId);
	
	@Query(value="select * from ng_user_sender_id_map where sender_id = ?1 and user_id=?2 ", nativeQuery=true)
	public NgUserSenderIdMap findBySenderIdAndUserId(String senderId, int userId);
	
	public List<NgUserSenderIdMap> findByNgUser(NgUser user);
	
	public List<NgUserSenderIdMap> findByNgUserAndIsActive(NgUser user, char isActive);
	
	public List<NgUserSenderIdMap> findByNgUserInAndIsActive(List<NgUser> user, char isActive);

	public NgUserSenderIdMap findById(int idOfSenderId);

	public Iterable<NgUserSenderIdMap> findByNgUserAndIsActiveAndNgServiceTypeAndNgServiceSubType(NgUser ngUser, char c,
			NgServiceType ngServiceType, NgServiceSubType ngServiceSubType);
}
