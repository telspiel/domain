package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDynamicMessageInfo;
import com.noesis.domain.persistence.NgUser;

public interface NgDynamicMessageInfoRepository extends CrudRepository<NgDynamicMessageInfo, Serializable> {
	public NgDynamicMessageInfo findById(int id);
	
	//public NgTemplateMessageInfo findByTemplateName(String templateName);

	//public NgTemplateMessageInfo findByNgUserAndTemplateName(NgUser ngUser, String templateName);
	
	public List<NgDynamicMessageInfo> findByNgUser(NgUser user);

	public NgDynamicMessageInfo findByNgUserAndServerFileName(NgUser ngUser, String serverFileName);
}
