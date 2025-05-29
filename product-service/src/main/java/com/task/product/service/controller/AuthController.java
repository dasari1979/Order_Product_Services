package com.task.product.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.product.service.dto.LoginResponse;
import com.task.product.service.entity.LoginRequest;
import com.task.product.service.gentoken.JwtUtil;
import com.task.product.service.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
       
    	LoginRequest credentials = loginService.login(request);
        if (!credentials.getEmail().isEmpty()) {
        	log.info("Credentials:  "+credentials.getEmail()+" "+credentials.getPassword());
            String token = jwtUtil.generateToken(credentials.getEmail());
            log.info("Token: "+token);
            return new LoginResponse(token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
