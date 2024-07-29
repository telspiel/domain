package com.noesis.domain.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgKannelInfo;
import com.noesis.domain.persistence.NgOperatorErrorCodeMapping;
import com.noesis.domain.repository.KannelInfoRepository;
import com.noesis.domain.repository.NgOperatorErrorCodeMappingRepository;

@Service
public class NgOperatorErrorCodeMappingService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String operatorErrorCodeMap = "OPERATOR_ERROR_CODE_MAP";
	
	private static final String operatorErrorCodeAndDescMap = "OPERATOR_ERROR_CODE_AND_DESC_MAP";
	
	private static final String platformErrorCodeAndDescMap = "PLATFORM_ERROR_CODE_AND_DESC_MAP";
	
	@Autowired 
	private RedisTemplate<String, Set<String>> redisTemplateForOperatorErrorCodes;
	
	@Autowired 
	private RedisTemplate<String, HashMap<String, String>> redisTemplateForErrorCodesAndDesc;

	@Autowired 
	private RedisTemplate<String, String> redisTemplateForPlatformErrorCodesAndDesc;
	
	@Autowired
	NgOperatorErrorCodeMappingRepository ngOperatorErrorCodeMappingRepository;
	
	@Autowired
	KannelInfoRepository kannelInfoRepository;
	
	public boolean loadAllOperatorErrorCodes() {
		
		redisTemplateForOperatorErrorCodes.opsForHash().getOperations().delete(operatorErrorCodeMap);
		
		Iterable<NgKannelInfo> kannelInfoList = kannelInfoRepository.findAll();
		
		for (NgKannelInfo ngKannelInfo : kannelInfoList) {
			List<NgOperatorErrorCodeMapping> ngOperatorErrorCodeMappingList = ngOperatorErrorCodeMappingRepository.findByKannelIdAndIsRetryEnabled(ngKannelInfo.getId(), 'Y');
			
			Set<String> errorCodeSetForKannel = new HashSet<>();
			for (NgOperatorErrorCodeMapping ngOperatorErrorCodeMapping : ngOperatorErrorCodeMappingList) {
				errorCodeSetForKannel.add(ngOperatorErrorCodeMapping.getErrorCode());
			}
			redisTemplateForOperatorErrorCodes.opsForHash().put(operatorErrorCodeMap, ngKannelInfo.getId().toString(), errorCodeSetForKannel);
		}
		return true;
	}
	
	public Boolean isDlrErrorCodeRetryEnabled(String errorCode, String kannelId) {
		Set<String> operatorErrorCodeSet = (Set<String>)redisTemplateForOperatorErrorCodes.opsForHash().get(operatorErrorCodeMap, kannelId);
		if(operatorErrorCodeSet != null && operatorErrorCodeSet.size() > 0) {
			logger.debug("Dlr Error Code to be search in operator error codes : "+ errorCode);
			return operatorErrorCodeSet.contains(errorCode);
		}
		return false;
	}
	
	public boolean loadAllOperatorErrorCodesAndDescription() {
		
		redisTemplateForErrorCodesAndDesc.opsForHash().getOperations().delete(operatorErrorCodeAndDescMap);
		
		Iterable<NgKannelInfo> kannelInfoList = kannelInfoRepository.findAll();
		
		for (NgKannelInfo ngKannelInfo : kannelInfoList) {
			List<NgOperatorErrorCodeMapping> ngOperatorErrorCodeMappingList = ngOperatorErrorCodeMappingRepository.findByKannelId(ngKannelInfo.getId());
			
			HashMap<String, String> errorCodeAndDescMap = new HashMap<>();
			for (NgOperatorErrorCodeMapping ngOperatorErrorCodeMapping : ngOperatorErrorCodeMappingList) {
				errorCodeAndDescMap.put(ngOperatorErrorCodeMapping.getErrorCode(), ngOperatorErrorCodeMapping.getErrorDesc());
			}
			
			redisTemplateForErrorCodesAndDesc.opsForHash().put(operatorErrorCodeAndDescMap, ngKannelInfo.getId().toString(), errorCodeAndDescMap);
		}
		return true;
	}
	
	public String getErrorDescForKannelAndErrorCode(String errorCode, String kannelId) {
		HashMap<String, String> errorCodeAndDescMap = (HashMap<String, String>)redisTemplateForErrorCodesAndDesc.opsForHash().get(operatorErrorCodeAndDescMap, kannelId);
		logger.info("Going to fetch error code desc for error code {} and kannel id {}", errorCode, kannelId);
		if(errorCodeAndDescMap != null && errorCodeAndDescMap.size() > 0) {
			logger.info("Dlr Error Desc for error code {} and kannel id {} is {}", errorCode, kannelId, errorCodeAndDescMap.get(errorCode));
			return  errorCodeAndDescMap.get(errorCode);
		}
		return null;
	}
	
	public boolean loadAllPlatformErrorCodesAndDescription() {
		
		redisTemplateForPlatformErrorCodesAndDesc.opsForHash().getOperations().delete(platformErrorCodeAndDescMap);
		
		Iterable<NgOperatorErrorCodeMapping> ngOperatorErrorCodeMappingList = ngOperatorErrorCodeMappingRepository.findAll();
		
		for (NgOperatorErrorCodeMapping ngOperatorErrorCodeMapping : ngOperatorErrorCodeMappingList) {
			if(ngOperatorErrorCodeMapping.getPlatformErrorCode() != null || ngOperatorErrorCodeMapping.getPlatformErrorCode().length()>0){
				String platformErrorDesc = ngOperatorErrorCodeMapping.getPlatformErrorCodeDesc(); 
				if(platformErrorDesc ==null || platformErrorDesc.length() == 0){
					platformErrorDesc = "";
				}
				
				String platFormErrorCodeMapKey = ngOperatorErrorCodeMapping.getKannelId()+"!!~~!!"+ngOperatorErrorCodeMapping.getErrorCode();
				String platFormErrorCodeMapValue = ngOperatorErrorCodeMapping.getPlatformErrorCode()+"!!~~!!"+platformErrorDesc;
				redisTemplateForPlatformErrorCodesAndDesc.opsForHash().put(platformErrorCodeAndDescMap, platFormErrorCodeMapKey, platFormErrorCodeMapValue);
			}
		}
		return true;
	}

	public String getPlatFormErrorCodeAndDescForKannelAndErrorCode(String errorCode, String kannelId) {
		String platFormErrorCodeMapKey = kannelId+"!!~~!!"+errorCode;
		String platFormerrorCodeAndDesc = (String)redisTemplateForPlatformErrorCodesAndDesc.opsForHash().get(platformErrorCodeAndDescMap, platFormErrorCodeMapKey);
		logger.info("Platform error code and description for operator error code {} and kannel id {} is : {}", errorCode, kannelId, platFormerrorCodeAndDesc);
		if(platFormerrorCodeAndDesc != null) {
			return platFormerrorCodeAndDesc;
		}
	return null;
}
	public void deleteErrorCodeForKannelid(int kannelId) {
		List<NgOperatorErrorCodeMapping> ngOperatorErrorCodeMappingList = ngOperatorErrorCodeMappingRepository.findByKannelId(kannelId);
		if(ngOperatorErrorCodeMappingList != null && ngOperatorErrorCodeMappingList.size() > 0) {
		for (NgOperatorErrorCodeMapping errorCodeMappingList : ngOperatorErrorCodeMappingList) {
			ngOperatorErrorCodeMappingRepository.delete(errorCodeMappingList);
		}
		logger.info("Error code deleted from :- {} ", kannelId);
		}
	}
	public boolean getKannelAndErrorCode(String errorCode, int kannelId, String errorDesc, String isCarrierRetryEnabled, String isRetryEnabled,
			String platformErrorCode, String platformErrorDesc, int platformErrorCodeId) {
		List<NgOperatorErrorCodeMapping> ngOperatorErrorCodeMappingList = ngOperatorErrorCodeMappingRepository.findByKannelIdAndErrorCode(kannelId, errorCode);
		if(ngOperatorErrorCodeMappingList != null && ngOperatorErrorCodeMappingList.size() > 0) {
			for(NgOperatorErrorCodeMapping errorCodes: ngOperatorErrorCodeMappingList) {
			errorCodes.setErrorCode(errorCode);
			errorCodes.setErrorDesc(errorDesc);
			if(isCarrierRetryEnabled != null && isCarrierRetryEnabled.equalsIgnoreCase("yes")){
				errorCodes.setIsCarrierRetryEnabled('Y');	
			}else {
				errorCodes.setIsCarrierRetryEnabled('N');
			}
			if(isRetryEnabled != null && isRetryEnabled.equalsIgnoreCase("yes")){
				errorCodes.setIsRetryEnabled('Y');	
			}else {
				errorCodes.setIsRetryEnabled('N');
			}
			errorCodes.setKannelId(kannelId);
			errorCodes.setPlatformErrorCode(platformErrorCode);
			errorCodes.setPlatformErrorCodeDesc(platformErrorDesc);
			errorCodes.setPlatformErrorCodeId(platformErrorCodeId);
			ngOperatorErrorCodeMappingRepository.save(errorCodes);
			return false;
		}
		}
		NgOperatorErrorCodeMapping addNewErrorCodes = new NgOperatorErrorCodeMapping();
		addNewErrorCodes.setErrorCode(errorCode);
		addNewErrorCodes.setErrorDesc(errorDesc);
		if(isCarrierRetryEnabled != null && isCarrierRetryEnabled.equalsIgnoreCase("yes")){
			addNewErrorCodes.setIsCarrierRetryEnabled('Y');	
		}else {
			addNewErrorCodes.setIsCarrierRetryEnabled('N');
		}
		if(isRetryEnabled != null && isRetryEnabled.equalsIgnoreCase("yes")){
			addNewErrorCodes.setIsRetryEnabled('Y');	
		}else {
			addNewErrorCodes.setIsRetryEnabled('N');
		}
		addNewErrorCodes.setKannelId(kannelId);
		addNewErrorCodes.setPlatformErrorCode(platformErrorCode);
		addNewErrorCodes.setPlatformErrorCodeDesc(platformErrorDesc);
		addNewErrorCodes.setPlatformErrorCodeId(platformErrorCodeId);
		ngOperatorErrorCodeMappingRepository.save(addNewErrorCodes);
		return true;
}

}

