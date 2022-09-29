package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.PatientException;
import com.example.demo.model.Patient;

public interface PatientService {
	
	public Patient savePatient(Patient patient)throws PatientException;

	public Patient getPatientByPatientId(int patientId)throws PatientException;
	
    public List<Patient> getAllpatients()throws PatientException;

	 public boolean updatePatient(Patient patient,int patientId) throws PatientException;
	 
	 public boolean deletePatientByPatientId(int patientId) throws PatientException;

	//public List<Patient> getAllPatients()throws PatientException;

	public void save(MultipartFile file) throws PatientException;

	//public Patient addPatient(Patient patient);

	//public void save(MultipartFile file);



}
