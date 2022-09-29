package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.PatientException;
import com.example.demo.helper.Helper;
import com.example.demo.model.Patient;
//import com.example.demo.model.PatientExcelDetails;
import com.example.demo.model.User;
import com.example.demo.service.PatientService;

@CrossOrigin("*")
@RestController
@RequestMapping("patient")
public class PatientController {
	
	@Autowired
 	private PatientService patientService;
	
	@PostMapping("/registerPatient")
 	public ResponseEntity<?> addPatient(@RequestBody Patient patient)throws PatientException
 	{
 		if(patientService.savePatient(patient)!=null)
		{
			return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
	}
 		return new ResponseEntity<String>("patient is not registered", HttpStatus.CREATED);
 	}
	
	@GetMapping("/info/{patientId}")
    public ResponseEntity<?> getPatientByPatientId(@PathVariable int patientId)throws PatientException{
		
		
		return new ResponseEntity<Patient>(patientService.getPatientByPatientId(patientId),HttpStatus.OK);
	}
	
	
	@GetMapping("/getalls")
    public ResponseEntity<?> getAllPatients()throws PatientException
    {
		List<Patient> patientList = patientService.getAllpatients();
		
		if(patientList!=null)
		{
			return new ResponseEntity<List<Patient>>(patientList,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Patient list is empty",HttpStatus.OK);
	}
	

	@PutMapping("/update/{patientId}")
    public ResponseEntity<?> updatePatient(@PathVariable int patientId, @RequestBody Patient patient)throws PatientException{
		
		patientService.updatePatient(patient, patientId);
		return new ResponseEntity<String>("Patient details updated successfuly",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{patientId}")
    public ResponseEntity<?> deletePatientByPatientId(@PathVariable int patientId)throws PatientException{
		if(patientService.deletePatientByPatientId(patientId))
		{
			return new ResponseEntity<String>("Patient deleted successfull",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Patient cannot be deleted",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/details/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws PatientException {
    	
//    	Thread.sleep( 5000);
        if (Helper.checkExcelFormat(file)) {
            //true

            this.patientService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/patientdetails")
    public List<Patient> getAllPatient()throws PatientException {
        return this.patientService.getAllpatients();
    }

	

//    @PostMapping("/details/upload")
//    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)throws PatientException {
//        if (Helper.checkExcelFormat(file)) {
//            //true
//
//            this.patientService.save(file);
//
//            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
//
//
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
//    }

@ExceptionHandler(PatientException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ResponseEntity<String> handlePatientException(PatientException exception){
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
}
	
}
