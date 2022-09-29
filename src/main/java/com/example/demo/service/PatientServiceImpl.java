package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.PatientException;
import com.example.demo.helper.Helper;
import com.example.demo.model.Patient;
//import com.example.demo.model.PatientExcelDetails;
//import com.example.demo.repository.PatientExcelRepository;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepo1;
	
	@Override
	public Patient savePatient(Patient patient)throws PatientException {
		if(patient.getPatientContactNumber().toString().length()==10)
		{
		return patientRepo1.saveAndFlush(patient);
		}
		else
		{
			throw new PatientException("Contact number should be 10 digit number");
		}
		
		
	}


	@Override
	public Patient getPatientByPatientId(int patientId)throws PatientException {
		Patient patient=patientRepo1.findByPatientId(patientId);
		return patient;
	}
	


	@Override
	public List<Patient> getAllpatients()throws PatientException {
		List<Patient> patientList = patientRepo1.findAll();
		if (patientList != null && patientList.size() > 0) {
			return patientList;
		}
		return null;
	}

	@Override
	public boolean updatePatient(Patient patient,int patientId) throws PatientException {
		Patient patient1 = patientRepo1.findByPatientId(patientId);
		if (patient1 != null) {
			
		
		patient1.setPatientName(patient.getPatientName());
		patient1.setPatientAddress(patient.getPatientAddress());
		patient1.setPatientEmail(patient.getPatientEmail());
		patient1.setPatientContactNumber(patient.getPatientContactNumber());
		patient1.setPatientDateOfBirth(patient.getPatientDateOfBirth());
		
		patientRepo1.save(patient1);
		}
		return true;

	}


	@Override
	public boolean deletePatientByPatientId(int patientId) throws PatientException {
		patientRepo1.deleteById(patientId);
		return true;
	}


	
	@Autowired
    private PatientRepository patientRepo;

    public void save(MultipartFile file)throws PatientException {

        try {
            List<Patient> patients = Helper.convertExcelToListOfPatients(file.getInputStream());
            this.patientRepo1.saveAll(patients);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
