package com.business.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	


	


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Requied HTTPS
		//http.requiresChannel().anyRequest().requiresSecure();
		// Auth Config
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/dashboard/**").authenticated()
		.antMatchers("/product/**").authenticated()
		.antMatchers("/customer/**").authenticated()
		.antMatchers("/api/**").authenticated()
		.antMatchers("/employees/**").authenticated()
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").permitAll()
		.and()
		.logout().permitAll();
		
		
			
	}

	

}
