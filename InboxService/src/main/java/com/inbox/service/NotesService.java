package com.inbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inbox.entity.Notes;
import com.inbox.repo.NotesRepo;

@Service
public class NotesService {

	@Autowired
	NotesRepo notesRepo;

	public void sendNote(Notes note) {
		notesRepo.save(note);
	}

	public List<Notes> getDoctorNotesByEmployeeId(String empId) {
		return notesRepo.findByToEmployeeId(empId);
	}

	public long getNotesCountByEmployeeId(String empId) {
		return notesRepo.getNotesCountByEmployeeId(empId);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<Notes> getNotesByUserId(String id) {
//		if (!ObjectUtils.isEmpty(id)) {
//			if (id.startsWith("DR") || id.startsWith("NR")) {
//				return notesRepo.findByToEmployeeIdAndIsReply(id, false);
//			} else {
//				return notesRepo.findByToIdAndIsReply(Long.parseLong(id), false);
//			}
//		}else {
//			return new ArrayList<>();	
//		}
//	}
	
//	public long getNotesCountByUserId(String id) {
//		if (!ObjectUtils.isEmpty(id)) {
//			if (id.startsWith("DR") || id.startsWith("NR")) {
//				return notesRepo.getNotesCountByEmployeeId(id);
//			} else {
//				return notesRepo.getNotesCountById(Long.parseLong(id));
//			}
//		}else {
//			return 0L;	
//		}
//	}
}
