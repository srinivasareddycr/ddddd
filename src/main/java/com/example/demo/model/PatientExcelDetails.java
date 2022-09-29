//package com.example.demo.model;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//@Entity
//public class PatientExcelDetails {
//	
//
//	@Id
//	//@GeneratedValue(strategy = GenerationType.AUTO)
//	private int patientId;
//	//@Column(name = "patient_name", nullable = false)
//	private String patientName;
//	private String patientAddress;
//	//private String patientDateofBirth;
//	private String patientEmail;
//	private Long patientContactNumber;
//	private Long patientDrugId;
//	private String patientDrugName;
////	@JsonFormat(pattern="yyyy-MM-dd")
//	private Date patientDob;
//	
//	
////	public PatientExcelDetails(int patientId, String patientName, String patientAddress, String patientEmail,
////			Long patientContactNumber, Long patientDrugId, String patientDrugName, Date patientDOB) {
////		super();
////		this.patientId = patientId;
////		this.patientName = patientName;
////		this.patientAddress = patientAddress;
////		this.patientEmail = patientEmail;
////		this.patientContactNumber = patientContactNumber;
////		this.patientDrugId = patientDrugId;
////		this.patientDrugName = patientDrugName;
////		this.patientDOB = patientDOB;
////	}
//	public int getPatientId() {
//		return patientId;
//	}
//	public void setPatientId(int patientId) {
//		this.patientId = patientId;
//	}
//	public String getPatientName() {
//		return patientName;
//	}
//	public void setPatientName(String patientName) {
//		this.patientName = patientName;
//	}
//	public String getPatientAddress() {
//		return patientAddress;
//	}
//	public void setPatientAddress(String patientAddress) {
//		this.patientAddress = patientAddress;
//	}
//	public String getPatientEmail() {
//		return patientEmail;
//	}
//	public void setPatientEmail(String patientEmail) {
//		this.patientEmail = patientEmail;
//	}
//	public Long getPatientContactNumber() {
//		return patientContactNumber;
//	}
//	public void setPatientContactNumber(Long patientContactNumber) {
//		this.patientContactNumber = patientContactNumber;
//	}
//	public Long getPatientDrugId() {
//		return patientDrugId;
//	}
//	public void setPatientDrugId(Long patientDrugId) {
//		this.patientDrugId = patientDrugId;
//	}
//	public String getPatientDrugName() {
//		return patientDrugName;
//	}
//	public void setPatientDrugName(String patientDrugName) {
//		this.patientDrugName = patientDrugName;
//	}
//	public Date getPatientDob() {
//		return patientDob;
//	}
//	public void setPatientDob(Date patientDob) {
//		this.patientDob = patientDob;
//	}
//	
//	
//
//}
