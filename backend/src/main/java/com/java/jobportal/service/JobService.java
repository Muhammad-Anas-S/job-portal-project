package com.java.jobportal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.jobportal.model.Job;
import com.java.jobportal.repository.JobRepository;

@Service
public class JobService 
{
	
	@Autowired
	private JobRepository jobRepo;
	
	public Job addJob(Job job)
	{
		job.setPostedDate(LocalDate.now());
		return jobRepo.save(job);
	}
	
	public List<Job> getAllJobs()
	{
		return jobRepo.findAll();
	}
	
	public Optional<Job> getJobById(Long id)
	{
		return jobRepo.findById(id);
	}
	
	public String deleteJob(Long id)
	{
		if(!jobRepo.existsById(id))
		{
			return "Job ID not found";
		}
		jobRepo.deleteById(id);
		return "Job Deleted Successfully";
	}
	
	public void updateJob(Long id, Job updatedJob)
	{
		Job existingJob = jobRepo.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
		
		existingJob.setTitle(updatedJob.getTitle());
		existingJob.setDescription(updatedJob.getDescription());
		existingJob.setCompanyName(updatedJob.getCompanyName());
		existingJob.setLocation(updatedJob.getLocation());
		
		jobRepo.save(existingJob);
	}

}
