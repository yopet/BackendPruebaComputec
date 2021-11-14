package com.crud.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.prueba.model.User;
import com.crud.prueba.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	UserService userService;

	// creating a get mapping that retrieves all the User detail from the database
	@GetMapping("/users")
	private List<User> getAllUser() {
		return userService.getAllUser();
	}

	// creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/users/{userid}")
	private Optional<User> getUser(@PathVariable("userid") Long userid) {
		return userService.getUserById(userid);
	}

	// creating a delete mapping that deletes a specified book
	@DeleteMapping("/users/{userid}")
	private void deleteBook(@PathVariable("userid") Long userid) {
		userService.delete(userid);
	}

	// creating post mapping that post the book detail in the database
	@PostMapping("/users")
	private Long saveBook(@RequestBody User User) {
		userService.saveOrUpdate(User);
		return User.getId();
	}

	// creating put mapping that updates the book detail
	@PutMapping("/users")
	private User update(@RequestBody User User) {
		userService.saveOrUpdate(User);
		return User;
	}

}
