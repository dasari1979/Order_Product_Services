package com.task.product.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.product.service.entity.LoginRequest;
import com.task.product.service.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public LoginRequest login(LoginRequest loginRequest) {
		loginRequest.setPassword(passwordEncoder.encode(loginRequest.getPassword()));
		if(loginRepository.findByEmail(loginRequest.getEmail()).isEmpty())
		     return loginRepository.save(loginRequest);
		else
			return loginRequest;
	}

}
