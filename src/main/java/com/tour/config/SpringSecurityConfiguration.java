package com.tour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tour.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity//(prePostEnabled = true)
public class SpringSecurityConfiguration {
	
	/*@Autowired
	private AuthenticationEntryPoint entryPoint;*/
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	/*public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}*/
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//without "and().csrf().disable()" you will get "Invalid CSRF token found for http://localhost:9090/myspringboot/user/delete/152"
		//http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(entryPoint).and().csrf().disable();
		//http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated().and()).httpBasic().authenticationEntryPoint(entryPoint).and().csrf().disable();
		
		
		//code from the lesson
		/*http
		.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated().and())
			                  .httpBasic().and().formLogin().loginPage("/user/login").permitAll().and().logout().permitAll();*/
		
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

		SimpleUrlLogoutSuccessHandler logoutSuccessHandler = new SimpleUrlLogoutSuccessHandler();
		logoutSuccessHandler.setDefaultTargetUrl("/user/login?logout");
		
		http
		.authorizeHttpRequests((requests) -> requests
	            .requestMatchers(new AntPathRequestMatcher("/user/login")).permitAll()
	            .anyRequest().authenticated()) //other URLs are only allowed authenticated users.
				.httpBasic().and()
				.logout(logout -> {
					try {
						logout
						        .logoutUrl("/logout") // Specifies the URL endpoint for logging out, so users will log out by accessing "/logout"
						        .addLogoutHandler(logoutHandler) // Adds a custom logout handler (logoutHandler) to handle the logout process
						        .logoutSuccessHandler(logoutSuccessHandler) // Specifies what to do after a successful logout, using a custom success handler
						        .clearAuthentication(true).invalidateHttpSession(true).deleteCookies("remember-me")
						        .permitAll().and().rememberMe().tokenValiditySeconds(180);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}) // Allows all users to access the logout endpoint without authentication
						
				.formLogin().failureUrl("/user/login?error").and()
				.csrf().disable();
		
		
		
        return http.build();
        
    }
	
	//put this method to prevent the following exception 
	//"org.springframework.security.web.firewall.RequestRejectedException: The request was rejected because the URL contained a potentially malicious String "//"
	@Bean
	public HttpFirewall allowDoubleSlashHttpFirewall() {
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowUrlEncodedDoubleSlash(true);
	    return firewall;
	}
	
	/*
	https://www.javainuse.com/onlineBcrypt
	password (bcrypt)
	$2a$10$OLMQCXP/EQR76sUj7rULHefVZ6/N.u9g2c6uStD5sGpABNsnebBLm
	$2a$10$MjNvuRoxpxYIVXRjzX2FuO7i5z4qkci0wzzGq89M7Z1R6v71OaVlC
	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
