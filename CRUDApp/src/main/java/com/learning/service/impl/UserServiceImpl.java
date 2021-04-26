package com.learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.exception.ResourceNotFoundException;
import com.learning.model.User;
import com.learning.repository.UserRepository;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}

	@Override
	public User updateUser(Long userId, User userDetails) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setUserName(userDetails.getUserName());
		user.setAddress(userDetails.getAddress());
		user.setContactNumber(userDetails.getContactNumber());
		User updatedUser = userRepository.save(user);
	    return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		userRepository.delete(user);
	}

}
