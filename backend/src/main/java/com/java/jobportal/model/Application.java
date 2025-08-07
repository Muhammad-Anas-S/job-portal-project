package com.java.jobportal.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;
	
	private String applicantName;
	private String email;
	private String phone;
	private LocalDate appliedDate;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;
	
	public Application()
	{
		
	}
	
	public Application(String applicantName, String email, String phone, LocalDate appliedDate, Job job)
	{
		this.setApplicantName(applicantName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setAppliedDate(appliedDate);
		this.job=job;
	}
	
	public Long getApplicationId()
	{
		return applicationId;
	}
	public void setApplicationId(Long applicationId)
	{
		this.applicationId=applicationId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}
	
	public Job getJob()
	{
		return job;
	}
	public void setJob(Job job)
	{
		this.job=job;
	}
	
}
