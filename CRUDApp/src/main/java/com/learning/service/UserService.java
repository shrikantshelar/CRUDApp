package com.learning.service;

import java.util.List;

import com.learning.model.User;

public interface UserService {

	List<User> findAll();

	User save(User user);

	User findById(Long userId);

	User updateUser(Long userId, User userDetails);

	void deleteUser(Long userId);

}
