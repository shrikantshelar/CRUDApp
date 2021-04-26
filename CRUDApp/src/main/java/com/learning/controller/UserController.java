package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.User;
import com.learning.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	// Get All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return userService.findAll();
	}
	
	// Create a new User
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
	    return userService.save(user);
	}
	
	// Get a Single User
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
	    return userService.findById(userId);
	}
	
	// Update a User
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
		return userService.updateUser(userId, userDetails);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    userService.deleteUser(userId);
	    return ResponseEntity.ok().build();
	}
}
