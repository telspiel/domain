package com.noesis.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserCreditHistory;
import com.noesis.domain.persistence.NgUserCreditMap;
import com.noesis.domain.repository.UserCreditHistoryRepository;
import com.noesis.domain.repository.UserCreditMapRepository;


@Service
@EnableTransactionManagement
public class UserCreditMapService {

	// private static final Logger logger =
	// LogManager.getLogger(UserCreditMapService.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final UserCreditMapRepository userCreditMapRepository;

	@Autowired
	private UserService userService;
	
	


	@Autowired
	private UserCreditHistoryRepository userCreditHistoryRepository;

	@Autowired
	public UserCreditMapService(UserCreditMapRepository userCreditMapRepository) {
		this.userCreditMapRepository = userCreditMapRepository;
	}

	private final String creditMapKey = "map:user:credit";
	
	@Autowired
	private RedisTemplate<String, String> newRedisTemplateForCreditMap;
	private java.util.Date Date;

	/*
	 * @Cacheable(value = "userCreditMap", key="#ngUser.userId") public
	 * NgUserCreditMap getUserCreditByUserId(int id) {
	 * logger.info("Getting user by ID {} from service.", id); NgUserCreditMap
	 * userCreditMap = userCreditMapRepository.findByUserId(id);
	 * logger.info("Available Credit For User Is : " + userCreditMap.getUserId()
	 * +"Available Credit is"+ userCreditMap.getAvailableCredit()); return
	 * userCreditMap; }
	 */

	@Cacheable(value = "userCreditMap", key = "#userName")
	public Integer getUserCreditByUserName(String userName) {
		logger.info("Getting user by ID {} from service.", userName);
		NgUser user = userService.getUserByName(userName);
		logger.info("USer found by name: " + user);
		if (user != null && user.getNgBillingType().getId() == 1) {
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			logger.info("Available Credit For User Is : " + userCreditMap.getNgUser().getUserName()
					+ "Available Credit is" + userCreditMap.getAvailableCredit());
			return userCreditMap.getAvailableCredit();
		}
		return 0;
	}

	/*
	 * @CachePut(value = "userCreditMap", key="#userName") public Integer
	 * updateUserCreditByUserName(String userName, int countToBeDeducted) {
	 * logger.info("Getting user by ID {} from service.", userName); NgUser user =
	 * userService.getUserByName(userName);
	 * logger.info("USer found by name: "+user); if(user!=null) { NgUserCreditMap
	 * userCreditMap = userCreditMapRepository.findByNgUser(user);
	 * logger.info("Available Credit For User Is : " +
	 * userCreditMap.getNgUser().getUserName() +"Available Credit is"+
	 * userCreditMap.getAvailableCredit()); if(userCreditMap.getAvailableCredit()>0)
	 * { userCreditMap.setAvailableCredit(userCreditMap.getAvailableCredit()-
	 * countToBeDeducted); } //userCreditMapRepository.save(userCreditMap); return
	 * userCreditMap.getAvailableCredit(); } return 0; }
	 */

	public Integer updateUserCacheCreditByUserNameInCache(String userName, Integer countToBeDeducted) {
		NgUser user = userService.getUserByName(userName);
		String userCreditAsString = (String)newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",user.getUserName());
		Integer userCredit = null;
		if(userCreditAsString != null) {
			userCredit = Integer.parseInt(userCreditAsString);
		}
		
		if (userCredit != null && userCredit > 0) {
			// Getting and putting deducted value in redis in two steps.
			/* userCredit = userCredit - countToBeDeducted;
			newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());*/
			long updatedCredit = newRedisTemplateForCreditMap.opsForHash().increment("map:user:credit", user.getUserName(), countToBeDeducted);
			logger.info("Before deduction, user {} credit is {} and after deduction is in redis {}. ", user.getUserName(), userCredit, updatedCredit);
			return userCredit;
		} else if (userCredit != null && userCredit <= 0) {
			return userCredit;
		} else if (userCredit == null) {
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			// logger.info("Getting user credit from database : " +
			// userCreditMap.getNgUser().getUserName() +"Available Credit is"+
			// userCreditMap.getAvailableCredit());
			if (userCreditMap != null) {
				if (userCreditMap.getAvailableCredit() > 0) {
					userCredit = userCreditMap.getAllocatedCredit() - countToBeDeducted;
					newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());
					// logger.info("Updating user credit from db in redis.");
					return userCredit;
				} else {
					userCredit = userCreditMap.getAllocatedCredit();
					newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());
					// logger.info("User credit is less than or equal to zero and udpating in
					// redis");
					return userCredit;
				}
			}
		}
		return 0;
	}

	public Integer getUserCreditByUserNameFromRedis(String userName) {
		NgUser user = userService.getUserByName(userName);
		// logger.info("USer found by name: "+user);
		if (user == null) {
			logger.error("{} user is null in redis while getting credit. Hence going to get user from DB.", userName);
			user = userService.getUserByNameFromDb(userName);
		}	
		
		if(user != null ) {
			Object userCreditAsObject = newRedisTemplateForCreditMap.opsForHash().get(creditMapKey,user.getUserName());
			Integer userCredit = null;
			String userCreditAsString = null;
			if(userCreditAsObject instanceof String){
				userCreditAsString = (String)userCreditAsObject;
			}else if(userCreditAsObject instanceof Integer){
				userCredit = (Integer)userCreditAsObject;
			}
			logger.error("1. user credit is : {} ", userCredit);
			if(userCreditAsString != null) {
				logger.error("2. user credit is : {} ", userCredit);
				userCredit = Integer.parseInt(userCreditAsString);
				logger.error("3. user credit is : {} ", userCredit);
			}
			logger.error("4. user credit is : {} ", userCredit);
			if (userCredit == null) {
				NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
				if (userCreditMap != null) {
					// logger.info("Getting user credit from database : " +
					// userCreditMap.getNgUser().getUserName() +"Available Credit is"+
					// userCreditMap.getAvailableCredit());
					userCredit = userCreditMap.getAvailableCredit();
					newRedisTemplateForCreditMap.opsForHash().put(creditMapKey, user.getUserName(), userCredit.toString());
					logger.info("Adding user credit for user {} first time in redis {} ", user.getUserName(),
							userCredit);
					return userCredit;
				} else {
					logger.error("{} user is found but credit info not found in redis and hence returning 0", userName);
					return 0;
				}
			}
			logger.info("Available Credit For User {} from redis Is {}: ", user.getUserName(), userCredit);
			return userCredit;
		}else {
			logger.error("{} user is null in DB too. and hence returning 0 credit.", userName);
		}
		return 0;
	}

	public Integer allocateAndAddUserCreditByUserNameInRedisAndDB(String userName, Integer countToBeAdded,
			String comments) {
		NgUser user = userService.getUserByName(userName);
		Integer userCredit = null;
		if(newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",user.getUserName()) != null){
			userCredit = Integer.parseInt((String)newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",user.getUserName()));
		}
		
		
		if (userCredit != null) {
			userCredit = userCredit + countToBeAdded;

			// Update user credit in redis hash map.
			logger.info("Adding user credit in redis {}.", userCredit);
			newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());
			logger.info("Adding user credit in redis.");

			// Update user credit in database.
			logger.info("Adding user credit in database {}.", userCredit);
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			userCreditMap.setAvailableCredit(userCredit);
			userCreditMap.setAllocatedCredit(userCreditMap.getAllocatedCredit() + countToBeAdded);
			userCreditMap.setComments(comments);
			userCreditMapRepository.save(userCreditMap);
			return userCredit;
		} else if (userCredit == null) {
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			if (userCreditMap != null) {
				userCredit = userCreditMap.getAvailableCredit() + countToBeAdded;

				// Updating user credit in redis hash map.
				logger.info("Adding user credit in redis {}.", userCredit);
				newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());

				// Updating user credit in database.
				logger.info("Adding user credit in redis {}.", userCredit);
				userCreditMap.setAvailableCredit(userCredit);
				userCreditMap.setAllocatedCredit(userCreditMap.getAllocatedCredit() + countToBeAdded);
				userCreditMap.setComments(comments);
				userCreditMapRepository.save(userCreditMap);
				return userCredit;
			} else {
				logger.info("User Credit not found either in redis or database.");
			}
		}
		return 0;
	}

	public Integer addUserCreditByUserNameInRedisAndDB(String userName, Integer countToBeAdded, String comment) {
		NgUser user = userService.getUserByName(userName);
		String userCreditAsString = (String)newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",user.getUserName());
		Integer userCredit = null;
		if(userCreditAsString != null) {
			userCredit = Integer.parseInt(userCreditAsString);
		}
		if (userCredit != null) {
			userCredit = userCredit + countToBeAdded;
			// Update user credit in redis hash map.
			logger.info("Adding user credit in redis {}.", userCredit);
			newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());
			logger.info("Adding user credit in redis.");

			// Update user credit in database.
			logger.info("Adding user credit in database {}.", userCredit);
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			userCreditMap.setAvailableCredit(userCredit);
			userCreditMap.setAllocatedCredit(userCreditMap.getAllocatedCredit());
			userCreditMap.setComments(comment);
			userCreditMapRepository.save(userCreditMap);
			return userCredit;
		} else if (userCredit == null) {
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			if (userCreditMap != null) {
				userCredit = userCreditMap.getAvailableCredit() + countToBeAdded;
				// Updating user credit in redis hash map.
				logger.info("Adding user credit in redis {}.", userCredit);
				newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());
				// Updating user credit in database.
				logger.info("Adding user credit in redis {}.", userCredit);
				userCreditMap.setAvailableCredit(userCredit);
				userCreditMap.setAllocatedCredit(userCreditMap.getAllocatedCredit());
				userCreditMap.setComments(comment);
				userCreditMapRepository.save(userCreditMap);
				return userCredit;
			} else {
				logger.info("User Credit not found either in redis or database. Adding credit for first time.");
				NgUserCreditMap newUserCreditMap = new NgUserCreditMap();
				NgUser ngCustomer = userService.getUserByName(userName);
				// Updating user credit in database.
				logger.info("Adding user credit in DB for user {}.", userName);
				newUserCreditMap.setAvailableCredit(countToBeAdded);
				newUserCreditMap.setAllocatedCredit(countToBeAdded);
				newUserCreditMap.setComments("Credit added first time. " + comment);
				newUserCreditMap.setNgUser(ngCustomer);
				newUserCreditMap.setBlockedCredit(0);
				userCreditMapRepository.save(newUserCreditMap);
				// Updating user credit in redis hash map.
				logger.info("Adding user credit in redis {}.", userCredit);
				newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), countToBeAdded.toString());
				return userCredit;
			}
		}
		return 0;
	}

	public Integer deductUserCreditByUserNameInRedisAndDB(String userName, Integer countToBeDeducted, String comment) {
		NgUser user = userService.getUserByNameFromDb(userName);
		String userCreditAsString = (String)newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",user.getUserName());
		Integer userCredit = null;
		if(userCreditAsString != null) {
			userCredit = Integer.parseInt(userCreditAsString);
		}
		if (userCredit != null) {
			if (userCredit > countToBeDeducted) {
				userCredit = userCredit - countToBeDeducted;
				// Update user credit in redis hash map.
				logger.info("Adding user credit in redis {}.", userCredit);
				newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());
				logger.info("Adding user credit in redis.");
				// Update user credit in database.
				logger.info("Adding user credit in database {}.", userCredit);
				NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
				userCreditMap.setAvailableCredit(userCredit);
				userCreditMap.setAllocatedCredit(userCreditMap.getAllocatedCredit());
				userCreditMapRepository.save(userCreditMap);
				userCreditMap.setComments(comment);
				return userCredit;
			} else {
				return null;
			}
		} else if (userCredit == null) {
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			if (userCreditMap != null) {
				if (userCreditMap.getAvailableCredit() > countToBeDeducted) {
					userCredit = userCreditMap.getAvailableCredit() - countToBeDeducted;
					// Updating user credit in redis hash map.
					logger.info("Adding user credit in redis {}.", userCredit);
					newRedisTemplateForCreditMap.opsForHash().put("map:user:credit", user.getUserName(), userCredit.toString());

					// Updating user credit in database.
					logger.info("Adding user credit in redis {}.", userCredit);
					userCreditMap.setAvailableCredit(userCredit);
					userCreditMap.setAllocatedCredit(userCreditMap.getAllocatedCredit());
					userCreditMap.setComments(comment);
					userCreditMapRepository.save(userCreditMap);
					return userCredit;
				} else {
					return null;
				}
			} else {
				logger.info("User Credit not found either in redis or database.");
			}
		}
		return 0;
	}

	// @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor =
	// Exception.class)
	public Integer addAndDeductCreditForParentAndChild(String parentName, String childName, Integer credit) {
		try {
			NgUser parentUser = userService.getUserByName(parentName);
			Integer parentUserCredit = Integer.parseInt((String)newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",
					parentUser.getUserName()));

			if (parentUserCredit > credit) {
				addUserCreditByUserNameInRedisAndDB(childName, credit, "Credit " + credit + " added by " + parentName);
				deductUserCreditByUserNameInRedisAndDB(parentName, credit,
						"Credit " + credit + " added to customer " + childName);

				createAndSaveCreditHistory(childName, credit, "Credit " + credit + " added by " + parentName,
						parentName, "Add");
				createAndSaveCreditHistory(parentName, credit, "Credit " + credit + " added to customer " + childName,
						"SYSTEM", "Deduct");

			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Error in addAndDeductCreditForParentAndChild.  {}", e.getMessage());
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	// @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor =
	// Exception.class)
	public Integer deductAndAddCreditForParentAndChild(String parentName, String childName, Integer credit) {
		try {
			NgUser childUser = userService.getUserByName(childName);
			Integer childUserCredit = Integer.parseInt((String)newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",
					childUser.getUserName()));

			if (childUserCredit > credit) {
				deductUserCreditByUserNameInRedisAndDB(childName, credit,
						"Credit " + credit + " deducted by " + parentName);
				addUserCreditByUserNameInRedisAndDB(parentName, credit,
						"Credit " + credit + " refunded from customer " + childName);

				createAndSaveCreditHistory(childName, credit, "Credit " + credit + " deducted by " + parentName,
						parentName, "Deduct");
				createAndSaveCreditHistory(parentName, credit,
						"Credit " + credit + " refunded from customer " + childName, "SYSTEM", "Add");
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Error in deductAndAddCreditForParentAndChild.  {}", e.getMessage());
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public void createAndSaveCreditHistory(String userName, Integer credit, String comment, String updatedBy,
			String status) {
		NgUser user = userService.getUserByName(userName);
		Integer userCredit = Integer.parseInt((String)newRedisTemplateForCreditMap.opsForHash().get("map:user:credit",
				user.getUserName()));

		NgUserCreditHistory creditHistory = new NgUserCreditHistory();
		creditHistory.setUserId(user.getId());
		creditHistory.setCreatedDate(new java.util.Date());
		creditHistory.setCredit(credit);
		creditHistory.setStatus(status);
		creditHistory.setUpdatedBy(updatedBy);
		creditHistory.setUpdatedCredit(userCredit);
		creditHistory.setNotes(comment);
		userCreditHistoryRepository.save(creditHistory);
	}

	// view credit history
	public List<NgUserCreditHistory> getAllcreditData(String customerUserName, String getFromDate, String getToDate)
			throws ParseException {
		List<NgUserCreditHistory> NgUserCreditHistoryList = null;
		NgUser user = userService.getUserByName(customerUserName);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		getFromDate = getFromDate + " 00:00:00";
		getToDate = getToDate + " 23:59:59";
		Date fromDate = sdf.parse(getFromDate);
		Date toDate = sdf.parse(getToDate);
		logger.info("Going to hit query with selecting userid : {}", user.getId());
		NgUserCreditHistoryList = userCreditHistoryRepository
				.findByUserIdAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(user.getId(), fromDate, toDate);
		return NgUserCreditHistoryList;
	}

	public boolean updateUserCreditFromCacheToDB() {
		Set<Object> keySet = newRedisTemplateForCreditMap.opsForHash().keys("map:user:credit");
		logger.info("Users found in credit map : {}", keySet.toString());
		for (Object object : keySet) {
			String userName = (String) object;
			NgUser user = userService.getUserByName(userName);
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			userCreditMap.setAvailableCredit(Integer.parseInt((String) newRedisTemplateForCreditMap.opsForHash().get("map:user:credit", user.getUserName())));
			userCreditMap.setComments("CREDIT_UPDATED_FROM_REDIS");
			userCreditMapRepository.save(userCreditMap);
			System.out.println("this will create issue******************************************************");
		}
		logger.info("Available Credit Updated In DB from Redis");
		return true;
	}

	public Integer getBlockedCreditForUserFromDB(String userName) {
		NgUser user = userService.getUserByName(userName);
		if (user != null && user.getNgBillingType().getId() == 1) {
			NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
			logger.info("Blocked Credit For User: " + userCreditMap.getNgUser().getUserName()
					+ " is " + userCreditMap.getBlockedCredit());
		Integer	userBlockedCredit = userCreditMap.getBlockedCredit();
			if(userBlockedCredit != null) {
			return userCreditMap.getBlockedCredit();
			}
		}
		return 0;
	}
	
	public boolean updateUserBlockedCredit(String userName, Integer blockedCredit, String comment) {
		NgUser user = userService.getUserByName(userName);
		NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
		userCreditMap.setBlockedCredit(blockedCredit);
		userCreditMap.setComments(comment);
		userCreditMapRepository.save(userCreditMap);
		return true;
	}
	
	public synchronized boolean updateUserBlockedCreditFromProcessor(String userName, Integer creditToBeReturned, String comment) {
		NgUser user = userService.getUserByName(userName);
		NgUserCreditMap userCreditMap = userCreditMapRepository.findByNgUser(user);
		logger.info("Creadit read from DB : {} and to be returned : {}",userCreditMap.getBlockedCredit(), creditToBeReturned);
		Integer updatedCredit = userCreditMap.getBlockedCredit()-creditToBeReturned;
		userCreditMap.setBlockedCredit(updatedCredit);
		userCreditMap.setComments(comment);
		NgUserCreditMap updatedUserCreditMap = userCreditMapRepository.save(userCreditMap);
		logger.info("Creadit read from DB after update: {} ",updatedUserCreditMap.getBlockedCredit());
		return true;
	}
}
