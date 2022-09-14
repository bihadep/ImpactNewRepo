package com.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.dto.SuccessResponse;
import com.mypack.entity.Notes;
import com.mypack.service.NotesService;

@RestController
@RequestMapping("/notes")
@CrossOrigin
public class NotesController {

	@Autowired
	NotesService notesService;

	@PostMapping("/sendNote")
	public SuccessResponse sendNote(@RequestBody Notes notes) {
		notesService.sendNote(notes);
		SuccessResponse response = new SuccessResponse(HttpStatus.OK, "Notes sent");
		return response;
	}

	@GetMapping("/getNotes/{userId}")
	public List<Notes> getDoctorNotesByUserId(@PathVariable("userId") String userId) {
		return notesService.getNotesByUserId(userId);
	}

	@GetMapping("/getNotesCount/{userId}")
	public long getNotesCount(@PathVariable("userId") String userId) {
		return notesService.getNotesCountByUserId(userId);
	}

}
