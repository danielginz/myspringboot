package com.tour.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.model.User;
import com.tour.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	@Autowired
	//better to go with constructor injection
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
	
	@RequestMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping("/list/{id}")
	public Optional<User> findOne(@PathVariable Long id) {
		return userService.findOne(id);
	}
	
	@RequestMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public List<User> userList(){
		return userService.userList();
	}
	
	@RequestMapping("/get/{name}")
	public User findByUserName(@PathVariable String name) {
		return userService.findByUserName(name);
	}
}
