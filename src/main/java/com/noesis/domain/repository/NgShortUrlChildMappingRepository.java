package com.noesis.domain.repository;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.noesis.domain.persistence.NgShortUrlChildMapping;

public interface NgShortUrlChildMappingRepository extends CrudRepository<NgShortUrlChildMapping, Serializable> {

	NgShortUrlChildMapping findById(int id);

}
