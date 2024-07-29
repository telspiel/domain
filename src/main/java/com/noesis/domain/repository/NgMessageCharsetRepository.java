package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgMessageCharset;
import com.noesis.domain.persistence.NgUserSettings;


public interface NgMessageCharsetRepository extends CrudRepository<NgMessageCharset, Serializable> {
	public NgMessageCharset findByCharsetName(String charsetname);
}
