package com.java.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.jobportal.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
