package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgTemplateMessageInfo;
import com.noesis.domain.persistence.NgUser;

public interface NgTemplateMessageInfoRepository extends CrudRepository<NgTemplateMessageInfo, Serializable> {
	public NgTemplateMessageInfo findById(int id);
	
	//public NgTemplateMessageInfo findByTemplateName(String templateName);

	//public NgTemplateMessageInfo findByNgUserAndTemplateName(NgUser ngUser, String templateName);
	
	public List<NgTemplateMessageInfo> findByNgUser(NgUser user);

	public NgTemplateMessageInfo findByNgUserAndServerFileName(NgUser ngUser, String serverFileName);
}
