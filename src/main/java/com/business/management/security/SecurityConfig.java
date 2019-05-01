package com.business.management.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.business.management.service.UserService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserService service;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Requied HTTPS
		//http.requiresChannel().anyRequest().requiresSecure();
		// Auth Config
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/dashboard/**").authenticated()
		.antMatchers("/product/**").authenticated()
		.antMatchers("/customer/**").hasRole("ADMIN")
		.antMatchers("/api/**").authenticated()
		.antMatchers("/employees/**").authenticated()
		.and().exceptionHandling().accessDeniedPage("/access-denied")
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").permitAll()
		.and()
		.logout().permitAll();
		
		
			
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

	

}
