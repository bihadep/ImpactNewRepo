package com.inbox.controller;

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

import com.inbox.dto.SuccessResponse;
import com.inbox.entity.Notes;
import com.inbox.service.NotesService;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:9091")
public class NotesController {

	@Autowired
	NotesService notesService;

	@PostMapping("/sendNote")
	public SuccessResponse sendNote(@RequestBody Notes notes) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n   "+notes);
		notesService.sendNote(notes);
		SuccessResponse response = new SuccessResponse(HttpStatus.OK, "Notes sent");
		return response;
	}


	@GetMapping("/getNotes/{empId}")
	public List<Notes> getDoctorNotesByEmployeeId(@PathVariable("empId") String empId) {
		return notesService.getDoctorNotesByEmployeeId(empId);
	}


	@GetMapping("/getNotesCount/{empId}")
	public long getNotesCount(@PathVariable("empId") String empId) {
		return notesService.getNotesCountByEmployeeId(empId);
	}




}
