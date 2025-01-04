package com.tour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.tour.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration {
	
	@Autowired
	private AuthenticationEntryPoint entryPoint;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	/*public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}*/
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic().authenticationEntryPoint(entryPoint);//always redirects to commence and throws "full authentication is required to access this resource"
        http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(entryPoint);;
        return http.build();
    }
}
