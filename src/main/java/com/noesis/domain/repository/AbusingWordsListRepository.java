package com.noesis.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgAbusingWordsList;

public interface AbusingWordsListRepository extends CrudRepository<NgAbusingWordsList, Serializable> {

	public NgAbusingWordsList findByAbusingWord(String abusingWord);

	public List<NgAbusingWordsList> findByAbusingWordCatagoryIn(List<String> categoryList);
}


