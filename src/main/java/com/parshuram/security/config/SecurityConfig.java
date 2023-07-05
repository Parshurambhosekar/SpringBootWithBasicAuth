package com.parshuram.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		

		http.csrf()
			.disable()
			.authorizeHttpRequests()
			.antMatchers("/","/{id}")//that url request are authenticated
			.authenticated()
			.and()
			.httpBasic();
		
		/*http.csrf()
			.disable()
			.authorizeHttpRequests()
			.antMatchers(HttpMethod.GET)  GET request is Authorized only
			.authenticated()
			.and()
			.httpBasic();*/
				
		/*http.csrf()
			.disable()
			.authorizeHttpRequests()
			.anyRequest()
			.authenticated()  all request need Authentication
			.and()
			.httpBasic();*/
		
		return http.build();
	}
	

}
