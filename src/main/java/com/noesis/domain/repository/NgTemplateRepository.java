package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgTemplate;
import com.noesis.domain.persistence.NgUser;

public interface NgTemplateRepository extends CrudRepository<NgTemplate, Serializable> {
	public NgTemplate findById(int id);
	
	public NgTemplate findByTemplateName(String templateName);

	public NgTemplate findByNgUserAndTemplateName(NgUser ngUser, String templateName);
	
	public List<NgTemplate> findByNgUser(NgUser user);
	
	
}
