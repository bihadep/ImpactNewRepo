package com.patient.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.service.AllergyDataFromDatabaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value ="patient/AllergyDataFromDatabase")
public class AllergyDataFromDatabaseController {

	@Autowired
	private AllergyDataFromDatabaseService allergyDataFromDatabaseService;
	
	@GetMapping("/getAllergyType")
	public ResponseEntity<Set<String>> getAllergyType() {
		log.debug("Starting..  ");
		Set<String> listOfAllergyType = allergyDataFromDatabaseService.getAllergyType();
		return new ResponseEntity<Set<String>>(listOfAllergyType,HttpStatus.OK);
	}
	
	@GetMapping("/getAllergyNameByType/{name}")
	public ResponseEntity<Set<String>> getAllergyNameByType(@PathVariable String name) {
		log.debug("Starting..  ");
		Set<String> listOfAllergyType = allergyDataFromDatabaseService.getAllergyNameByType(name);
		return new ResponseEntity<Set<String>>(listOfAllergyType,HttpStatus.OK);
	}
	
	@GetMapping("/getAllergySourceByTypeAndName/{type}/{name}")
	public ResponseEntity<Set<String>> getAllergySourceByTypeAndName(@PathVariable String type,@PathVariable String name) {
		log.debug("Starting..  ");
		Set<String> listOfAllergyType = allergyDataFromDatabaseService.getAllergyDescriptionByTypeAndName(type,name);
		return new ResponseEntity<Set<String>>(listOfAllergyType,HttpStatus.OK);
	}
	
	@GetMapping("/getAllergyIsoformByTypeAndNameAndDescription/{type}/{name}/{allergen}")
	public ResponseEntity<Set<String>> getAllergyIsoformByTypeAndNameAndDescription(@PathVariable String type,@PathVariable String name,@PathVariable String allergen) {
		log.debug("Starting..  ");
		Set<String> listOfAllergyType = allergyDataFromDatabaseService.getAllergySourceByTypeAndNameAndDescription(type,name,allergen);
		return new ResponseEntity<Set<String>>(listOfAllergyType,HttpStatus.OK);
	}
	
	@GetMapping("/getAllergyID/{type}/{name}/{allergen}/{isoform}")
	public ResponseEntity<Set<String>> getAllergyIdByTypeAndNameAndDescriptionAndIsoform(@PathVariable String type,@PathVariable String name,@PathVariable String allergen,@PathVariable String isoform) {
		log.debug("Starting..  ");
		Set<String> listOfAllergyType = allergyDataFromDatabaseService.getAllergyIdByTypeAndNameAndDescriptionAndIsoform(type,name,allergen,isoform);
		
		return new ResponseEntity<Set<String>>(listOfAllergyType,HttpStatus.OK);
	}
}
