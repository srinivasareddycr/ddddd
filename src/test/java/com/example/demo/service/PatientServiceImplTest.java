//package com.example.demo.service;
//
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.Optional;
//
////import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
////import org.springframework.web.multipart.MultipartFile;
//
//import com.example.demo.exception.PatientException;
//import com.example.demo.model.Patient;
//import com.example.demo.repository.PatientRepository;
//
//@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
////@SpringBootTest
//public class PatientServiceImplTest {
//
//	@InjectMocks
//	private PatientService patientService;
//	
//	@Mock
//	private PatientRepository patientRepo;
//	
//	
//	@Test
//	 public void testsave() throws PatientException {
//		Patient patient = new Patient();
//		patient.setPatientId(210);
//		patient.setPatientName("Mahesh");
//		patient.setPatientAddress("Pune");
//		patient.setPatientEmail("mahesh@gmail.com");
//		patient.setPatientContactNumber(7722990098L);
//		patient.setPatientDrugId(33311122245L);
//		patient.setPatientDrugName("Razelgold");
//		
//		Mockito.when(patientRepo.findById(210)).thenReturn(Optional.ofNullable(patient));
//		// when(patientRepo.findById(210)).thenReturn(patient);
//	}
////	@Test
////	@DisplayName("Find patient by patientId")
////    public void shouldFindPatientByPatientId() {
////		int patientId = 210;
////		equals(patientId);
////		}
////	
//	
//	}
//
//
