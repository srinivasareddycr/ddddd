//package com.example.demo.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.demo.exception.PatientException;
//import com.example.demo.helper.Helper;
//import com.example.demo.model.PatientExcelDetails;
//import com.example.demo.service.PatientExcelService;
//
//@RestController
//@CrossOrigin("*")
//public class PatientExcelController {
//	
//	 @Autowired
//	    private PatientExcelService patientService;
//
//	    @PostMapping("/details/upload")
//	    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws PatientException {
//	    	
////	    	Thread.sleep( 5000);
//	        if (Helper.checkExcelFormat(file)) {
//	            //true
//
//	            this.patientService.save(file);
//
//	            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
//
//
//	        }
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
//	    }
//
//
//	    @GetMapping("/patient")
//	    public List<PatientExcelDetails> getAllPatient()throws PatientException {
//	        return this.patientService.getAllPatients();
//	    }
//
//
////@ExceptionHandler(PatientException.class)
////@ResponseStatus(HttpStatus.NOT_FOUND)
////public ResponseEntity<String> handlePatientException(PatientException exception){
////return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
////}
//}
