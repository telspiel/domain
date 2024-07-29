package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noesis.domain.dto.ChildUserIdQueryDto;
import com.noesis.domain.dto.UserOptimizeDto;
import com.noesis.domain.persistence.NgDepartment;
import com.noesis.domain.persistence.NgOrganisation;
import com.noesis.domain.persistence.NgUserRole;
import com.noesis.domain.persistence.NgUser;
@Repository
public interface UserRepository extends CrudRepository<NgUser, Serializable> {
	public NgUser findByUserName(String userName);

	public NgUser findById(int id);
	
	public List<NgUser> findByParentId(int parentId);
	public List<NgUser> findByParentIdOrderByUserNameAsc(int parentId);
	
	public List<NgUser> findByAmId(int amId);
	
	public List<NgUser> findBySaId(int saId);
	
	@Query(value = "select id as id from NgUser where amId = :amId")
	public List<ChildUserIdQueryDto> getChildUserIdsForAccountManager(@Param("amId") Integer amId);
	
	@Query(value = "select id as id from NgUser where saId = :saId and adId = :adId")
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndAdmin(@Param("saId") Integer saId, @Param("adId") Integer adId);
	
	@Query(value = "select id as id from NgUser where saId = :saId and reId = :reId")
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndReseller(@Param("saId") Integer saId, @Param("reId") Integer reId);
	
	@Query(value = "select id as id from NgUser where saId = :saId and seId = :seId")
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndSeller(@Param("saId") Integer saId, @Param("seId") Integer seId);
	
	@Query(value = "select id as id from NgUser where saId = :saId and id = :userId")
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndClient(@Param("saId") Integer saId, @Param("userId") Integer userId);
	
	@Query(value = "select id as id from NgUser where adId = :adId and reId = :reId")
	public List<ChildUserIdQueryDto> getChildUserIdsForAdminAndReseller(@Param("adId") Integer adId, @Param("reId") Integer reId);
	
	@Query(value = "select id as id from NgUser where adId = :adId and seId = :seId")
	public List<ChildUserIdQueryDto> getChildUserIdsForAdminAndSeller(@Param("adId") Integer adId, @Param("seId") Integer seId);
	
	@Query(value = "select id as id from NgUser where adId = :adId and id = :userId")
	public List<ChildUserIdQueryDto> getChildUserIdsForAdminAndClient(@Param("adId") Integer adId, @Param("userId") Integer userId);
	
	@Query(value = "select id as id from NgUser where reId = :reId and seId = :seId")
	public List<ChildUserIdQueryDto> getChildUserIdsForResellerAndSeller(@Param("reId") Integer reId, @Param("seId") Integer seId);
	
	@Query(value = "select id as id from NgUser where reId = :reId and id = :userId")
	public List<ChildUserIdQueryDto> getChildUserIdsForResellerAndClient(@Param("reId") Integer reId, @Param("userId") Integer userId);

	@Query(value = "select id as id from NgUser where seId = :seId and id = :userId")
	public List<ChildUserIdQueryDto> getChildUserIdsForSellerAndClient(@Param("seId") Integer seId, @Param("userId") Integer userId);

	public List<NgUser> findByNgOrganisationAndNgDepartment(NgOrganisation org, NgDepartment dept);

	public List<NgUser> findByAdId(int adId);

	public Page<NgUser> findByParentId(int id, Pageable pageable);

	public Page<NgUser> findByParentIdAndNgUserRoleNotIn(int id, NgUserRole ngUserRole, Pageable pageable);

	public Page<NgUser> findByParentIdAndNgUserRoleAndUserNameNotIn(int id, NgUserRole role, NgUser userName,
			Pageable pageable);
	
//	@Query(nativeQuery = true, value = "SELECT * FROM ng_user WHERE user_name IN (:usernames)")
//	public List<NgUser> findUsersCreditAlert(@Param("usernames")List<String> usernames);
	
	
//	@Query(nativeQuery = true,value = "select user_name,id from ng_user where user_name= :userName")
//	public UserOptimizeDto getUserDetails(@Param("userName") String userName);


//	public Page<NgUser> findByParentIdAndNotUserId(int id, int i, Pageable pageable);

//	public Page<NgUser> findByParentIdAndNotUserRole(int id, int i, Pageable pageable);

//	public Page<NgUser> findByParentIdAndUserRoleNotIn(int id, int i, Pageable pageable);
	
	
	// credit notification
//	@Query(nativeQuery = true,value = "SELECT user_name FROM ng_user WHERE parentId = :parentId;")
//	public List<String> directConsumer(@Param("parentId") int parentId);
	
	//credit notification end

}
