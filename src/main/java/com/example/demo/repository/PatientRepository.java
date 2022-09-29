package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Patient;


@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findByPatientId(int patientId);

	Patient deleteByPatientId(int patientId);

	
}
