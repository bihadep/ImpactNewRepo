package com.patient.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AllergyDataFromDatabaseService {

//	@Autowired
//	private AllergyDataFromDatabaseRepository allergyDataFromDatabaseRepository;

	@PersistenceContext
	private EntityManager em;

	public Set<String> getAllergyType() {
		List<String> listOfAllergyType = em.createNativeQuery("select allergy_type from stored_allegy_table")
				.getResultList();
		Set<String> finalListOfAllergyType = new HashSet<>();
		for (String string : listOfAllergyType) {
			finalListOfAllergyType.add(string);
		}
		return finalListOfAllergyType;
	}

	public Set<String> getAllergyNameByType(String allergyType) {
		List<String> listOfAllergyName = em
				.createNativeQuery(
						"select allergy_name from stored_allegy_table where allergy_type='" + allergyType + "'")
				.getResultList();
		Set<String> finalListOfAllergyName = new HashSet<>();
		for (String string : listOfAllergyName) {
			finalListOfAllergyName.add(string);
		}
		return finalListOfAllergyName;
	}

	public Set<String> getAllergyDescriptionByTypeAndName(String allergyType, String allergyName) {
		List<String> listOfAllergyName = em
				.createNativeQuery("select allergen_source from stored_allegy_table where allergy_type='" + allergyType
						+ "'" + "and allergy_name='" + allergyName + "'")
				.getResultList();
		Set<String> finalListOfAllergyName = new HashSet<>();
		for (String string : listOfAllergyName) {
			finalListOfAllergyName.add(string);
		}
		return finalListOfAllergyName;
	}

	public Set<String> getAllergySourceByTypeAndNameAndDescription(String allergyType, String allergyName,
			String source) {
		List<String> listOfAllergyName = em
				.createNativeQuery("select isoforms from stored_allegy_table where allergy_type='" + allergyType + "'"
						+ "and allergy_name='" + allergyName + "'" + "and allergen_source='" + source + "'")
				.getResultList();
		Set<String> finalListOfAllergyName = new HashSet<>();
		for (String string : listOfAllergyName) {
			finalListOfAllergyName.add(string);
		}
		return finalListOfAllergyName;
	}

	public Set<String> getAllergyIdByTypeAndNameAndDescriptionAndIsoform(String allergyType, String allergyName,
			String source, String isoform) {
		List<String> listOfAllergyName =  em
				.createNativeQuery("select id from stored_allegy_table where allergy_type='" + allergyType + "'"
						+ "and allergy_name='" + allergyName + "'" + "and allergen_source='" + source + "'"+ "and isoforms='" + isoform + "'")
				.getResultList(); 
		Set<String> finalListOfAllergyName = new HashSet<>();
		for (String string : listOfAllergyName) {
			finalListOfAllergyName.add(string);
		}
		return finalListOfAllergyName;
	}
}
