//package com.example.demo.service;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.demo.exception.PatientException;
//import com.example.demo.helper.Helper;
//import com.example.demo.model.Patient;
//import com.example.demo.model.PatientExcelDetails;
//import com.example.demo.repository.PatientExcelRepository;
//
//
//@Service
//public class PatientExcelService {
//	
//	@Autowired
//    private PatientExcelRepository patientRepo;
//
//    public void save(MultipartFile file)throws PatientException {
//
//        try {
//            List<PatientExcelDetails> patients = Helper.convertExcelToListOfPatients(file.getInputStream());
//            //List<Patient> patients = Helper.convertExcelToListOfPatients(file.getInputStream());
//            this.patientRepo.saveAll(patients);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public List<PatientExcelDetails> getAllPatients()throws PatientException {
//        return this.patientRepo.findAll();
//    }
//
//}
