package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUserSettings;

public interface UserSettingRepository extends CrudRepository<NgUserSettings, Serializable> {
	
	public NgUserSettings findByUserId(int userId);
}
