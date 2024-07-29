package com.noesis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgAccountType;
import com.noesis.domain.persistence.NgBillingType;
import com.noesis.domain.persistence.NgCustomerType;
import com.noesis.domain.persistence.NgDlrMediumType;
import com.noesis.domain.persistence.NgMessageType;
import com.noesis.domain.persistence.NgPriority;
import com.noesis.domain.persistence.NgUserRole;
import com.noesis.domain.repository.NgAccountTypeRepository;
import com.noesis.domain.repository.BillingTypeRepository;
import com.noesis.domain.repository.NgCustomerTypeRepository;
import com.noesis.domain.repository.NgMessageTypeRepository;
import com.noesis.domain.repository.NgPriorityRepository;
import com.noesis.domain.repository.NgUserRoleRepository;

@Service
public class MasterDataService {

	@Autowired
	private NgCustomerTypeRepository customerTypeRepository;
	
	@Autowired
	private NgMessageTypeRepository messageTypeRepository;
	
	@Autowired
	private NgAccountTypeRepository accountTypeRepository;
	
	@Autowired
	private BillingTypeRepository billingTypeRepository;
	
	@Autowired
	private NgPriorityRepository priorityRepository;
	
	@Autowired
	private NgUserRoleRepository userRoleRepository;
	
	@Autowired
	private NgDlrMediumTypeRepository dlrMediumTypeRepository;
	
	public NgCustomerType getCustomerTypeByType(String customerType) {
		NgCustomerType custType = customerTypeRepository.findByDisplayName(customerType);
		return custType;
	}
	
	public NgCustomerType getCustomerTypeByCode(String customerType) {
		NgCustomerType custType = customerTypeRepository.findByCustType(customerType);
		return custType;
	}
	

	
	public NgBillingType getBillingTypeByDisplayName(String type) {
		NgBillingType billingType = billingTypeRepository.findByDisplayName(type);
		return billingType;
	}
	
	public NgUserRole getUserRoleByType(String userRole) {
		NgUserRole ngUserRole = userRoleRepository.findByUserRole(userRole);
		return ngUserRole;
	}
	
	public NgAccountType getCodeByAccountName(String code) {
		NgAccountType accountType = accountTypeRepository.findByDisplayName(code);
		return accountType;
	}
	
	public NgAccountType getCodeByAccountCode(String code) {
		NgAccountType accountType = accountTypeRepository.findByCode(code);
		return accountType;
	}
		
	public NgMessageType getCodeByMessageType(String code) {
		NgMessageType messageCode = messageTypeRepository.findByDisplayName(code);
		return messageCode;
	}
	
	public NgMessageType getCodeByMessageTypeCode(String code) {
		NgMessageType messageCode = messageTypeRepository.findByCode(code);
		return messageCode;
	}
	
	public NgPriority getCodeByPriorityType(String code) {
		NgPriority priorityCode = priorityRepository.findByDisplayName(code);
		return priorityCode;
	}

	public NgPriority getCodeByPriorityCode(String code) {
		NgPriority priorityCode = priorityRepository.findByCode(code);
		return priorityCode;
	}
	
	public NgDlrMediumType getCodeByDlrType(String code) {
		NgDlrMediumType dlrType = dlrMediumTypeRepository.findByDisplayName(code);
		return dlrType;
	}
	
	public NgDlrMediumType getCodeByDlrCode(String code) {
		NgDlrMediumType dlrType = dlrMediumTypeRepository.findByCode(code);
		return dlrType;
	}
	
	public NgBillingType getBillingTypeByType(String type) {
		NgBillingType billingType = billingTypeRepository.findByType(type);
		return billingType;
	}
	
	public NgAccountType getCodeByType(String code) {
		NgAccountType accountType = accountTypeRepository.findByCode(code);
		return accountType;
	}
}
