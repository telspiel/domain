package com.noesis.domain.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.dto.ChildUserIdQueryDto;
import com.noesis.domain.dto.QueryTranslator;
import com.noesis.domain.dto.UserOptimizeDto;
import com.noesis.domain.persistence.NgContentTemplate;
import com.noesis.domain.persistence.NgDepartment;
import com.noesis.domain.persistence.NgOrganisation;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserRole;
import com.noesis.domain.repository.NgContentTemplateRepository;
import com.noesis.domain.repository.UserRepository;
//import com.noesis.resellerservices.dto.ParentIdWiseRoleData;

@Service
public class UserService {

	//private static final Logger logger = LogManager.getLogger(UserService.class);
    private final Logger logger = LoggerFactory.getLogger(getClass());
	private final UserRepository userRepository;

	private static final String userSenderIdTemplateMapKey = "USER_SENDER_ID_TEMPLATE_MAP_KEY";

	@Autowired 
	//@Qualifier("redisTemplateForContentTemplateList")
	
	private RedisTemplate<String, Set<String>> redisTemplateForContentTemplateList;

	@Autowired
	NgContentTemplateRepository ngContentTemplateRepository;
	
	

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	private QueryTranslator translator;
	

	@Cacheable(value = "userCacheById", key = "#id")
	public NgUser getUserById(int id) {
		logger.info("Getting user by ID from service {}.", id);
		NgUser user = userRepository.findOne(id);
		//logger.info("User password is from service: " + user.getPassword());
		return user;
	}

	
	public NgUser getUserByIdFromDb(int id) {
		logger.info("Getting user by ID from DB {}.", id);
		NgUser user = userRepository.findOne(id);
		logger.info("User found in DB {}" ,user);
		return user;
	}
    // for cache operation
	@Cacheable(value = "userCacheByName", key = "#userName",condition="#userName != null")
	public NgUser getUserByName(String userName) {
		logger.info("Getting user by user name from service {}.", userName);
		NgUser user = userRepository.findByUserName(userName);
		if(user !=null) {
			logger.info("User password is from service: " + user.getPassword());
		}
		return user;
	} 
	//end. can we use try catch here.
	
	public NgUser getUserByNameFromDb(String userName) {
		logger.info("Getting user by user name from service {}.", userName);
		NgUser user = userRepository.findByUserName(userName);
		if(user !=null) {
			logger.info("User password is from service: " + user.getPassword());
		}
		return user;
	} 
	
	@CachePut(value = "userCacheById", key = "#id")
	public NgUser updateUserById(int id) {
		NgUser user = getUserById(id);
		user.setPassword("password2");
		userRepository.save(user);
		logger.info("Getting user by ID from service {}.", id);
		//logger.info("User password is from service: " + user.getPassword());
		return user;
	}
	
	@Cacheable(value = "userCacheByName", key="#userName")
	public NgUser addUserInCacheByUserName(String userName) {
		logger.info("Getting user by username {}.", userName);
		NgUser user = userRepository.findByUserName(userName);
		//logger.info("User password is : " + user.getPassword());
		return user;
	}
	
	@Cacheable(value = "userCacheById", key="#id")
	public NgUser addUserInCacheById(int id) {
		logger.info("Getting user by ID {} from service.", id);
		NgUser user = userRepository.findById(id);
		logger.info("User password from service is : " + user.getPassword());
		return user;
	}
	
	@Cacheable(value = "all-users")
	//@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ArrayList<NgUser> loadAllUsers() {
		logger.info("Loading all users by username");
		ArrayList<NgUser> usersList = new ArrayList<NgUser>();
		userRepository.findAll().forEach(usersList::add);;
		logger.info("Total users found : " + usersList.size());
		return usersList;
	}
	
	public ArrayList<NgUser> loadAllUsersFromDB() {
		logger.info("Loading all users by username");
		ArrayList<NgUser> usersList = new ArrayList<NgUser>();
		userRepository.findAll().forEach(usersList::add);;
		logger.info("Total users found : " + usersList.size());
		return usersList;
	}

	public Iterable<NgUser> getAllUserList() {
		Iterable<NgUser> userList = userRepository.findAll();
		return userList;
	}
		
	public NgUser getUser(int userId) {
		NgUser ngUser = userRepository.findById(userId);
		return ngUser;
	}

	@Transactional
	public NgUser saveUser(NgUser ngUser) {
		NgUser user = userRepository.save(ngUser);
		return user;
	}
	
	@CachePut(value = "userCacheByName", key="#userName")
	public NgUser generateAndSaveTokenForUser(String userName) {
		String token = nextToken();
		NgUser ngUser = userRepository.findByUserName(userName);
		ngUser.setEncryptedPassword(token);
		ngUser = userRepository.save(ngUser);
		return ngUser;
	}
	
/*	@CacheEvict(value = "users-all")
	@GetMapping("/clearAll")
	public void evictAllUsers() {
		logger.info("Evict users-all group from cache");
	}*/

	/*
	 * @CachePut(value = "users", key = "#user.appId")
	 * 
	 * @PutMapping(value="/update") public User updatePersonByID(@RequestBody User
	 * user) { userRepository.save(user); return user; }
	 */



	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final int SECURE_TOKEN_LENGTH = 32;
	private static final SecureRandom random = new SecureRandom();
	private static final char[] symbols = CHARACTERS.toCharArray();
	private static final char[] buf = new char[SECURE_TOKEN_LENGTH];

	public static String nextToken() {
	    for (int idx = 0; idx < buf.length; ++idx)
	        buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	}
	
	public static void main(String[] args) {
		System.out.println(UserService.nextToken());
	}

	public List<NgUser> getAllUsersByParentId(int parentId) {
		List<NgUser> childUserList = userRepository.findByParentId(parentId);
		return childUserList;
	}
	
	public List<NgUser> getAllUsersByAdminId(int adId) {
		List<NgUser> childUserList = userRepository.findByAdId(adId);
		return childUserList;
	}
	
	public List<NgUser> getAllUsersByAmId(int amId) {
		List<NgUser> childUserList = userRepository.findByAmId(amId);
		return childUserList;
	}

	public List<NgUser> getAllUsersBySaId(int saId) {
		List<NgUser> childUserList = userRepository.findBySaId(saId);
		return childUserList;
	}
	
	public List<NgUser> getAllUsersForOrgAndDepartmentExceptClients(NgOrganisation org, NgDepartment dept){
		List<NgUser> userList = userRepository.findByNgOrganisationAndNgDepartment(org, dept);
		return userList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForAccountManagerId(int amId) {
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForAccountManager(amId);
		return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndAdmin(Integer saId, Integer adId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForSuperAdminAndAdmin(saId, adId);
		return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndReseller(Integer saId, Integer reId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForSuperAdminAndReseller(saId, reId);
				return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndSeller(Integer saId, Integer seId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForSuperAdminAndSeller(saId, seId);
				return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForSuperAdminAndClient(Integer saId, Integer userId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForSuperAdminAndClient(saId, userId);
				return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForAdminAndReseller(Integer adId, Integer reId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForAdminAndReseller(adId, reId);
				return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForAdminAndSeller(Integer adId, Integer seId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForAdminAndSeller(adId, seId);
				return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForAdminAndClient(Integer adId, Integer userId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForAdminAndClient(adId, userId);
				return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForResellerAndSeller(Integer reId, Integer seId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForResellerAndSeller(reId, seId);
				return userIdList;
	}
	
	public List<ChildUserIdQueryDto> getChildUserIdsForResellerAndClient(Integer reId, Integer userId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForResellerAndClient(reId, userId);
				return userIdList;
	}

	public List<ChildUserIdQueryDto> getChildUserIdsForSellerAndClient(Integer seId, Integer userId){
		List<ChildUserIdQueryDto> userIdList = userRepository.getChildUserIdsForSellerAndClient(seId,userId);
		return userIdList;
	}

	public Map<String, Map<String, Integer>> getAllChildsForUser(int id){
		
		logger.info("user id going to find all its child user");
		//NgUser parentUser = getUserByName(userName);
		//logger.info("parentUser  {}", parentUser.getId());
//		List<NgUser> childUserList  = userRepository.findByParentId(parentUser.getId());
		//List<NgUser> childUserList  = userRepository.findByParentIdOrderByUserNameAsc(id);
		// start
		//getRoleBasedData
		List<UserOptimizeDto> childUserList = translator.getRoleBasedData(String.valueOf(id));
		
	
		
		
		
		
		
		
		
		// end
		//logger.info("childuserList  {}", childUserList);
		Map<String, Map<String, Integer>> combinedChildMap = new HashMap<String, Map<String,Integer>>();
		Map<String, Integer> adminChildMap = new HashMap<String, Integer>();
		Map<String, Integer> resellerChildMap = new HashMap<String, Integer>();
		Map<String, Integer> sellerChildMap = new HashMap<String, Integer>();
		Map<String, Integer> clientChildMap = new HashMap<String, Integer>();
		for (UserOptimizeDto ngUser : childUserList) {
		if(ngUser.getUserrole().equalsIgnoreCase("admin")){
				adminChildMap.put(ngUser.getUserName(), Integer.valueOf(ngUser.getId()));
	    }else if(ngUser.getUserrole().equalsIgnoreCase("reseller")){
			resellerChildMap.put(ngUser.getUserName(), Integer.valueOf(ngUser.getId()));
		}else if(ngUser.getUserrole().equalsIgnoreCase("seller")){
			sellerChildMap.put(ngUser.getUserName(), Integer.valueOf(ngUser.getId()));
		}else if(ngUser.getUserrole().equalsIgnoreCase("client")){
			clientChildMap.put(ngUser.getUserName(), Integer.valueOf(ngUser.getId()));
		}
		}
		 Map<String, Integer> sortedadminChildMap = new TreeMap<String, Integer>(adminChildMap);
		 Map<String, Integer> sortedresellerChildMap = new TreeMap<String, Integer>(resellerChildMap);
		 Map<String, Integer> sortedsellerChildMap = new TreeMap<String, Integer>(sellerChildMap);
		 Map<String, Integer> sortedclientChildMap= new TreeMap<String, Integer>(clientChildMap);
//		combinedChildMap.put("ADMIN", adminChildMap);
//		combinedChildMap.put("RESELLER", resellerChildMap);
//		combinedChildMap.put("SELLER", sellerChildMap);
//		combinedChildMap.put("CLIENT", clientChildMap);
			combinedChildMap.put("ADMIN", sortedadminChildMap);
			combinedChildMap.put("RESELLER", sortedresellerChildMap);
			combinedChildMap.put("SELLER", sortedsellerChildMap);
			combinedChildMap.put("CLIENT", sortedclientChildMap);
	
			//logger.info("MOHIT OPERATION SUCESSFULL");
		return combinedChildMap;
	}

	public void changeUserPassword(NgUser ngUser, String newPassword) {
//		ngUser.setEncrypted_password(passwordEncoder.encode(newPassword));
		ngUser.setPassword(newPassword);
		userRepository.save(ngUser);
	}
	

	public boolean loadTemplateForSenderIdAndUserId(String userId, String senderId) {
		NgUser ngUser = getUserById(Integer.parseInt(userId));
		String contentTemplateMapKey = ngUser.getId()+"#"+senderId;
		redisTemplateForContentTemplateList.opsForHash().delete(userSenderIdTemplateMapKey, contentTemplateMapKey);
		List<NgContentTemplate> ngContentTemplateList = ngContentTemplateRepository.findByNgUserAndSenderIdAndStatus(ngUser,  senderId, '1');
		
		if(ngContentTemplateList != null && ngContentTemplateList.size() > 0) {
			Set<String> contentTemplateListForSenderId = new HashSet<>();	
			logger.info("List size is {} : ",ngContentTemplateList.size());
			contentTemplateListForSenderId = ngContentTemplateList.parallelStream().map(
					ngContentTemplate -> new String(ngContentTemplate.getTemplateText()+"!!~~!!"+ngContentTemplate.getDltTemplateId()+"!!~~!!"+ngContentTemplate.getNgServiceType().getDisplayCode())).collect(Collectors.toSet());
			logger.info("Sample data from template set {} : ", contentTemplateListForSenderId.iterator().next());
			redisTemplateForContentTemplateList.opsForHash().put(userSenderIdTemplateMapKey, contentTemplateMapKey, contentTemplateListForSenderId);
			
			/*for (NgContentTemplate ngContentTemplate : ngContentTemplateList) {
				String contentTemplateMapValue = ngContentTemplate.getTemplateText()+"!!~~!!"+ngContentTemplate.getDltTemplateId()+"!!~~!!"+ngContentTemplate.getNgServiceType().getDisplayCode();
				contentTemplateListForSenderId.add(contentTemplateMapValue);
				redisTemplateForContentTemplateList.opsForHash().put(userSenderIdTemplateMapKey, contentTemplateMapKey, contentTemplateListForSenderId);
			}*/
		}
		return true;
	
	}
	
	public boolean loadTemplate(String userId, String senderId) {
		NgUser ngUser = getUserById(Integer.parseInt(userId));
		String contentTemplateMapKey = ngUser.getId()+"#"+senderId;
		redisTemplateForContentTemplateList.opsForHash().delete(userSenderIdTemplateMapKey, contentTemplateMapKey);
		List<NgContentTemplate> ngContentTemplateList = ngContentTemplateRepository.findByNgUserAndSenderIdAndStatus(ngUser,  senderId, '1');
		
		if(ngContentTemplateList != null && ngContentTemplateList.size() > 0) {
			Set<String> contentTemplateListForSenderId = new HashSet<>();	
			logger.info("List size is {} : ",ngContentTemplateList.size());
			contentTemplateListForSenderId = ngContentTemplateList.parallelStream().map(
					ngContentTemplate -> new String(ngContentTemplate.getTemplateText()+"!!~~!!"+ngContentTemplate.getDltTemplateId()+"!!~~!!"+ngContentTemplate.getNgServiceType().getDisplayCode())).collect(Collectors.toSet());
			logger.info("Sample data from template set {} : ", contentTemplateListForSenderId.iterator().next());
			redisTemplateForContentTemplateList.opsForHash().put(userSenderIdTemplateMapKey, contentTemplateMapKey, contentTemplateListForSenderId);
			
			/*for (NgContentTemplate ngContentTemplate : ngContentTemplateList) {
				String contentTemplateMapValue = ngContentTemplate.getTemplateText()+"!!~~!!"+ngContentTemplate.getDltTemplateId()+"!!~~!!"+ngContentTemplate.getNgServiceType().getDisplayCode();
				contentTemplateListForSenderId.add(contentTemplateMapValue);
				redisTemplateForContentTemplateList.opsForHash().put(userSenderIdTemplateMapKey, contentTemplateMapKey, contentTemplateListForSenderId);
			}*/
		}
		return true;
	
	}

	public boolean loadTemplateForUser(String userId, String senderId, String template, String dltId,
			String serviceType) {
		String contentTemplateMapKey = userId+"#"+senderId;
		Object obj = redisTemplateForContentTemplateList.opsForHash().get(userSenderIdTemplateMapKey, contentTemplateMapKey);
		Set<String> contentTemplateListForSenderId = null;
		if(obj != null) {
			contentTemplateListForSenderId = (Set<String>) obj;
		}else {
			contentTemplateListForSenderId = new HashSet<>();
		}
		
		String contentTemplateMapValue = template+"!!~~!!"+dltId+"!!~~!!"+serviceType;
		contentTemplateListForSenderId.add(contentTemplateMapValue);
		redisTemplateForContentTemplateList.opsForHash().put(userSenderIdTemplateMapKey, contentTemplateMapKey, contentTemplateListForSenderId);
		
		return true;
	}
	
	public Page<NgUser> getAllUsersByParentIdWithLimit(int id, NgUserRole id2, int pageNumber) {
		Pageable pageable = new PageRequest(pageNumber, 10);
//		value 6 is used for internal user 
		logger.info("id ",id2);
		Page<NgUser> childUserList  = userRepository.findByParentIdAndNgUserRoleNotIn(id, id2 , pageable);
		logger.info("ListUser {}", childUserList);
		return childUserList;
	}

	public Page<NgUser> getUsersByParentIdWithLimit(int id, NgUserRole role, NgUser userName, int pageNumber) {
		Pageable pageable = new PageRequest(pageNumber, 10);
		logger.info("id ",role);
		Page<NgUser> childUserList  = userRepository.findByParentIdAndNgUserRoleAndUserNameNotIn(id, role , userName,pageable);
		logger.info("ListUser {}", childUserList);
		return childUserList;
	}
	
	// new method for jdbc template

	

}
