package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping(value = "/all")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	@PostMapping(value = "/create")
	public Patient createPatient(@RequestBody Patient patient) {
		Patient insertedPatient = patientRepository.insert(patient);
		return insertedPatient;
		
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Patient> getPatientById(@PathVariable String id){
		Optional<Patient> patient =  patientRepository.findById(id);
		return patient;
		
	}
	
	@DeleteMapping("/{id}")
	public String deletePatient(@PathVariable String id){
		patientRepository.deleteById(id);
		return "deleted: " + id;
		
	}
	
	@PutMapping("/{id}")
	public Patient updatePatient(@RequestBody Patient patient, @PathVariable String id) {
		patient.setId(id);
		patientRepository.save(patient);
		return patient;
	}
	
	
	
}
