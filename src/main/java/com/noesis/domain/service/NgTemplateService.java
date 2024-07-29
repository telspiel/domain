package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgTemplate;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgTemplateRepository;

@Service
public class NgTemplateService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgTemplateRepository ngTemplateRepository;
	
	public NgTemplate findByTemplateId(int id) {
		NgTemplate ngTemplate = ngTemplateRepository.findById(id);
		return ngTemplate;
	}
	
	public Iterable<NgTemplate> getAllTemplateList() {
		Iterable<NgTemplate> tempList = ngTemplateRepository.findAll();
		return tempList;
	}
	
	public List<NgTemplate> getAllTemplateForUser(NgUser user) {
		List<NgTemplate> templateList = ngTemplateRepository.findByNgUser(user);
		return templateList;
	}
	
	public NgTemplate getTemplateByNameForUser(NgUser user, String templateName) {
		NgTemplate ngTemplate = ngTemplateRepository.findByNgUserAndTemplateName(user, templateName);
		return ngTemplate;
	}
	
	public NgTemplate saveTemplate(NgTemplate template) {
		NgTemplate ngTemplate = ngTemplateRepository.save(template);
		return ngTemplate;
	}

	public NgTemplate removeTemplateFromUserTemplateList(String templateName) {
		NgTemplate tempList = ngTemplateRepository.findByTemplateName(templateName);
		ngTemplateRepository.delete(tempList);
		return tempList;
	}
	
	public NgTemplate getTemplateById(Integer id) {
		NgTemplate ngTemplate = ngTemplateRepository.findById(id);
		return ngTemplate;
	}

}
