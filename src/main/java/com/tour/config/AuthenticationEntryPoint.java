package com.tour.config;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.addHeader("WWW-Authenticate", "Basic realm - " + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("Http Status 401 "+authException.getMessage());
	}
	
	@Override
	public void afterPropertiesSet(){
		setRealmName("DanielJava");
		super.afterPropertiesSet();
	}
	
	
	
}
