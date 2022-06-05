package com.example.demo.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	LoginService service;
	@Autowired
	public LoginController(LoginService service) {
		this.service = service;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/login")
	public ResponseEntity login(@RequestParam("username")String username,@RequestParam("password")String password) {
		if(this.service.getLogin(username, password)!=null) {
			return new ResponseEntity(this.service.getLogin(username, password), HttpStatus.OK);
		}else {
			return new ResponseEntity("Invalid Login", HttpStatus.UNAUTHORIZED);
		}
	}
	


	
	
}
