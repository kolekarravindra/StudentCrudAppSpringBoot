package com.example.studentCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentCrud.domain.Login;
import com.example.studentCrud.repository.LoginRepository;



@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	  
	  public Login login(String username, String password) {
	  Login user = repo.findByUsernameAndPassword(username, password);
	   return user;
	  }
	  
	  public void save(Login std) {
	        repo.save(std);
	    }
	 
}
