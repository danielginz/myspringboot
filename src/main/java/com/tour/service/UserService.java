package com.tour.service;

import java.util.List;
import java.util.Optional;

import com.tour.model.User;

public interface UserService {
	List<User> userList();
	
	Optional<User> findOne(Long id);
	
	User addUser(User user);
	
	String deleteUser(Long id);
	
	User findByUserName(String name);
}
