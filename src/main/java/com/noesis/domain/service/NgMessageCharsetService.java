package com.noesis.domain.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgMessageCharset;
import com.noesis.domain.repository.NgMessageCharsetRepository;


@Service
public class NgMessageCharsetService {
	 private final Logger logger = LoggerFactory.getLogger(getClass());
	 
	private final NgMessageCharsetRepository ngMessageCharsetRepository;

		@Autowired
		public NgMessageCharsetService(NgMessageCharsetRepository ngMessageCharsetRepository ) {
			this.ngMessageCharsetRepository = ngMessageCharsetRepository;
		}
	public NgMessageCharset getNgMessageCharsetByNameFromDb(String name) {
		logger.info("Getting user settings by id from DB {}.", name);
		NgMessageCharset ngMessageCharset = ngMessageCharsetRepository.findByCharsetName(name);
		logger.info("User settings found in DB {}" ,ngMessageCharset);
 
		return ngMessageCharset;
	}

}
 