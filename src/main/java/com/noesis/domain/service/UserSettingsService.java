package com.noesis.domain.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserSettings;
import com.noesis.domain.repository.UserSettingRepository;

@Service
public class UserSettingsService {

	//private static final Logger logger = LogManager.getLogger(UserService.class);
    private final Logger logger = LoggerFactory.getLogger(getClass());
	private final UserSettingRepository userSettingRepository;

	@Autowired
	public UserSettingsService(UserSettingRepository userSettingRepository) {
		this.userSettingRepository = userSettingRepository;
	}

	@Cacheable(value = "userSettingsCacheById", key = "#userId")
	public NgUserSettings getUserSettingByUserId(int userId) {
		logger.info("Getting user settings by user id from service {}.", userId);
		NgUserSettings ngUserSettings = userSettingRepository.findByUserId(userId);
		logger.info("User settings found in DB {}" ,ngUserSettings);
		return ngUserSettings;
	}

	
	public NgUserSettings getUserSettingsByUserIdFromDb(int userId) {
		logger.info("Getting user settings by id from DB {}.", userId);
		NgUserSettings ngUserSettings = userSettingRepository.findByUserId(userId);
		logger.info("User settings found in DB {}" ,ngUserSettings);
		return ngUserSettings;
	}

	@CachePut(value = "userCacheById", key = "#userId")
	public NgUserSettings updateUserSettingsById(int userId) {
		NgUserSettings userSettings = getUserSettingByUserId(userId);
		//userSettings.setters
		userSettingRepository.save(userSettings);
		return userSettings;
	}
	
	
	@Cacheable(value = "all-users-settings")
	public ArrayList<NgUserSettings> loadAllUsersSettings() {
		logger.info("Loading all users settings by userid");
		ArrayList<NgUserSettings> usersSettingsList = new ArrayList<NgUserSettings>();
		userSettingRepository.findAll().forEach(usersSettingsList::add);;
		logger.info("Total users found : " + usersSettingsList.size());
		return usersSettingsList;
	}
	
	public NgUserSettings saveUserSettings(NgUserSettings ngUserSettings) {
		logger.info(" user settings Info {}.", ngUserSettings.getNgMessageCharset());
	NgUserSettings userSettings = userSettingRepository.save(ngUserSettings);
		return userSettings;
	}
	
	public NgUserSettings findUserID(int userId) {
		NgUserSettings ngUserSettings = userSettingRepository.findByUserId(userId);
		logger.info("Getting user settings by User ID from DB {}.", ngUserSettings);
		return ngUserSettings;
	}
	
	
	public NgUserSettings deleteUserSettings(int userId) {
		NgUserSettings ngUserSettings = userSettingRepository.findByUserId(userId);
		logger.info("Getting user settings by User ID Delete from DB {}.", userId);
		userSettingRepository.delete(ngUserSettings);
		return ngUserSettings;
	}
	
}
