package com.noesis.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgContentTemplate;
import com.noesis.domain.persistence.NgServiceSubType;
import com.noesis.domain.persistence.NgServiceType;
import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.repository.NgContentTemplateRepository;

@Service
public class NgContentTemplateService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NgContentTemplateRepository ngContentTemplateRepository;
	
	@Autowired
	StaticDataService staticDataService;
	
	public NgContentTemplate findByTemplateId(int id) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findById(id);
		return ngContentTemplate;
	}
	
	public Iterable<NgContentTemplate> getAllTemplateList() {
		Iterable<NgContentTemplate> tempList = ngContentTemplateRepository.findAll();
		return tempList;
	}
	
	public List<NgContentTemplate> getAllTemplateForUser(NgUser user) {
		List<NgContentTemplate> templateList = ngContentTemplateRepository.findByNgUser(user);
		return templateList;
	}
	
	public NgContentTemplate getTemplateByNameForUser(NgUser user, String templateName) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findByNgUserAndTemplateName(user, templateName);
		return ngContentTemplate;
	}
	
	public NgContentTemplate getTemplateBySenderIdForUser(NgUser user, String senderId) {
		List<NgContentTemplate> ngContentTemplateList = ngContentTemplateRepository.findByNgUserAndSenderId(user, senderId);
		return ngContentTemplateList.get(0);
	}
	
	public NgContentTemplate saveContentTemplate(NgContentTemplate contentTemplate) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.save(contentTemplate);
		//staticDataService.loadAllUserSenderIdTemplateData();
		return ngContentTemplate;
	}

	public NgContentTemplate removeTemplateByDltTemplateId(String dltTemplateId) {
		NgContentTemplate tempList = ngContentTemplateRepository.findByDltTemplateId(dltTemplateId);
		ngContentTemplateRepository.delete(tempList);
		//staticDataService.loadAllUserSenderIdTemplateData();
		return tempList;
	}
	
	public NgContentTemplate getTemplateByDltTemplateId(String dltTemplateId) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findByDltTemplateId(dltTemplateId);
		return ngContentTemplate;
	}

	public NgContentTemplate getTemplateByTemplateName(String templateTitle) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findByTemplateName(templateTitle);
		return ngContentTemplate;
		
	}

	public NgContentTemplate getTemplateByTemplateNameAndDltTemplateId(String templateTitle,
			String operatorTemplateId) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findByDltTemplateIdAndTemplateName(operatorTemplateId, templateTitle);
		return ngContentTemplate;
	}

	public Iterable<NgContentTemplate> getAllTemplateForUserAndMsgTypeAndSubTypeAndSenderId(NgUser ngUser,
			NgServiceType ngServiceType, NgServiceSubType ngServiceSubType, String senderId) {
		List<NgContentTemplate> templateList = ngContentTemplateRepository.findByNgUserAndNgServiceTypeAndNgServiceSubTypeAndSenderId(ngUser, ngServiceType, ngServiceSubType, senderId);
		return templateList;
	}

	public Iterable<NgContentTemplate> saveContentTemplates(List<NgContentTemplate> contentTemplateList) {
		Iterable<NgContentTemplate> ngContentTemplateList = ngContentTemplateRepository.save(contentTemplateList);
		//staticDataService.loadAllUserSenderIdTemplateData();
		return ngContentTemplateList;
	}
//	check template title with username
	public NgContentTemplate getTemplateByNgUserAndTemplateName(NgUser ngUser,String templateTitle) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findByNgUserAndTemplateName(ngUser,templateTitle);
		return ngContentTemplate;
	}
// Get id 
	public int getTemplateByTemplateNameAndId(String templateTitle,
			String operatorTemplateId) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findByDltTemplateIdAndTemplateName(operatorTemplateId, templateTitle);
		return ngContentTemplate.getId();
	}
	
	public List<NgContentTemplate> getTemplateByTemplateNameAndSenderIdAndUser(String templateName, String senderId, NgUser ngUser){
		List<NgContentTemplate> ngContentTemplate = ngContentTemplateRepository.findByNgUserAndTemplateNameAndSenderId(ngUser, templateName, senderId);
		return ngContentTemplate;
	}
	
//	Removed by id 
	public NgContentTemplate removeTemplateById(int id) {
		logger.info(" Temp id "+id);
		NgContentTemplate tempList = ngContentTemplateRepository.findById(id);
		ngContentTemplateRepository.delete(tempList);
		//staticDataService.loadAllUserSenderIdTemplateData();
		return tempList;
	}
//	Find user by id 
	public NgContentTemplate getTemplateById(int id) {
		NgContentTemplate ngContentTemplate = ngContentTemplateRepository.findById(id);
		return ngContentTemplate;
	}
}
