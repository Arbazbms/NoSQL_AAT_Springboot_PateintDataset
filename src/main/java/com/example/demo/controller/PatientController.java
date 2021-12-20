package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	public PatientRepository patientRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@GetMapping(value = "/all")
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@PostMapping(value = "/create")
	public Patient createPatient(@RequestBody Patient patient) {
		Patient insertedPatient = patientRepository.insert(patient);
		return insertedPatient;

	}

	@GetMapping(value = "/{id}")
	public Optional<Patient> getPatientById(@PathVariable String id) {
		Optional<Patient> patient = patientRepository.findById(id);
		return patient;

	}

	@DeleteMapping("/{id}")
	public String deletePatient(@PathVariable String id) {
		patientRepository.deleteById(id);
		return "deleted: " + id;

	}

	@PutMapping("/{id}")
	public Patient updatePatient(@RequestBody Patient patient, @PathVariable String id) {
		patient.setId(id);
		patientRepository.save(patient);
		return patient;
	}

	// Analytics Queries
	@GetMapping("/analytic1")
	public long analyticQuery1() {
		Query query = new Query();
		query.addCriteria(Criteria.where("HeartDisease").is(1));
		long patients = mongoTemplate.count(query, Patient.class);
		return patients;
	}

	@GetMapping("/analytic2")
	public long analyticQuery2() {
		Query query = new Query();
		query.addCriteria(Criteria.where("Age").lt(50).gt(20));
		query.addCriteria(Criteria.where("HeartDisease").is(1));
		long patients = mongoTemplate.count(query, Patient.class);
		return patients;
	}

	@GetMapping("/analytic3")
	public Map<String, Long> analyticQuery3() {

		Map<String, Long> map = new HashMap();
		Query query = new Query();
		query.addCriteria(Criteria.where("Sex").is("M"));
		query.addCriteria(Criteria.where("HeartDisease").is(1));
		long male = mongoTemplate.count(query, Patient.class);

		map.put("Male", male);

		return map;
	}
	
	@GetMapping("/analytic4")
	public Map<String, Long> analyticQuery4() {

		Map<String, Long> map = new HashMap();
		Query query = new Query();
		query.addCriteria(Criteria.where("Sex").is("F"));
		query.addCriteria(Criteria.where("HeartDisease").is(1));
		long male = mongoTemplate.count(query, Patient.class);

		map.put("FeMale", male);

		return map;
	}

}
