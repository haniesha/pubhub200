package com.boot.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.boot.model.User;

import com.boot.repository.UserRepository;

@Service
public class UserService {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	
	private UserRepository userrepository;

	@Transactional
	public User save(@NotNull @Valid final User user) {
		LOGGER.debug("Creating {}", user);
		return userrepository.save(user);
	}

	@Transactional
	public List<User> getList() {
		LOGGER.debug("Retrieving the list of all Users");
		return userrepository.findAll();
	}
	@Transactional
	public User login(String username,String password) {
		LOGGER.debug("Creating {}", username,password);
		return userrepository.loginUser(username,password);
	}
	

	
}
