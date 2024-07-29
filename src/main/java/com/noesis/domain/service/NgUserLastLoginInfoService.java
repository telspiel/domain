package com.noesis.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgUserLastLoginInfo;
import com.noesis.domain.repository.NgUserLastLoginInfoRepository;

@Service
public class NgUserLastLoginInfoService {

	@Autowired
	NgUserLastLoginInfoRepository userLastLoginInfoRepository;

	public NgUserLastLoginInfo getUserLastLoginDetails(int userId, String appName) {
		NgUserLastLoginInfo userLastLoginInfo = userLastLoginInfoRepository.findByUserIdAndAppName(userId, appName);
		return userLastLoginInfo;
	}

	public NgUserLastLoginInfo updateUserLoginDetails(NgUserLastLoginInfo userLastLoginInfo) {
		userLastLoginInfo = userLastLoginInfoRepository.save(userLastLoginInfo);
		return userLastLoginInfo;
	}
	public List<NgUserLastLoginInfo> getLastLoginInfos (int userId){
		List<NgUserLastLoginInfo> finfByUserIdList = userLastLoginInfoRepository.findByUserId(userId);
		return finfByUserIdList;
	}
	
}
