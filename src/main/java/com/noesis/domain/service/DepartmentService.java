package com.noesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDepartment;
import com.noesis.domain.persistence.NgOrganisation;
import com.noesis.domain.repository.DepartmentRepository;
@Service
public class DepartmentService {
	
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Iterable<NgDepartment> getAllDepartmentList() {
		Iterable<NgDepartment> deptList = departmentRepository.findAll();
		return deptList;
	}

	public NgDepartment saveDepartment(NgDepartment department) {
		NgDepartment ngDepartment = departmentRepository.save(department);
		return ngDepartment;
		
	}

	public NgDepartment getDepartment(int deptId) {
		NgDepartment ngDepartment = departmentRepository.findById(deptId);
		return ngDepartment;
	}
	
	public Iterable<NgDepartment> getAllDepartmentListForOrganisation(NgOrganisation ngOrganisation) {
		Iterable<NgDepartment> deptList = departmentRepository.findByNgOrganisation(ngOrganisation);
		return deptList;
	}
}
