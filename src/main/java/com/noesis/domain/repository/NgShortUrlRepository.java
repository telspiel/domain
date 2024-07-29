package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgShortUrl;
import com.noesis.domain.persistence.NgUser;

public interface NgShortUrlRepository extends CrudRepository<NgShortUrl, Serializable> {

	//public List<NgShortUrl> findByNgUser(NgUser user);

	public List<NgShortUrl> findByUserIdAndIsActive(int userId, char isActive);

	public NgShortUrl findByUserIdAndUniqueKey(int userId, String uniqueKey);

	public NgShortUrl findById(int id);

	public NgShortUrl findByName(String name);
	
	public NgShortUrl findByNameAndUserId(String name, int userId);

	public List<NgShortUrl> findByNameAndUserId(List<String> name, Integer userId);
}
