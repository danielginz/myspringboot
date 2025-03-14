package com.tour.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tour.model.User;
import com.tour.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String rawPassword = request.getParameter("password");
		
		if(user == null) {
			throw new UsernameNotFoundException("User name "+username+" not found");
		} else if(rawPassword == null || rawPassword.isBlank()) {
		    throw new IllegalArgumentException("Password can't be empty");
		} else {
			boolean isMatch = new BCryptPasswordEncoder().matches(rawPassword,user.getPassword());
			if(isMatch) {
				user.setPassword(rawPassword);
			}
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), "{noop}"+user.getPassword(), getGrantedAuthorities(user));
	}
	//if you don't add "{noop}", you will get:
    //java.lang.IllegalArgumentException: Given that there is no default password encoder configured, each password must have a password encoding prefix. 
	//Please either prefix this password with '{noop}' or set a default password encoder in `DelegatingPasswordEncoder`.
	
	
	private Collection<GrantedAuthority> getGrantedAuthorities(User user) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if(user.getRole().getName().equals("admin")) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return grantedAuthorities;
		
	}

}
