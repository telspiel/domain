package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUserRole;

public interface NgUserRoleRepository extends CrudRepository<NgUserRole, Serializable>{
	NgUserRole findByUserRole(String userRole);
}

