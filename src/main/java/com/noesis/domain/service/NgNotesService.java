package com.noesis.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgDlrNotes;
import com.noesis.domain.persistence.NgMisNotes;
import com.noesis.domain.repository.NgDlrNotesRepository;
import com.noesis.domain.repository.NgMisNotesRepository;

@Service
public class NgNotesService {
	
	@Autowired
	NgMisNotesRepository misNotesRepository;
	
	@Autowired
	NgDlrNotesRepository dlrNotesRepository;
	
	public void createAndUpdateMisNotes(String messageId, String comments) {
		NgMisNotes notes = new NgMisNotes();
		notes.setComments(comments);
		notes.setMessageId(messageId);
		notes.setCreatedDate(new Date());
		misNotesRepository.save(notes);
	}
	
	public void createAndUpdateDlrNotes(String messageId, String comments) {
		NgDlrNotes notes = new NgDlrNotes();
		notes.setComments(comments);
		notes.setMessageId(messageId);
		notes.setCreatedDate(new Date());
		dlrNotesRepository.save(notes);
	}
	
}
