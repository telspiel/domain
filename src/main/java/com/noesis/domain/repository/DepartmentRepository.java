package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDepartment;
import com.noesis.domain.persistence.NgOrganisation;

public interface DepartmentRepository extends CrudRepository<NgDepartment, Serializable> {
	NgDepartment findById(int id);

	Iterable<NgDepartment> findByNgOrganisation(NgOrganisation ngOrganisation);
}
