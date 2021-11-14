package com.crud.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.prueba.model.User;
import com.crud.prueba.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	// getting all User record by using the method findaAll() of CrudRepository
	public List<User> getAllUser() {		
		return userRepository.findAll();
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	// updating a record
	public void update(User user, int userid) {
		userRepository.save(user);
	}

}
