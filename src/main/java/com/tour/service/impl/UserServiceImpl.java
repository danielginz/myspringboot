package com.tour.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tour.model.Role;
import com.tour.model.User;
import com.tour.repository.RoleRepository;
import com.tour.repository.UserRepository;
import com.tour.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	//@Autowired
	private UserRepository userRepository;
	
	private RoleRepository roleRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
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
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		
		boolean isMatch = new BCryptPasswordEncoder().matches(user.getPassword(), encodedPassword);
		System.out.println("AAA, addUser, isMatch: " + isMatch);
		
		user.setPassword(encodedPassword);//TODO if isMatch==true don't update password
		Role role = roleRepository.findById(user.getRole().getId()).get();
		user.setRole(role);
		
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "User deleted successfully";
	}
	
	@Override
	public List<Role> roleList() {
		return roleRepository.findAll();
	}

	@Override
	public User findByUserName(String name) {
		return userRepository.findByUsername(name);
	}

}
