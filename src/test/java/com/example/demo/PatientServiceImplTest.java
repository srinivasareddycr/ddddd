package com.example.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.collection.internal.PersistentList;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.exception.PatientException;
import com.example.demo.exception.UserException;
import com.example.demo.model.Patient;
import com.example.demo.model.User;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import com.example.demo.service.PatientServiceImpl;

//@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PatientServiceImplTest {
	
	@InjectMocks
	private PatientServiceImpl patientService;
	
	@Mock
	private PatientRepository patientRepo;

	@Autowired
	private MockMvc mockMvcObj;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.openMocks(this);
		mockMvcObj = MockMvcBuilders.standaloneSetup(patientService).build();
		
	}
	
	private List<Patient> patientList = new ArrayList<>();
	@Test
    public void testadd() throws PatientException {
		Patient patient=new Patient();
		patient.setPatientId(323);
		patient.setPatientName("Mahesh");
		patient.setPatientAddress("Pune");
		patient.setPatientEmail("mahesh@gmail.com");
		patient.setPatientContactNumber(7722990098L);
		patient.setPatientDrugId(33311122245L);
		patient.setPatientDrugName("Razelgold");
		
//		when(patientRepo.save(patient)).thenReturn(patient);
//		assertEquals(patient,patientService.savePatient(patient));
//		PersistentList.add(patient);
//		 when(patientRepo.save(any())).thenReturn(patient);
//		 Patient p1 = patientService.addPatient(patient);
//		 assertEquals(patient,p1);
//		Mockito.when(patientRepo1.findById(210)).thenReturn(patient);
}   
	
@Test
    public void deletePatient() throws PatientException {
	   Patient patient=new Patient();
	   patientRepo.delete(patient);
       verify(patientRepo,times(1)).delete(patient);
    }

//	@Test
//public void getAllPatientsTest() throws PatientException {
//when(patientRepo.findAll()).thenReturn(Stream.of(new Patient(),new Patient()).collect(Collectors.toList()));
//assertEquals(2, patientService.getAllpatients().size());
//}

}
