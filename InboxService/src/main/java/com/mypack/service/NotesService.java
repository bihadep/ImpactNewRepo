package com.mypack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mypack.entity.Notes;
import com.mypack.repo.NotesRepo;

@Service
public class NotesService {

	@Autowired
	NotesRepo notesRepo;

	public void sendNote(Notes note) {
		Long fromId = Long.parseLong(note.getFromEmployeeId().substring(2, note.getFromEmployeeId().length()));
		note.setFromId(fromId);
		Long toId = Long.parseLong(note.getToEmployeeId().substring(2, note.getToEmployeeId().length()));
		note.setToId(toId);
		notesRepo.save(note);
	}

	public List<Notes> getNotesByUserId(String id) {
		if (!ObjectUtils.isEmpty(id)) {
			if (id.startsWith("DR") || id.startsWith("NR")) {
				return notesRepo.findByToEmployeeIdAndIsReply(id, false);
			} else {
				return notesRepo.findByToIdAndIsReply(Long.parseLong(id), false);
			}
		}else {
			return new ArrayList<>();	
		}
	}
	
	public long getNotesCountByUserId(String id) {
		if (!ObjectUtils.isEmpty(id)) {
			if (id.startsWith("DR") || id.startsWith("NR")) {
				return notesRepo.getNotesCountByEmployeeId(id);
			} else {
				return notesRepo.getNotesCountById(Long.parseLong(id));
			}
		}else {
			return 0L;	
		}
	}
}
