package com.java.jobportal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.jobportal.model.Application;
import com.java.jobportal.model.Job;
import com.java.jobportal.repository.ApplicationRepository;
import com.java.jobportal.repository.JobRepository;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository appRepo;
	
	@Autowired
	private JobRepository jobRepo;
	
	public Application applyJob(Long id, Application application)
	{
		Optional<Job> jobOptional = jobRepo.findById(id);
		if(jobOptional.isPresent())
		{
			application.setJob(jobOptional.get());
			application.setAppliedDate(LocalDate.now());
			return appRepo.save(application);
		}
		else
		{
			throw new RuntimeException("Job ID  not found");
		}
		
	}
	
	public List<Application> getAllApplication()
	{
		return appRepo.findAll();
	}
	
	public Optional<Application> getApplicationById(Long id)
	{
		return appRepo.findById(id);
	}
	
	public void deleteApplicationById(Long id)
	{
		appRepo.deleteById(id);
	}

}
