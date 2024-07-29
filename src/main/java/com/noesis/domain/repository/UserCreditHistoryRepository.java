package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgUser;
import com.noesis.domain.persistence.NgUserCreditHistory;

public interface UserCreditHistoryRepository extends CrudRepository<NgUserCreditHistory,Serializable> {
	public List<NgUserCreditHistory> findByUserIdAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Integer userid,Date fromDate, Date toDate);

}
