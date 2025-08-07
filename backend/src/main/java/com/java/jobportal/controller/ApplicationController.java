package com.java.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.jobportal.model.Application;
import com.java.jobportal.service.ApplicationService;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins="*")
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping("/apply/{jobId}")
	public Application applyJob(@PathVariable Long jobId, @RequestBody Application application)
	{
		return applicationService.applyJob(jobId, application);
	}
	
	@GetMapping("/all")
	public List<Application> getAllApplications()
	{
		return applicationService.getAllApplication();
	}
	
	@GetMapping("getApplication/{id}")
	public Optional<Application> getApplicationById(@PathVariable Long id)
	{
		return applicationService.getApplicationById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteApplicationById(@PathVariable Long id)
	{
		applicationService.deleteApplicationById(id);
		return "Application Deleted Successfully";
	}

}
