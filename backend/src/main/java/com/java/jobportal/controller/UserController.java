package com.java.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.jobportal.model.User;
import com.java.jobportal.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user)
	{
		if(userRepository.findByUsername(user.getUsername()).isPresent())
		{
			return "Username Already Exist";
		}
		userRepository.save(user);
		return "User Registered Successfully";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody User user)
	{
		return userRepository.findByUsername(user.getUsername())
				.map(u ->  u.getPassword().equals(user.getPassword()) ? "Login Success " + u.getRole() : "Invalid Password")
				.orElse("User Not found");
	}
	
}
