package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgContentTemplate;
import com.noesis.domain.persistence.NgServiceSubType;
import com.noesis.domain.persistence.NgServiceType;
import com.noesis.domain.persistence.NgUser;

public interface NgContentTemplateRepository extends CrudRepository<NgContentTemplate, Serializable> {
	
	public NgContentTemplate findById(int id);
	
	public NgContentTemplate findByDltTemplateId(String dltTemplateId);
	
	public NgContentTemplate findByTemplateName(String templateName);

	public NgContentTemplate findByNgUserAndTemplateName(NgUser ngUser, String templateName);
	
	@QueryHints(value = @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE, value = "1000"))
	public List<NgContentTemplate> findByNgUser(NgUser user);

	public NgContentTemplate findByDltTemplateIdAndTemplateName(String operatorTemplateId, String templateTitle);

	@QueryHints(value = @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE, value = "1000"))
	public List<NgContentTemplate> findByNgUserAndSenderId(NgUser user, String senderId);

	@QueryHints(value = @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE, value = "1000"))
	public List<NgContentTemplate> findByNgUserAndSenderIdAndStatus(NgUser user, String senderId, char Status);
	
	public Iterable<NgContentTemplate> findByStatusAndDltTemplateIdIsNotNull(char status);

	@QueryHints(value = @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE, value = "1000"))
	public Iterable<NgContentTemplate> findByStatus(char status);

	public List<NgContentTemplate> findByNgUserAndNgServiceTypeAndNgServiceSubTypeAndSenderId(NgUser ngUser,
			NgServiceType ngServiceType, NgServiceSubType ngServiceSubType, String senderId);

	public List<NgContentTemplate> findByNgUserAndTemplateNameAndSenderId(NgUser ngUser, String templateName,
			String senderId);
}
