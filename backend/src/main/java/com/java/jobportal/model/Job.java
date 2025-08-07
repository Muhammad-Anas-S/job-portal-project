package com.java.jobportal.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="job_postings")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long jobId;
	private String title;
	private String description;
	private String companyName;
	private String location;
	private LocalDate postedDate;
	
	public Job()
	{
		
	}
	
	public Job(String title, String description, String companyName, String location, LocalDate postedDate)
	{
		this.setTitle(title);
		this.setDescription(description);
		this.setCompanyName(companyName);
		this.setLocation(location);
		this.setPostedDate(postedDate);
	}
	
	public Long getJobId()
	{
		return jobId;
	}
	public void setJobId(Long jobId)
	{
		this.jobId=jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

}
