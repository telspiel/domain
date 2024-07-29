package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgPostCutoffMessage;

public interface PostCutoffMessageRepository extends CrudRepository<NgPostCutoffMessage, Serializable> {
	public NgPostCutoffMessage findAllByUserName(String userName);
}
