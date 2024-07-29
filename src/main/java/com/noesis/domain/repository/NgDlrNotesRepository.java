package com.noesis.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.noesis.domain.persistence.NgDlrNotes;

public interface NgDlrNotesRepository extends CrudRepository<NgDlrNotes, Serializable> {
}
