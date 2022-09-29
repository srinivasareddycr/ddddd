package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotBlank;

//import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
//@Table(name = "patients")
public class Patient {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	//@Column(name = "patient_name", nullable = false)
	private String patientName;
	private String patientAddress;
	//private String patientDateofBirth;
	private String patientEmail;
	//@BatchSize(size = 10)
    //@Digits(message="Number should contain 10 digits.", fraction = 0, Long = 10)
    //@NotBlank(message = "mobileNumber is required")
	private Long patientContactNumber;
	private Long patientDrugId;
	private String patientDrugName;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date patientDateOfBirth;
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public Long getPatientContactNumber() {
		return patientContactNumber;
	}
	public void setPatientContactNumber(Long patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}
	public Long getPatientDrugId() {
		return patientDrugId;
	}
	public void setPatientDrugId(Long patientDrugId) {
		this.patientDrugId = patientDrugId;
	}
	public String getPatientDrugName() {
		return patientDrugName;
	}
	public void setPatientDrugName(String patientDrugName) {
		this.patientDrugName = patientDrugName;
	}
	public Date getPatientDateOfBirth() {
		return patientDateOfBirth;
	}
	public void setPatientDateOfBirth(Date patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}

//	@Override
//	public String toString() {
//		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAddress=" + patientAddress
//				+ ", patientEmail=" + patientEmail + ", patientContactNumber=" + patientContactNumber
//				+ ", patientDrugId=" + patientDrugId + ", patientDrugName=" + patientDrugName + ", patientDateOfBirth="
//				+ patientDateOfBirth + "]";
//	}
	
	
}
