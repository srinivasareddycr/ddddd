package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.PatientException;
import com.example.demo.exception.UserException;
import com.example.demo.model.User;

public interface UserService {
	
	public User addUser(User user)throws UserException;
	
	public  List<User> getAllUsers()throws UserException;
	
	public boolean validateUserLogin(String username, String password)throws UserException;


}
