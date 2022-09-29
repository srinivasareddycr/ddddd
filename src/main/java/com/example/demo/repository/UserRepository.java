package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>
{

	
	public User validateUser(String username, String password);
}
