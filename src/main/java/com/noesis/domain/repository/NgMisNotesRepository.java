package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgMisNotes;

public interface NgMisNotesRepository extends CrudRepository<NgMisNotes, Serializable> {
}
