package com.java.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.jobportal.model.Job;
import com.java.jobportal.service.JobService;

@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins="*")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		jobService.addJob(job);
		return ResponseEntity.ok("Job Added Successfully!");
	}
	
	@GetMapping("/getAll")
	public List<Job> getAllJobs()
	{
		return jobService.getAllJobs();
	}
	
	@GetMapping("/getJob/{id}")
	public Optional<Job> getJobById(@PathVariable Long id)
	{
		return jobService.getJobById(id);
	}
	
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable long id)
	{
		String result = jobService.deleteJob(id);
		if(result.equals("Job ID not found"))
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job updatedJob)
	{
		Optional<Job> existingJob = jobService.getJobById(id);
		if(!existingJob.isPresent())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job ID not found");
		}
		
		jobService.updateJob(id, updatedJob);
		return ResponseEntity.ok("Job Updated Successfully");
	}
}
