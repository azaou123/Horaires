package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable() // Disable CSRF protection
	        .authorizeRequests()
	            .requestMatchers("/api/**").permitAll() // Permit all other requests
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic();
	    return http.build();
	}

}