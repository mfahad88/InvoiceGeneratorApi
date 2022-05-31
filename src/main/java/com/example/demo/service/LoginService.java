package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;
@Service
public class LoginService {
	
	LoginRepository repository;
	@Autowired
	public LoginService(LoginRepository repository) {
		this.repository = repository;
	}
	
	public Login getLogin(String username,String password) {
		return this.repository.findByUsernamePassword(username, password);
	}
	
	public Login saveLogin(Login login) {
		return this.repository.save(login);
	}
	
}
