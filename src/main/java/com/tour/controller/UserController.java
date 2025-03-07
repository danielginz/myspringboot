package com.tour.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tour.model.User;
import com.tour.service.UserService;

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	@Autowired
	//better to go with constructor injection
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/login")
	public String login(Model model, String error, String logout) {
		if(error != null) {
			model.addAttribute("error", "Your username and password is invalid");
		}
		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully");
		}
		
		return "welcome";
	}
		
	@GetMapping("/form")
	public String userForm(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", userService.roleList());
		return "user/form";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("userForm", userService.findOne(id));
		model.addAttribute("roles", userService.roleList());
		return "user/form";
	}
	
	
	
	@RequestMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteUser(@PathVariable Long id, Model model) {
		model.addAttribute("message", userService.deleteUser(id));
		return "message";
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addUser(@ModelAttribute User user, Model model) {//(@RequestBody User user) {
		String message = "";
		if(user.getId() == null) {
			message = " added";
		} else {
			message = " updated";
		}
		model.addAttribute("message", userService.addUser(user).getUserName()+message+" successfully");
		return "message";
	}
	
	@GetMapping("/list/{id}")
	public Optional<User> findOne(@PathVariable Long id) {
		return userService.findOne(id);
	}
	
	/*@RequestMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public List<User> userList(){
		return userService.userList();
	}*/
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String userList(Model model ){
		model.addAttribute("users", userService.userList());
		return "/user/list";
	}
	
	@RequestMapping("/get/{name}")
	public User findByUserName(@PathVariable String name) {
		return userService.findByUserName(name);
	}
}
