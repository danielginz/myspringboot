package com.tour.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.model.User;
import com.tour.repository.UserRepository;
import com.tour.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findOne(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "{'message':'User deleted successfully.'}";
	}

	@Override
	public User findByUserName(String name) {//aaa
		return userRepository.findByUsername(name);
	}
}
